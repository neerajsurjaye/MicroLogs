package io.micrologs.notification.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.rabbitmq.client.Channel;

import io.micrologs.notification.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CassandraService {

    private CqlSession cqlSession;
    private final PreparedStatement notificationInsertStatement;
    private final RabbitService rabbitService;
    private final Semaphore semaphore = new Semaphore(50);

    public CassandraService(CqlSession cqlSession, RabbitService rabbitService) {
        this.cqlSession = cqlSession;
        this.notificationInsertStatement = this.cqlSession.prepare("""
                INSERT INTO micrologs.notifications
                (userid, notification_id, title, description, emmited_at, message_read, service)
                values
                (?, ?, ?, ?, ? , ?, ?);
                """);

        this.rabbitService = rabbitService;
    }

    public void saveNotification(NotificationDTO notification, Channel channel, long messageTag) {
        BoundStatement notificationBoundStmt = notificationInsertStatement.bind()
                .setString(0, notification.getUserid())
                .setUuid(1, UUID.randomUUID())
                .setString(2, notification.getTitle())
                .setString(3, notification.getDescription())
                .setInstant(4, Instant.now())
                .setBoolean(5, false)
                .setString(6, notification.getServiceName());

        log.error("====INNSERTING DTO==== : {}", notification);

        try {
            semaphore.acquire();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            rabbitService.ackMessage(channel, messageTag, false);
            log.error("Interrupted while acquiring semaphore", ex);
            return;
        }
        cqlSession
                .executeAsync(notificationBoundStmt)
                .thenAccept((rs) -> {
                    semaphore.release();
                    rabbitService.ackMessage(channel, messageTag, true);
                })
                .exceptionally((ex) -> {
                    log.error(
                            "================\nGot exception while trying to insert notification in Cassandra : {}",
                            ex);
                    rabbitService.ackMessage(channel, messageTag, false);
                    semaphore.release();
                    return null;
                });

    }

}

package io.micrologs.notification.Service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.rabbitmq.client.Channel;

import io.micrologs.notification.dto.GenericResponse;
import io.micrologs.notification.dto.NotificationDTO;
import io.micrologs.notification.dto.NotificationReadDTO;
import io.micrologs.notification.dto.NotificationResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CassandraService {

    private CqlSession cqlSession;
    private final RabbitService rabbitService;

    private final PreparedStatement notificationInsertStatement;
    private final PreparedStatement notificationFetchStatement;
    private final PreparedStatement setNotificationReadStatement;

    public CassandraService(CqlSession cqlSession, RabbitService rabbitService) {
        this.rabbitService = rabbitService;
        this.cqlSession = cqlSession;

        this.notificationInsertStatement = this.cqlSession.prepare("""
                INSERT INTO micrologs.notifications
                (userid, notification_id, title, description, emmited_at, message_read, service)
                values
                (?, ?, ?, ?, ? , ?, ?);
                """);

        this.notificationFetchStatement = this.cqlSession.prepare(
                """
                                    SELECT userid, notification_id, title, description, emmited_at, message_read, service FROM micrologs.notifications WHERE userid = ?;
                        """);
        this.setNotificationReadStatement = this.cqlSession.prepare(
                """
                            UPDATE micrologs.notifications SET message_read = true WHERE userid = ? AND emmited_at  = ? AND notification_id = ?;
                        """);

    }

    public void saveNotification(NotificationDTO notification, Channel channel, long messageTag) {
        BoundStatement notificationBoundStmt = notificationInsertStatement.bind()
                .setString(0, notification.getUserid())
                .setUuid(1, UUID.randomUUID())
                .setString(2, notification.getTitle())
                .setString(3, notification.getDescription())
                .setLong(4, notification.getEmmited_at())
                .setBoolean(5, false)
                .setString(6, notification.getServiceName());

        log.error("====INNSERTING DTO==== : {}", notification);

        try {
            cqlSession.execute(notificationBoundStmt);
            rabbitService.ackMessage(channel, messageTag, true);
        } catch (Exception ex) {
            log.error("================\nGot exception while trying to insert notification in Cassandra : {}", ex);
            rabbitService.ackMessage(channel, messageTag, false);
        }
    }

    public NotificationResponse fetchNotificationForUser(String userid) {
        BoundStatement bound = notificationFetchStatement.bind().setString(0, userid);
        ResultSet rs = cqlSession.execute(bound);

        NotificationResponse notificationResponse = new NotificationResponse();

        rs.iterator().forEachRemaining((row) -> {
            NotificationDTO curr = NotificationDTO.builder()
                    .title(row.getString("title"))
                    .description(row.getString("description"))
                    .emmited_at(row.getLong("emmited_at"))
                    .userid(row.getString("userid"))
                    .serviceName(row.getString("service"))
                    .notification_id(row.getUuid("notification_id"))
                    .build();

            notificationResponse.addNotification(curr);
        });

        return notificationResponse;
    }

    public GenericResponse setNotificationRead(NotificationReadDTO notificationRead) {

        BoundStatement bound = setNotificationReadStatement.bind().setString(0, notificationRead.getUserid())
                .setLong(1, notificationRead.getEmmited_at()).setUuid(2, notificationRead.getNotification_id());

        try {
            cqlSession.execute(bound);
            return new GenericResponse("Message Read", true);
        } catch (Exception e) {
            return new GenericResponse("Failed to Set Read", false);
        }
    }
}

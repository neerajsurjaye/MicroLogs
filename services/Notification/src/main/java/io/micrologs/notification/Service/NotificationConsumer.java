package io.micrologs.notification.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;

import io.micrologs.notification.config.RabbitConfig;
import io.micrologs.notification.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationConsumer {

    private ObjectMapper mapper;
    private CassandraService cassandraService;
    private final RabbitService rabbitService;

    public NotificationConsumer(ObjectMapper mapper, CassandraService cassandraService, RabbitService rabbitService) {
        this.mapper = mapper;
        this.cassandraService = cassandraService;
        this.rabbitService = rabbitService;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE, ackMode = "MANUAL")
    public void receive(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long messageTag) {

        try {
            NotificationDTO notification = mapper.readValue(message, NotificationDTO.class);
            cassandraService.saveNotification(notification, channel, messageTag);
        } catch (Exception e) {
            rabbitService.ackMessage(channel, messageTag, false);
            log.error("======Got exception while parsing rabbit message : {}", e);

        }

    }

}

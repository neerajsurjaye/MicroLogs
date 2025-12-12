package io.micrologs.notification.Service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import io.micrologs.notification.config.RabbitConfig;

@Service
public class NotificationConsumer {

    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receive(String message) {
        System.out.println("Received message :: " + message);
    }

}

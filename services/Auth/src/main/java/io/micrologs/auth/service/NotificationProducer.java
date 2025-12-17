package io.micrologs.auth.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrologs.auth.config.RabbitConfig;
import io.micrologs.auth.dto.NotificationDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public NotificationProducer(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(NotificationDTO message) {

        String jsonMessage = "";
        try {
            jsonMessage = objectMapper.writeValueAsString(message);
        } catch (Exception e) {
            log.error("Got Exception : {} while trying to seralize : {}", e, message.toString());
        }

        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE, RabbitConfig.ROUTINGKEY_AUTH, jsonMessage);

    }

}

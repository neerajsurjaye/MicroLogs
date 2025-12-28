package io.micrologs.auth.service.notificationservice;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrologs.auth.constants.Constants;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper mapper;

    public MessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        mapper = new ObjectMapper();
    }

    public void send(NotificationDTO notificationDTO) {
        String notificationJSON = "";
        try {
            notificationJSON = mapper.writeValueAsString(notificationDTO);
            log.error("Sending message : {}", notificationJSON);
            rabbitTemplate.convertAndSend(Constants.RABBIT_EXHANGE, Constants.RABBIT_ROUTING_KEY, notificationJSON);
        } catch (Exception ex) {
            log.error("Notification Sending Exception : {} ", ex);
        }
    }

}

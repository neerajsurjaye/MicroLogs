package io.micrologs.notification.controller;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import io.micrologs.notification.dto.NotificationDTO;

@Service
public class NotificationSocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public NotificationSocketService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void broadcast(NotificationDTO message) {
        messagingTemplate.convertAndSend("/notification/broadcast", message);
    }

}

package io.micrologs.notification.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrologs.notification.Service.CassandraService;
import io.micrologs.notification.dto.GenericResponse;
import io.micrologs.notification.dto.NotificationReadDTO;
import io.micrologs.notification.dto.NotificationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/notification")
@Slf4j
public class NotificationController {

    private final CassandraService cassandraService;

    NotificationController(CassandraService cassandraService) {
        this.cassandraService = cassandraService;
    }

    @GetMapping("/{userid}")
    public ResponseEntity<NotificationResponse> getNotifications(@PathVariable String userid) {
        NotificationResponse notificationResponse = cassandraService.fetchNotificationForUser(userid);

        return new ResponseEntity<>(notificationResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericResponse> postMethodName(@RequestBody NotificationReadDTO notificationRead) {

        GenericResponse genericResponse = cassandraService.setNotificationRead(notificationRead);

        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    // TODO: Remove this. It should not exist on REST controller.
    @MessageMapping("/test")
    @SendTo("/topic/notifications")
    public String send(String message) {
        return "Server : " + message;
    }

}

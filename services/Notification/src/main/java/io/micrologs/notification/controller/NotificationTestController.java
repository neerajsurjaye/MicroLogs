package io.micrologs.notification.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class NotificationTestController {

    @GetMapping
    public String getMethodName() {
        return "Nofication Service :: up";
    }

}

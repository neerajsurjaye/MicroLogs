package io.micrologs.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class RootContoller {

    @GetMapping
    public String root() {
        return "AuthService";
    }

}

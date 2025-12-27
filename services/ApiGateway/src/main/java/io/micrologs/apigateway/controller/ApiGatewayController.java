package io.micrologs.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class ApiGatewayController {

    @GetMapping
    public String getMethodName() {
        return new String("Api Gateway");
    }

}

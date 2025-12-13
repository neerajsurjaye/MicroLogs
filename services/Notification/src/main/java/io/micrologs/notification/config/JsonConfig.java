package io.micrologs.notification.config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {

    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}

package io.micrologs.apigateway.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    public String getToken(ServerHttpRequest request) {
        String header = request.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (header == null) return null;

        String[] parts = header.trim().split("\\s+");

        if (parts.length != 2 || !parts[0].equalsIgnoreCase("Bearer")) {
            return null;
        }

        return parts[1];
    }


}


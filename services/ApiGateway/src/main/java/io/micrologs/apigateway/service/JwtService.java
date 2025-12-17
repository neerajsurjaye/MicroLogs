package io.micrologs.apigateway.service;

import io.micrologs.apigateway.dto.TokenValidationResponseDTO;
import io.micrologs.apigateway.util.JwtUtil;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private final JwtUtil jwtUtil;

    JwtService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    public TokenValidationResponseDTO verify(String token) {
        TokenValidationResponseDTO response = new TokenValidationResponseDTO();
        boolean isValid = jwtUtil.validate(token);

        response.setValid(isValid);

        if (isValid) {
            String username = jwtUtil.extractUsername(token);
            response.setUsername(username);
        }

        return response;
    }

    public String getToken(ServerHttpRequest request)
    {
        String tokenHeader = request.getHeaders().getFirst("Authorization");
        if(tokenHeader != null && tokenHeader.length() >= 2)
        {
            return tokenHeader.split(" ")[1];
        }

        return "";
    }

}


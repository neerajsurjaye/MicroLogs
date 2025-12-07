package io.micrologs.auth.service;

import org.springframework.stereotype.Service;

import io.micrologs.auth.dto.LoginResponse;
import io.micrologs.auth.dto.TokenValidaeRequest;
import io.micrologs.auth.dto.TokenValidationResponse;
import io.micrologs.auth.entity.User;
import io.micrologs.auth.security.JwtUtil;

@Service
public class JwtService {

    private final JwtUtil jwtUtil;

    JwtService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse login(User user) {
        String token = jwtUtil.generateToken(user);
        LoginResponse response = new LoginResponse();
        response.setAccessToken(token);
        return response;
    }

    public TokenValidationResponse verify(TokenValidaeRequest request) {
        TokenValidationResponse response = new TokenValidationResponse();
        boolean isValid = jwtUtil.validate(request.getToken());

        response.setValid(isValid);

        if (isValid) {
            String username = jwtUtil.extractUsername(request.getToken());
            response.setUsername(username);
        }

        return response;
    }

}

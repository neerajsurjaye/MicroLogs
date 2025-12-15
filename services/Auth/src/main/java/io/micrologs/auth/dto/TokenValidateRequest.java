package io.micrologs.auth.dto;

import lombok.Data;

@Data
public class TokenValidateRequest {
    private String token;
}

package io.micrologs.auth.dto;

import lombok.Data;

@Data
public class TokenValidationResponse {
    private boolean valid;
    private String userid;
    private String username;
}

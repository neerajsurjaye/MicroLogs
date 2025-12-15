package io.micrologs.auth.dto;

import lombok.Data;

@Data
public class TokenValidationResponse {
    private boolean valid;
    private Integer userid;
    private String username;
}

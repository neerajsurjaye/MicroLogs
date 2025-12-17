package io.micrologs.apigateway.dto;

import lombok.Data;

@Data
public class TokenValidationResponseDTO {
    private boolean valid;
    private String username;
}

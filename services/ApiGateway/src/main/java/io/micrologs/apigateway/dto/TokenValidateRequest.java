package io.micrologs.apigateway.dto;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
public class TokenValidateRequest {
    private String token;
}

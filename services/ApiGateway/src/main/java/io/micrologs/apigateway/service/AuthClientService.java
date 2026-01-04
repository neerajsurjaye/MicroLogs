package io.micrologs.apigateway.service;

import io.micrologs.apigateway.dto.ResponseDTO;
import io.micrologs.apigateway.dto.TokenValidateRequest;
import io.micrologs.apigateway.dto.TokenValidationResponseDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AuthClientService {

    private final WebClient webClient;

    public AuthClientService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://auth-service:8080").build();
    }

    public Mono<TokenValidationResponseDTO> validateToken(String token) {

        return webClient.post()
                .uri("/api/v1/user/validate")
                .bodyValue(TokenValidateRequest.builder().token(token).build())
                .retrieve()
                .bodyToMono(
                        new ParameterizedTypeReference<ResponseDTO<TokenValidationResponseDTO>>() {
                        })
                .map(ResponseDTO::getData);
    }
}

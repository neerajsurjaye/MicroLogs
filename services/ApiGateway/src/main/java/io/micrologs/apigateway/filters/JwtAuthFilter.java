package io.micrologs.apigateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.micrologs.apigateway.dto.UnauthorizedDTO;
import io.micrologs.apigateway.service.AuthClientService;
import io.micrologs.apigateway.service.JwtService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config> {

    private final JwtService jwtService;
    private final AuthClientService authClientService;

    public JwtAuthFilter(JwtService jwtService , AuthClientService authClientService) {
        super(Config.class);
        this.jwtService = jwtService;
        this.authClientService = authClientService;
    }

    @Override
    public GatewayFilter apply(Config config) 
    {
        return (exchange, chain) -> {
            String token = jwtService.getToken(exchange.getRequest());

            if (token == null || token.isEmpty()) {
                return unauthorized(exchange);
            }

            return authClientService.validateToken(token)
                    .flatMap(validation -> {
                        System.out.println(validation);
                        if (!validation.isValid()) {
                            return unauthorized(exchange);
                        }

                        ServerHttpRequest mutatedRequest = exchange.getRequest()
                                .mutate()
                                .header("X-Username", validation.getUsername())
                                .build();

                        return chain.filter(
                                exchange.mutate()
                                        .request(mutatedRequest)
                                        .build());
                    })
                    .onErrorResume(ex -> {
                        ex.printStackTrace();
                        return unauthorized(exchange);
                    });
        };
    }

    public static class Config {
    }

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

        UnauthorizedDTO unauthDTO = new UnauthorizedDTO(false, "Unauthorized");
        try {
            return exchange.getResponse().writeWith(
                    Mono.just(
                            exchange.getResponse().bufferFactory()
                                    .wrap(new ObjectMapper().writeValueAsBytes(unauthDTO))));

        } catch (Exception e) {
            return exchange.getResponse().setComplete();
        }
    }

}

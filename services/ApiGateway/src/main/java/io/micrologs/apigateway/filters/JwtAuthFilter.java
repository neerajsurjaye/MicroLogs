package io.micrologs.apigateway.filters;

import io.micrologs.apigateway.dto.TokenValidationResponseDTO;
import io.micrologs.apigateway.service.JwtService;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthFilter extends AbstractGatewayFilterFactory<JwtAuthFilter.Config>
{

    private final JwtService jwtService;

    public JwtAuthFilter(JwtService jwtService) {
        super(Config.class);
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {

            System.out.println("inside the filter");

            String token = jwtService.getToken(exchange.getRequest());

            if (token == null || token.isEmpty()) {
                return unauthorized(exchange);
            }

            TokenValidationResponseDTO tokenValidationResponseDTO = jwtService.verify(token);

            if(!tokenValidationResponseDTO.isValid())
            {
                return unauthorized(exchange);
            }

            ServerHttpRequest mutatedRequest = exchange.getRequest()
                                                       .mutate()
                                                       .header("X-Username", tokenValidationResponseDTO.getUsername() )
                                                       .build();

            return chain.filter(exchange.mutate().request(mutatedRequest).build());
        };
    }

    public static class Config {}

    private Mono<Void> unauthorized(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

}

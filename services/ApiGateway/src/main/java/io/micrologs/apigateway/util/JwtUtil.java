package io.micrologs.apigateway.util;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "A_SECRET_KEYA_SECRET_KEYA_SECRET_KEYA_SECRET_KEY";

    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Boolean validate(String token) {
        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                   .setSigningKey(SECRET_KEY.getBytes()).build().parseClaimsJws(token).getBody();
    }

}

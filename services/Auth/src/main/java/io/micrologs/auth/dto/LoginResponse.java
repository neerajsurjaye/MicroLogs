package io.micrologs.auth.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoginResponse {
    private String accessToken;
    private String username;
    private int userid;
}

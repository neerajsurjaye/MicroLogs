package io.micrologs.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrologs.auth.dto.CreateUserRequest;
import io.micrologs.auth.dto.LoginRequest;
import io.micrologs.auth.dto.LoginResponse;
import io.micrologs.auth.dto.ResponseDTO;
import io.micrologs.auth.dto.TokenValidateRequest;
import io.micrologs.auth.dto.TokenValidationResponse;
import io.micrologs.auth.dto.UserResponse;
import io.micrologs.auth.entity.User;
import io.micrologs.auth.service.JwtService;
import io.micrologs.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    UserController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    /**
     * Creates a new user if doesnt exists. Or Fails.
     * 
     * @param request
     * @return
     */
    @PostMapping
    public ResponseEntity<ResponseDTO<UserResponse>> createUser(@RequestBody CreateUserRequest request) {
        UserResponse userResponse = map(userService.create(request));

        ResponseDTO<UserResponse> response = new ResponseDTO<UserResponse>("User Created", true, userResponse);
        return ResponseEntity.ok(response);
    }

    /**
     * Generates a new JWT token.
     * 
     * @param request
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO<LoginResponse>> login(@RequestBody LoginRequest request) {
        User user = userService.login(request);
        LoginResponse resp = jwtService.login(user);

        ResponseDTO<LoginResponse> response = new ResponseDTO<>("Login response", true, resp);

        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate")
    public ResponseEntity<ResponseDTO<TokenValidationResponse>> validateToken(
            @RequestBody TokenValidateRequest request) {

        TokenValidationResponse validationResp = jwtService.verify(request);
        ResponseDTO<TokenValidationResponse> response = new ResponseDTO<>(
                "Token Validation",
                true,
                validationResp);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<UserResponse>> get(@PathVariable int id) {
        UserResponse resp = map(userService.getById(id));

        ResponseDTO<UserResponse> response = new ResponseDTO<UserResponse>("User Details", true, resp);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{username}")
    public ResponseEntity<ResponseDTO<UserResponse>> getByUserId(@PathVariable String username) {
        UserResponse resp = map(userService.getByUserName(username));

        ResponseDTO<UserResponse> response = new ResponseDTO<UserResponse>("User Details", true, resp);
        return ResponseEntity.ok(response);
    }

    private UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setUserid(String.valueOf(user.getUserid()));

        return userResponse;
    }

}

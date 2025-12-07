package io.micrologs.auth.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrologs.auth.dto.CreateUserRequest;
import io.micrologs.auth.dto.LoginRequest;
import io.micrologs.auth.dto.LoginResponse;
import io.micrologs.auth.dto.TokenValidaeRequest;
import io.micrologs.auth.dto.TokenValidationResponse;
import io.micrologs.auth.dto.UserResponse;
import io.micrologs.auth.entity.User;
import io.micrologs.auth.service.JwtService;
import io.micrologs.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return map(userService.create(request));
    }

    /**
     * Generates a new JWT token.
     * 
     * @param request
     * @return
     */
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        User user = userService.login(request);
        return jwtService.login(user);
    }

    @PostMapping("/validate")
    public TokenValidationResponse validateToken(@RequestBody TokenValidaeRequest request) {
        return jwtService.verify(request);
    }

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable int id) {
        return map(userService.getById(id));
    }

    @GetMapping
    public String test() {
        return "User Controller";
    }

    private UserResponse map(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getUsername());
        userResponse.setId(user.getUserid());

        return userResponse;
    }

}

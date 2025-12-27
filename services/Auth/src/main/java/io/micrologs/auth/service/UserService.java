package io.micrologs.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.micrologs.auth.dto.CreateUserRequest;
import io.micrologs.auth.dto.LoginRequest;
import io.micrologs.auth.entity.User;
import io.micrologs.auth.exception.MicroLogsAuthException;
import io.micrologs.auth.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User create(CreateUserRequest createUserRequest) {

        if (userRepository.existsByUsername(createUserRequest.getUsername())) {
            throw new MicroLogsAuthException("Username already exists");
        }

        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(passwordEncoder.encode(createUserRequest.getPassword()));

        return userRepository.save(user);

    }

    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new MicroLogsAuthException("User Doesn't exist"));
    }

    public User getByUserName(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new MicroLogsAuthException("User Doesn't exist"));
    }

    public User login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new MicroLogsAuthException("User Not Found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new MicroLogsAuthException("Invalid Password");
        }

        return user;

    }

}

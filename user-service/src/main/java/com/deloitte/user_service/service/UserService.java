package com.deloitte.user_service.service;

import org.springframework.stereotype.Service;

import com.deloitte.user_service.dto.request.RegisterRequestDTO;
import com.deloitte.user_service.entity.User;
import com.deloitte.user_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository = null;

    public String register(RegisterRequestDTO request) {

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        userRepository.save(user);
        return "User registered successfully";
    }

}

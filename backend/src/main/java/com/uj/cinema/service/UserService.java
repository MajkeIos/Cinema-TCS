package com.uj.cinema.service;

import com.uj.cinema.model.dto.request.auth.RegisterRequest;
import com.uj.cinema.model.entity.User;
import com.uj.cinema.model.entity.UserRole;
import com.uj.cinema.repository.UserRepository;
import com.uj.cinema.utils.GuidGenerator;
import java.time.Instant;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserByUsername(final String username) {
        return userRepository.getByUsername(username);
    }

    public User registerUser(final RegisterRequest request) {
        final User user = User.builder()
                .userId(generateGuid())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .registrationDate(Instant
                        .ofEpochMilli(System.currentTimeMillis())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime())
                .role(UserRole.USER)
                .build();
        userRepository.save(user);
        return user;
    }

    private String generateGuid() {
        return GuidGenerator.generateGuid(User.GUID_PREFIX, userRepository::existsById);
    }
}

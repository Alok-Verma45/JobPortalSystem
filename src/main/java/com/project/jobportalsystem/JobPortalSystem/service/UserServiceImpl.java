package com.project.jobportalsystem.JobPortalSystem.service;

import com.project.jobportalsystem.JobPortalSystem.dto.UserDto;
import com.project.jobportalsystem.JobPortalSystem.model.User;
import com.project.jobportalsystem.JobPortalSystem.repository.UserRepository;
import com.project.jobportalsystem.JobPortalSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto registerUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setCreatedAt(java.time.LocalDateTime.now());

        User savedUser = userRepository.save(user);

        return new UserDto(savedUser.getId(), savedUser.getName(), savedUser.getEmail(),
                savedUser.getPassword(), savedUser.getRole());
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail(),
                        user.getPassword(), user.getRole()))
                .collect(Collectors.toList());
    }
}

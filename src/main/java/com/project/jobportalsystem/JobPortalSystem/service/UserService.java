package com.project.jobportalsystem.JobPortalSystem.service;

import com.project.jobportalsystem.JobPortalSystem.dto.UserDto;
import java.util.List;

public interface UserService {
    UserDto registerUser(UserDto userDto);
    List<UserDto> getAllUsers(); // ✅ Only the method signature
}

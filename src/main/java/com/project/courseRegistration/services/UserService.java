package com.project.courseRegistration.services;

import com.project.courseRegistration.dtos.UserDTO;
import com.project.courseRegistration.models.User;

public interface UserService {
    User insertUser(UserDTO userDTO) throws Exception;
}

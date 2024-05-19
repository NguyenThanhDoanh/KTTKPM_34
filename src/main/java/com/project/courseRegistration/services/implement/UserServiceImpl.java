package com.project.courseRegistration.services.implement;

import com.project.courseRegistration.dtos.UserDTO;
import com.project.courseRegistration.exceptions.DataNotFoundException;
import com.project.courseRegistration.models.Role;
import com.project.courseRegistration.models.User;
import com.project.courseRegistration.repositories.RoleRepository;
import com.project.courseRegistration.repositories.UserRepository;
import com.project.courseRegistration.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User insertUser(UserDTO userDTO) throws Exception{
        Role role = roleRepository.findById(2L)
                .orElseThrow(() -> new DataNotFoundException("ROLE_DOES_NOT_EXISTS"));
        User newUser = User.builder()
                .username(userDTO.getUsername())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .role(role)
                .build();
        return userRepository.save(newUser);
    }
}

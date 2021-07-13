package com.validationModule.validationModule.service;


import com.validationModule.validationModule.mapping.UserMapper;
import com.validationModule.validationModule.model.User;
import com.validationModule.validationModule.repository.UserRepository;
import com.validationModule.validationModule.service.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("ALL")
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public ResponseEntity save(UserDto userDto) {
        User user = userMapper.userDtoToUser(userDto);
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

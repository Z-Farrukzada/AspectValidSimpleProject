package com.validationModule.validationModule.mapping;

import com.validationModule.validationModule.model.User;
import com.validationModule.validationModule.service.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper{

    @Override
    public User userDtoToUser(UserDto userDto) {
        if(userDto == null){
            return null;
        }

        return User.builder()
                .name(userDto.getName())
                .userName(userDto.getUserName())
                .age(userDto.getAge())
                .email(userDto.getEmail())
                .about(userDto.getAbout())
                .fatherName(userDto.getFatherName())
                .position(userDto.getPosition())
                .mobileNumber(userDto.getMobileNumber())
                .build();
    }
}

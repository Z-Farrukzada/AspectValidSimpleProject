package com.validationModule.validationModule.mapping;

import com.validationModule.validationModule.model.User;
import com.validationModule.validationModule.service.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
    User userDtoToUser(UserDto userDto);

}

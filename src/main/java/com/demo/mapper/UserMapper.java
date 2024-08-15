package com.demo.mapper;

import com.demo.dto.UserDto;
import com.demo.entity.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(
            user.getId(),
            user.getFirstName(),
            user.getLastName(),
            user.getEmail()
        );
    }

    public static User toUser(UserDto userDto) {
        return new User(
            userDto.getId(),
            userDto.getFirstName(),
            userDto.getLastName(),
            userDto.getEmail()
        );
    }
}

package com.tp.todo.converter.impl;

import com.tp.todo.controller.dto.UserDto;
import com.tp.todo.converter.EntityConverter;
import com.tp.todo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements EntityConverter<UserDto, User> {

    @Override
    public UserDto to(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .build();
    }

    @Override
    public User to(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}

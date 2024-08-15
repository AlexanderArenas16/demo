package com.demo.service;

import com.demo.dto.UserDto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<UserDto> saveUser(UserDto userDto);
    Mono<UserDto> getUser(String id);
    Flux<UserDto> getUsers();
    Mono<UserDto> updateUser(UserDto userDto, String id);
    Mono<Void> deleteUser(String id);
}

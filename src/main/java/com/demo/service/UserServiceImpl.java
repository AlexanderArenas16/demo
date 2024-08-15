package com.demo.service;

import org.springframework.stereotype.Service;

import com.demo.dto.UserDto;
import com.demo.entity.User;
import com.demo.mapper.UserMapper;
import com.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    
    @Override
    public Mono<UserDto> saveUser(UserDto userDto) {
        User user = UserMapper.toUser(userDto);
        Mono<User> saveUser = userRepository.save(user);
        return saveUser.map(userEntity -> UserMapper.toUserDto(user));    
    }

    @Override
    public Mono<UserDto> getUser(String id) {
        Mono<User> user = userRepository.findById(id);
        return user.map(userEntity -> UserMapper.toUserDto(userEntity))
                    .switchIfEmpty(Mono.just(new UserDto()));
    }

    @Override
    public Flux<UserDto> getUsers() {
        Flux<User> users = userRepository.findAll();
        return users.map(user -> UserMapper.toUserDto(user))
                    .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<UserDto> updateUser(UserDto userDto, String id) {
        Mono<User> user = userRepository.findById(id);
        return user.flatMap(userExist -> {
            userExist.setId(id);
            userExist.setFirstName(userDto.getFirstName());
            userExist.setLastName(userDto.getLastName());
            userExist.setEmail(userDto.getEmail());
            return userRepository.save(userExist);
        }).map(userEntity -> UserMapper.toUserDto(userEntity))
        .switchIfEmpty(Mono.just(new UserDto()));
    }

    @Override
    public Mono<Void> deleteUser(String id) {
        return userRepository.deleteById(id);
    }


}

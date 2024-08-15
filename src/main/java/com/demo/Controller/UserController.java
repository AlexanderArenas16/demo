package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.UserService;
import com.demo.dto.UserDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("")
    public Flux<UserDto> getUsers() {
        return service.getUsers();
    }

    @GetMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<UserDto> getUser(@PathVariable("id") String id) {
        return service.getUser(id);
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<UserDto> saveUser(@RequestBody UserDto userDto) {
        return service.saveUser(userDto);
    }

    @PutMapping("{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("id") String id) {
        return service.updateUser(userDto, id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Mono<Void> deleteUser(@PathVariable("id") String id) {
        return service.deleteUser(id);
    }
}

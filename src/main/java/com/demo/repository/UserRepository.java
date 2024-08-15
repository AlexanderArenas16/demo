package com.demo.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.demo.entity.User;

public interface UserRepository extends ReactiveCrudRepository<User, String> {

}

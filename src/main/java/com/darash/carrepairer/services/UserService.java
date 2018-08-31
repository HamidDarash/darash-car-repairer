package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Flux<User> findOnlineUser();

    Mono<User> findById(UUID id);

//    UserType getUserType(UUID id);

    Mono<User> saveOrUpdate(User user);

    Flux<User> findByMobile(String mobile);

    void delete(User user);
}

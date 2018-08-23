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

    Mono<UserType> getUserType(UUID id);

    Mono<User> saveOrUpdate(User user);

    Mono<User> findByMobile(String query);

    void delete(User user);
}

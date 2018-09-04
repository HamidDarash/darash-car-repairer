package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserType;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Flux<ResponseEntity<User>> findOnlineUser();

    Mono<ResponseEntity<User>> findById(UUID id);

//    UserType getUserType(UUID id);

    Mono<User> save(User user);

    Mono<ResponseEntity<User>> update(UUID id , User newInfo);

    void delete(User user);
}

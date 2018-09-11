package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserService {
   Flux<ResponseEntity<Slice<User>>> findOnlineUser(Pageable pageable);

    Mono<ResponseEntity<User>> findById(UUID id);

    Mono<User> save(User user);

    Mono<ResponseEntity<User>> update(UUID id, User newInfo);

    Mono<ResponseEntity<Void>> delete(UUID id);

//    Flux<ResponseEntity<Page<User>>> findAll(Pageable pageable);

}

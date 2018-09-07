package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.UserByLocation;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserByLocationService {

    Mono<ResponseEntity<UserByLocation>> findByUserId(UUID user_id);

    Mono<UserByLocation> save(UserByLocation userByLocation);

    Mono<ResponseEntity<UserByLocation>> update(UUID id, UserByLocation userByLocation);

    Mono<ResponseEntity<Void>> delete(UUID id);

}

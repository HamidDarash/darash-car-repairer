package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.entities.UserByLocation;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserByLocationService {

    Mono<UserByLocation> findByUserId(UUID id);

    Mono<UserByLocation> saveOrUpdate(UserByLocation userByLocation);

    void delete(UserByLocation userByLocation);

}

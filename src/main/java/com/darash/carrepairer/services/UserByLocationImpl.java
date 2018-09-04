package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.entities.UserByLocation;
import com.darash.carrepairer.repositories.UserByLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.UUID;

public class UserByLocationImpl implements UserByLocationService {

    private final UserByLocationRepository userByLocationRepository;

    @Autowired
    public UserByLocationImpl(UserByLocationRepository userByLocationRepository) {
        this.userByLocationRepository = userByLocationRepository;
    }


    @Override
    public Mono<UserByLocation> findByUserId(UUID id) {
        return userByLocationRepository.findByUser_id(id);
    }

    @Override
    public Mono<UserByLocation> saveOrUpdate(UserByLocation userByLocation) {
        Mono<UserByLocation> userByLocationMono = userByLocationRepository.save(userByLocation);
        userByLocationMono.subscribe(System.out::println);
        return userByLocationMono;
    }

    @Override
    public void delete(UserByLocation userByLocation) {
       Mono<Void> voidMono = userByLocationRepository.delete(userByLocation);
       voidMono.subscribe(System.out::println);
    }
}

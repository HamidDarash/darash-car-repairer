package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.UserByLocation;
import com.darash.carrepairer.repositories.UserByLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserByLocationServiceImpl implements UserByLocationService {

    private final UserByLocationRepository userByLocationRepository;

    @Autowired
    public UserByLocationServiceImpl(UserByLocationRepository userByLocationRepository) {
        this.userByLocationRepository = userByLocationRepository;
    }

    @Override
    public Mono<ResponseEntity<UserByLocation>> findByUserId(UUID user_id) {
        return userByLocationRepository.findByUser_id(user_id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<UserByLocation> save(UserByLocation userByLocation) {
        return userByLocationRepository.save(userByLocation);
    }

    @Override
    public Mono<ResponseEntity<UserByLocation>> update(UUID id, UserByLocation userByLocation) {
        return userByLocationRepository.findById(id)
                .flatMap(editItem -> {
                    editItem.setLocation(userByLocation.getLocation());
                    editItem.setUser_id(userByLocation.getUser_id());
                    return userByLocationRepository.save(editItem);
                })
                .map(Update -> new ResponseEntity<>(Update, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> delete(UUID id) {
        return userByLocationRepository.findById(id)
                .flatMap(existItem -> userByLocationRepository.delete(existItem)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}

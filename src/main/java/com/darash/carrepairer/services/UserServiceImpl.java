package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Flux<ResponseEntity<User>> findOnlineUser() {

        return userRepository.findByIsOnline(true)
                .map(finded -> ResponseEntity.ok(finded))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<User>> findById(UUID id) {
        return userRepository.findById(id).map(finded -> ResponseEntity.ok(finded))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }


    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<ResponseEntity<User>> update(UUID id, User newInfo) {
        return userRepository.findById(id)
                .flatMap(ExistUser -> {
                    ExistUser.setActive(newInfo.getActive());
                    ExistUser.setAddress(newInfo.getAddress());
                    ExistUser.setAvatar(newInfo.getAvatar());
                    ExistUser.setCarIdAvatar(newInfo.getCarIdAvatar());
                    return userRepository.save(newInfo);
                })
                .map(Update -> new ResponseEntity<>(Update, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }


    @Override
    public void delete(User user) {
        final Mono<Void> delete = userRepository.delete(user);
        delete.subscribe();
    }
}

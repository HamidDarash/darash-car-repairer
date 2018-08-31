package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserType;
import com.darash.carrepairer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Flux<User> findOnlineUser() {
        return userRepository.findByIsOnline(true);
    }

    @Override
    public Mono<User> findById(UUID id) {
        return userRepository.findById(id);
    }


    @Override
    public Mono<User> saveOrUpdate(User user) {
        Mono<User> userMono = userRepository.save(user);
        userMono.subscribe(System.out::println);
        return userMono;
    }

    @Override
    public Flux<User> findByMobile(String mobile) {
        return userRepository.findByMobileBySolr(mobile);
    }

    @Override
    public void delete(User user) {
        final Mono<Void> delete = userRepository.delete(user);
        delete.subscribe();
    }
}

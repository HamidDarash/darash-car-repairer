package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserByLocation;
import com.darash.carrepairer.repositories.UserByLocationRepository;
import com.darash.carrepairer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserByLocationRepository userByLocationRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository , UserByLocationRepository userByLocationRepository) {
        this.userRepository = userRepository;
        this.userByLocationRepository = userByLocationRepository;
    }

    @Override
    public Flux<ResponseEntity<Slice<User>>> findOnlineUser(Pageable pageable) {
        return userRepository.findByIsOnline(true, pageable)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @Override
    public Mono<ResponseEntity<User>> findById(UUID id) {
        return userRepository.findById(id).map(ResponseEntity::ok)
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
                    ExistUser.setEmail(newInfo.getEmail());
                    ExistUser.setEventTime(new Date());
                    ExistUser.setFullname(newInfo.getFullname());
                    ExistUser.setInternationalcode(newInfo.getInternationalcode());
                    ExistUser.setIp(newInfo.getIp());
                    ExistUser.setMobile(newInfo.getMobile());
                    ExistUser.setOnline(newInfo.getOnline());
                    ExistUser.setTelephone(newInfo.getTelephone());
                    ExistUser.setUserType(newInfo.getUserType());
                    return userRepository.save(ExistUser);
                })
                .map(Update -> new ResponseEntity<>(Update, HttpStatus.OK))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> delete(UUID uuid) {
        return userRepository.findById(uuid)
                .flatMap(exist -> userRepository.delete(exist)
                        .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public Flux<ResponseEntity<Slice<User>>> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

//    @Override
//    public Mono<ResponseEntity<Void>> deleteAllByUser_id(UUID uuid) {
//        return userByLocationRepository.deleteAllByUser_id(uuid)
//                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }


}

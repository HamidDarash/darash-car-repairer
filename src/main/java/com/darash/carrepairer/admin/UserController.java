package com.darash.carrepairer.admin;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;


@RequestMapping("/admin")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getAllUsers", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<ResponseEntity<Slice<User>>> getAllListOfUsers(Pageable pageable) {
        return userService.findAll(pageable);
    }


    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public Mono<ResponseEntity<Void>> removeUser(UUID uuid) {
        return userService.delete(uuid);
    }


}

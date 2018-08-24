package com.darash.carrepairer.api;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserType;
import com.darash.carrepairer.repositories.LocationRepository;
import com.darash.carrepairer.repositories.UserRepository;
import com.darash.carrepairer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.websocket.server.PathParam;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    public UserController(LocationRepository locationRepository, UserRepository userRepository) {
        this.locationRepository = locationRepository;
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/useronline", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Flux<User> getUserOnline() {
//        return userService.findOnlineUser().map(ResponseEntity::ok).defaultIfEmpty(
//                new ResponseEntity<>(HttpStatus.NOT_FOUND)
//        );
        return userService.findOnlineUser();
    }

    @RequestMapping(value = "/getusertype/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Mono<UserType> getTypeUser(@PathVariable("id") UUID id) {
        return userService.getUserType(id);
    }

    @RequestMapping(value = "/getuserbymobile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Flux<User> getUserByMobileSolrSearch(@PathParam("mobile") String mobile) {
         return userRepository.findByMobileBySolr(mobile);
    }


}

package com.darash.carrepairer.api;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.entities.UserByLocation;
import com.darash.carrepairer.entities.UserType;
import com.darash.carrepairer.repositories.LocationRepository;
import com.darash.carrepairer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public UserController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/useronline", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Flux<ResponseEntity<User>> getUserOnline() {
        return userService.findOnlineUser().map(ResponseEntity::ok).defaultIfEmpty(
                new ResponseEntity<>(HttpStatus.NOT_FOUND)
        );
    }

    @RequestMapping(value = "/getusertype", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Mono<UserType> getTypeUser(@PathParam("id") String id) {

        return userService.getUserType(UUID.fromString(id));
    }

    @RequestMapping(value = "/getLocations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    private Flux<UserByLocation> getDistanceLocations(@PathParam("lat") String lat,
                                                      @PathParam("lat") String lng) {

        return locationRepository.findByLatLng(Double.valueOf(lat),Double.valueOf(lng),60.55,32.1);

    }


}

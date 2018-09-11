package com.darash.carrepairer.api;

import com.darash.carrepairer.entities.User;
import com.darash.carrepairer.services.UserService;
import com.darash.carrepairer.solr.entities.UserByLocationSolrEntity;
import com.darash.carrepairer.solr.entities.UsersSolrEntity;
import com.darash.carrepairer.solr.repositories.UserByLocationSolrRepository;
import com.darash.carrepairer.solr.repositories.UserSolrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;
    private final UserSolrRepository userSolrRepository;
    private final UserByLocationSolrRepository userByLocationSolrRepository;

    @Autowired
    public UserController(UserSolrRepository userSolrRepository, UserByLocationSolrRepository userByLocationSolrRepository) {
        this.userSolrRepository = userSolrRepository;
        this.userByLocationSolrRepository = userByLocationSolrRepository;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    @RequestMapping(value = "/useronline", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    private Flux<ResponseEntity<Page<User>>> getUserOnline(Pageable pageable) {
//        return userService.findOnlineUser(pageable);
//    }

    @RequestMapping(value = "/locations/{location}")
    private List<UserByLocationSolrEntity> userByLocationSolrEntities(@PathVariable("location") String Location) {
        return userByLocationSolrRepository.DistanceAroundLocation(Location);
    }

    @RequestMapping(value = "/findfullname/{fullname}")
    private Optional<UsersSolrEntity> usersSolrEntityfindFullname(@PathVariable("fullname") String fullname) {
        return userSolrRepository.findByFullname(fullname);
    }

}

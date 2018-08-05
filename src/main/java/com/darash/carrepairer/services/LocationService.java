package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.LatLng;
import com.darash.carrepairer.entities.UserByLocation;
import org.springframework.data.cassandra.repository.Query;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface LocationService {

    Mono<UserByLocation> lastLocationUser(UUID id);

    @Query(value = "select * from locations where ", allowFiltering = true)
    Flux<UserByLocation> getDistanstByLatLng(LatLng latLng);

}

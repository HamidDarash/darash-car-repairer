package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserRequestByLocation;
import org.reactivestreams.Publisher;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRequestByLocationRepository extends ReactiveCassandraRepository<UserRequestByLocation, UUID> {

    Mono<UserRequestByLocation> findById(UUID id);


}

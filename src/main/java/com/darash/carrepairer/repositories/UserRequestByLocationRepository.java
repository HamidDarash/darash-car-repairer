package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserRequestByLocation;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRequestByLocationRepository extends ReactiveCassandraRepository<UserRequestByLocation, UUID> {
    /*
     * Search does in table in cassandra by Solr *
     */
    Mono<UserRequestByLocation> findById(UUID id);

    @Query("select * from user_request_by_location where location = 0? order by id desc limit 10")
    Flux<UserRequestByLocation> findByLocation(String location);


}

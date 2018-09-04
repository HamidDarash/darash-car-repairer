package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserByLocation;
import org.reactivestreams.Publisher;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserByLocationRepository extends ReactiveCassandraRepository<UserByLocation, UUID> {

    Mono<UserByLocation> findById(UUID id);

    Mono<UserByLocation> findByUser_id(UUID uuid);

    @Override
    <S extends UserByLocation> Mono<S> save(S s);

    @Override
    Mono<Void> delete(UserByLocation userByLocation);

}

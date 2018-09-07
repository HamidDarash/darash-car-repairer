package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserByLocation;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserByLocationRepository extends ReactiveCassandraRepository<UserByLocation, UUID> {


    Mono<UserByLocation> findById(UUID id);

    @Query("select * from user_by_location where user_id = 0? order by id desc limit 1")
    Mono<UserByLocation> findByUser_id(UUID user_id);

    @Override
    <S extends UserByLocation> Mono<S> save(S s);

    @Override
    Mono<Void> delete(UserByLocation userByLocation);

}

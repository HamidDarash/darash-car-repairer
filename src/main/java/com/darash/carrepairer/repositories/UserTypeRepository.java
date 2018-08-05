package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserType;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserTypeRepository extends ReactiveCassandraRepository<UserType, UUID> {

    @AllowFiltering
    @Override
    Mono<UserType> findById(UUID uuid);
}

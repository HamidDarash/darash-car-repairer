package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserRequestByLocation;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface UserRequestByLocationRepository extends ReactiveCassandraRepository<UserRequestByLocation, UUID> {
}

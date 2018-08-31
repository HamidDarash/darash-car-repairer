package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserByLocation;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface UserByLocationRepository extends ReactiveCassandraRepository<UserByLocation, UUID> {

}

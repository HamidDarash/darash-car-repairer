package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.PitShop;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;

import java.util.UUID;

public interface PitShopRepository extends ReactiveCassandraRepository<PitShop, UUID> {

}

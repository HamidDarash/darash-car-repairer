package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.PitShop;
import org.reactivestreams.Publisher;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PitShopRepository extends ReactiveCassandraRepository<PitShop, UUID> {

    Flux<PitShop> findByActivate(Boolean aBoolean);

    @Override
    <S extends PitShop> Mono<S> save(S s);

    @Override
    Mono<PitShop> findById(UUID uuid);

    Flux<PitShop> findByFullname(String fullname);


}

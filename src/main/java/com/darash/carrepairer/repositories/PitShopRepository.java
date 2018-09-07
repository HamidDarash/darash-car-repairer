package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.PitShop;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PitShopRepository extends ReactiveCassandraRepository<PitShop, UUID> {

    Flux<Page<PitShop>> findByActivate(Boolean aBoolean, Pageable pageable);

    @Override
    <S extends PitShop> Mono<S> save(S s);

    @Override
    Mono<PitShop> findById(UUID uuid);

    Flux<Page<PitShop>> findByFullname(String fullname, Pageable pageable);


}

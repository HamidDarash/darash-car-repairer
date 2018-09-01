package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PitShopService {

    Flux<PitShop> findActivtePitShop();

    Mono<PitShop> findById(UUID id);

    Mono<PitShop> saveOrUpdate(PitShop pitShop);

    Flux<PitShop> findByFullName(String fullname);

    void delete(PitShop pitShop);
}

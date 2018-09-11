package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.PitShop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface PitShopService {

//    Flux<ResponseEntity<Page<PitShop>>> findActivtePitShop(Boolean active, Pageable pageable);

    Mono<ResponseEntity<PitShop>> findById(UUID id);

    Mono<PitShop> save(PitShop pitShop);

//    Flux<ResponseEntity<Page<PitShop>>> findByFullName(String fullname, Pageable pageable);

    Mono<ResponseEntity<Void>> delete(UUID id);
}

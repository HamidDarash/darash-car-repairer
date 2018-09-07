package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.repositories.PitShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class PitShopServiceImpl implements PitShopService {

    private final PitShopRepository pitShopRepository;

    @Autowired
    public PitShopServiceImpl(PitShopRepository pitShopRepository) {
        this.pitShopRepository = pitShopRepository;
    }

    @Override
    public Flux<ResponseEntity<Page<PitShop>>> findActivtePitShop(Boolean aBoolean, Pageable pageable) {
        return pitShopRepository.findByActivate(aBoolean, pageable)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<ResponseEntity<PitShop>> findById(UUID id) {
        return pitShopRepository.findById(id).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<PitShop> save(PitShop pitShop) {
        return pitShopRepository.save(pitShop);
    }

    @Override
    public Flux<ResponseEntity<Page<PitShop>>> findByFullName(String fullname, Pageable pageable) {
        return pitShopRepository.findByFullname(fullname, pageable).map(ResponseEntity::ok).defaultIfEmpty(ResponseEntity.noContent().build());
    }

    @Override
    public Mono<ResponseEntity<Void>> delete(UUID id) {
        return pitShopRepository.findById(id)
                .flatMap(existItem -> pitShopRepository.delete(existItem).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(ResponseEntity.noContent().build());
    }
}

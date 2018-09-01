package com.darash.carrepairer.services;

import com.darash.carrepairer.entities.PitShop;
import com.darash.carrepairer.repositories.PitShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Flux<PitShop> findActivtePitShop() {
        return pitShopRepository.findByActivate(true);
    }

    @Override
    public Mono<PitShop> findById(UUID id) {
        return pitShopRepository.findById(id);
    }

    @Override
    public Mono<PitShop> saveOrUpdate(PitShop pitShop) {
        Mono<PitShop> pitShopMono = pitShopRepository.save(pitShop);
        pitShopMono.subscribe(System.out::println);
        return pitShopMono;
    }

    @Override
    public Flux<PitShop> findByFullName(String fullname) {
        return pitShopRepository.findByFullname(fullname);
    }

    @Override
    public void delete(PitShop pitShop) {
        final Mono<Void> pitShopMono = pitShopRepository.delete(pitShop);
        pitShopMono.subscribe();
    }
}

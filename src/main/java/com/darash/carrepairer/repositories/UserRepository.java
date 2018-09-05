package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.awt.print.Pageable;
import java.util.UUID;

public interface UserRepository extends ReactiveCassandraRepository<User, UUID> {

    @Query("select * from users where isonline = ?0 ALLOW FILTERING")
    Flux<User> findByIsOnline(final boolean isonline);

    @Override
    <S extends User> Mono<S> save(S s);

    Mono<Void> delete(UUID uuid);

    Mono<User> findById(UUID uuid);

    Flux<Page<User>> findAll(Pageable pageable);
}

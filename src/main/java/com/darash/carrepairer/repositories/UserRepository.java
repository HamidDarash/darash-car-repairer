package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository extends ReactiveCassandraRepository<User, UUID> {

    @Query("select * from users where isonline = ?0 ALLOW FILTERING")
    Flux<Slice<User>> findByIsOnline(final boolean isonline, Pageable pageable);

    @Query("select * from users")
    Flux<Slice<User>> findAll(Pageable pageable);


    @Override
    <S extends User> Mono<S> save(S s);

    @Override
    Mono<Void> delete(User user);

    Mono<User> findById(UUID uuid);

}

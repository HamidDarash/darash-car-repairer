package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends ReactiveCassandraRepository<User, UUID> {

    @Query("select * from users where isonline = ?0 ALLOW FILTERING")
    Flux<User> findByIsOnline(final boolean isonline);

    @Override
    <S extends User> Mono<S> save(S s);

    @Override
    Mono<Void> delete(User user);

    @Query("select * from users where solr_query = '{\"q\":\"mobile: ?0\"}'")
    @AllowFiltering
    Flux<User> findByMobileBySolr(String query);
}

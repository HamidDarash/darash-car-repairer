package com.darash.carrepairer.solr.repositories;

import com.darash.carrepairer.solr.entities.UsersSolrEntity;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSolrRepository extends SolrCrudRepository<UsersSolrEntity, String> {

    Optional<UsersSolrEntity> findByFullname(String s);
    Optional<UsersSolrEntity> findByInternationalcode(String s);
    List<UsersSolrEntity> findByOnline(String value);

}

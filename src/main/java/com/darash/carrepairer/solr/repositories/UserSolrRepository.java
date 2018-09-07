package com.darash.carrepairer.solr.repositories;

import com.darash.carrepairer.solr.entities.UsersSolrEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.Optional;

public interface UserSolrRepository extends SolrCrudRepository<UsersSolrEntity, String> {

    Optional<UsersSolrEntity> findByFullname(String s);

    Optional<UsersSolrEntity> findByInternationalcode(String s);

    Page<UsersSolrEntity> findByOnline(String value, Pageable pageable);//rows=10&start=20


}

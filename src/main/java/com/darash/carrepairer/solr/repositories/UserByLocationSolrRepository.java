package com.darash.carrepairer.solr.repositories;

import com.darash.carrepairer.solr.entities.UserByLocationSolrEntity;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface UserByLocationSolrRepository extends SolrCrudRepository<UserByLocationSolrEntity, String> {

    @Query(name = "UserByLocationSolrEntity.DistanceAroundLocation")
    List<UserByLocationSolrEntity> DistanceAroundLocation(String location);
}

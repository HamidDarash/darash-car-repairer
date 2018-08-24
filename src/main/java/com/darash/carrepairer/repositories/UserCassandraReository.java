package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserCassandraReository extends CassandraRepository<User, UUID> {

    @Override
    List<User> findAll();

    @Query("select * from users where solr_query = '{\"q\":\"mobile: ?0\"}'")
    @AllowFiltering
    List<User> findByMobileBySolr2(String query);
}

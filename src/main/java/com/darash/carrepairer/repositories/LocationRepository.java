package com.darash.carrepairer.repositories;

import com.darash.carrepairer.entities.UserByLocation;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface LocationRepository extends ReactiveCassandraRepository<UserByLocation, UUID> {

    @Query(value = "select * from user_by_location where acosof(sinof(?0) * sinof(radiansof(latlng.lat)) + cosof(?0) * cosof(radiansof(latlng.lat)) * cosof(radians(latlng.lng)-?1)) * ?2 < ?3", allowFiltering = true)
//    @Query(value = "select sinof(latlng.lat) as sin_lat from user_by_location", allowFiltering = true)
    Flux<UserByLocation> findByLatLng(double lat, double Lng, double R, double rad);

    @Override
    Flux<UserByLocation> findAll();
}

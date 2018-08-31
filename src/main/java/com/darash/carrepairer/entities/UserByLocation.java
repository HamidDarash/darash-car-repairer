package com.darash.carrepairer.entities;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@Table(value = "user_by_location")
public class UserByLocation implements Serializable {

    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUIDs.random();

    @PrimaryKeyColumn(name = "timestamp", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID timeStamp = UUIDs.timeBased();

    @Column
    private UUID user_id;

    @Column
    private String location;

    @Deprecated
    public UserByLocation() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(UUID timeStamp) {
        this.timeStamp = timeStamp;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public UserByLocation(UUID user_id, String location) {
        this.user_id = user_id;
        this.location = location;
    }
}

package com.darash.carrepairer.entities;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.UDTValue;
import com.datastax.driver.core.utils.UUIDs;

import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
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

    //    @PrimaryKeyColumn(name = "event_time", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    @CassandraType(type = DataType.Name.TIMESTAMP)
    private java.time.LocalDate eventTime;

    @Column
    private UUID user_id;

    @Column
    private LatLng latLng;

    @CassandraType(type = DataType.Name.UDT, userTypeName = "latLng")
    UDTValue alternative;

    @Column
    private String location;



    @Column
    private double latitude;
    @Column
    private double longtude;

    @Deprecated
    public UserByLocation() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        location = location;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtude() {
        return longtude;
    }

    public void setLongtude(double longtude) {
        this.longtude = longtude;
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

    public java.time.LocalDate getEventTime() {
        return eventTime;
    }

    public void setEventTime(java.time.LocalDate eventTime) {
        this.eventTime = eventTime;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public UserByLocation(UUID user_id, LatLng latLng, double latitude, double longtude,String location) {
        this.user_id = user_id;
        this.latLng = latLng;
        this.latitude = latitude;
        this.longtude = longtude;
        this.location = location;

    }
}

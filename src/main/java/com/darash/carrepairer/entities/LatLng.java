package com.darash.carrepairer.entities;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Objects;
import java.util.UUID;

@UserDefinedType
@Table
public class LatLng {
    @PrimaryKey
    private UUID id = UUIDs.random();
    @Column
    private double lat;
    @Column
    private double lng;

    public LatLng(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "id=" + id +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LatLng)) return false;
        LatLng latLng = (LatLng) o;
        return Double.compare(latLng.getLat(), getLat()) == 0 &&
                Double.compare(latLng.getLng(), getLng()) == 0 &&
                Objects.equals(getId(), latLng.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getLat(), getLng());
    }
}

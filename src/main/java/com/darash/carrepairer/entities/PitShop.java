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

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Table(value = "pit_shops")
public class PitShop {
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.CLUSTERED , ordering = Ordering.DESCENDING)
    private UUID id = UUIDs.random();

    @Column
    private String managername;

    @Column
    private String fullname;

    @PrimaryKeyColumn(name = "representationcode", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private String representationcode;

    @Column
    private String location;

    @CassandraType(type = DataType.Name.BLOB)
    private Byte[] picturepreview;

    @Column
    private String describtion;

    @Column
    private boolean activate;

    @Column
    private List<RepresentationService> representationServices;

    @CassandraType(type = DataType.Name.UDT, userTypeName = "representation_service")
    UDTValue alternative;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getManagername() {
        return managername;
    }

    public void setManagername(String managername) {
        this.managername = managername;
    }

    public String getRepresentationcode() {
        return representationcode;
    }

    public void setRepresentationcode(String representationcode) {
        this.representationcode = representationcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Byte[] getPicturepreview() {
        return picturepreview;
    }

    public void setPicturepreview(Byte[] picturepreview) {
        this.picturepreview = picturepreview;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public List<RepresentationService> getRepresentationServices() {
        return representationServices;
    }

    public void setRepresentationServices(List<RepresentationService> representationServices) {
        this.representationServices = representationServices;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

//    @Deprecated
//    public PitShop() {
//    }

    public PitShop(String managername, String fullname, String representationcode, String location, Byte[] picturepreview, String describtion, boolean activate, List<RepresentationService> representationServices) {
        this.managername = managername;
        this.fullname = fullname;
        this.representationcode = representationcode;
        this.location = location;
        this.picturepreview = picturepreview;
        this.describtion = describtion;
        this.activate = activate;
        this.representationServices = representationServices;
    }
}

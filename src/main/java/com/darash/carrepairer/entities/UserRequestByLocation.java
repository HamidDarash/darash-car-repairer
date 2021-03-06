package com.darash.carrepairer.entities;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Table(value = "user_request_by_location")
public class UserRequestByLocation {
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID id = UUIDs.random();

    @Column
    private UUID user_id;

    @Column
    private UUID repairer_id;

    @Column
    private String location;

    @PrimaryKeyColumn(name = "event_date_time", ordinal = 1, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private Date event_date_time;

    @CassandraType(type = DataType.Name.INT)
    private RequestStatus status;

    @Column
    private int errorcode;

    @Deprecated
    public UserRequestByLocation() {
    }

    public UserRequestByLocation(UUID user_id, UUID repairer_id, String location, RequestStatus status, int errorcode) {
        this.user_id = user_id;
        this.repairer_id = repairer_id;
        this.location = location;
        this.status = status;
        this.errorcode = errorcode;
        this.event_date_time = new Date();
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public UUID getRepairer_id() {
        return repairer_id;
    }

    public void setRepairer_id(UUID repairer_id) {
        this.repairer_id = repairer_id;
    }

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Date getEvent_date_time() {
        return event_date_time;
    }

    public void setEvent_date_time(Date event_date_time) {
        this.event_date_time = event_date_time;
    }
}

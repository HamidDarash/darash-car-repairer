package com.darash.carrepairer.entities;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Table(value = "repair_request_by_location")
public class UserRequestByLocation {
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUIDs.random();

    @PrimaryKeyColumn(name = "event_time", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private Date eventTime;

    @Column
    private String location;

    @Column
    private boolean accept;

    @Column
    private boolean cancel;

    @Column
    private int status;

    @Column
    private int errorcode;

    @Deprecated
    public UserRequestByLocation() {
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

    public Date getEventTime() {
        return eventTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }


    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}

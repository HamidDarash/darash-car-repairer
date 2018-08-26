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

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

@Table(value = "repair_request")
public class RepairRequest {
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private UUID id = UUIDs.random();

    @PrimaryKeyColumn(name = "timestamp", ordinal = 1, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID timestamp = UUIDs.timeBased();

    @CassandraType(type = DataType.Name.TIMESTAMP)
    private LocalDate eventTime;



    @CassandraType(type = DataType.Name.UDT, userTypeName = "latLng")
    UDTValue alternative;

    @Column
    private boolean accept;
    @Column
    private UUID userIdAccepted;
    @Column
    private boolean cancel;
    @Column
    private int status;

    @Deprecated
    public RepairRequest() {
    }

    public RepairRequest(boolean accept, UUID userIdAccepted, boolean cancel, int status) {

        this.accept = accept;
        this.userIdAccepted = userIdAccepted;
        this.cancel = cancel;
        this.status = status;
    }

    public void setUserIdAccepted(UUID userIdAccepted) {
        this.userIdAccepted = userIdAccepted;
    }

    public UUID getId() {
        return id;
    }

    public UUID getTimestamp() {
        return timestamp;
    }

    public LocalDate getEventTime() {
        return eventTime;
    }

    public UUID getUserIdAccepted() {
        return userIdAccepted;
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

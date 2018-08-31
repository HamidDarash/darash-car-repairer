package com.darash.carrepairer.entities;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Repairer {
    @PrimaryKeyColumn(name = "id", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
    private UUID id = UUIDs.random();

    @Column
    private Date eventTime;
    @PrimaryKeyColumn(name = "internationalcode", ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private String internationalcode;
    @Column
    private String fullname;
    @Column
    private String password;
    @PrimaryKeyColumn(name = "email", ordinal = 1, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.DESCENDING)
    private String email;
    @Column
    private String address;
    @Column
    private String mobile;
    @Column
    private String telephone;

    @CassandraType(type = DataType.Name.BLOB)
    private byte[] avatar;

    @CassandraType(type = DataType.Name.BLOB)
    private byte[] carIdAvatar;

    @Column
    private Boolean isActive;

    @Column
    private Boolean isOnline;

    @Column
    private String ip;


}

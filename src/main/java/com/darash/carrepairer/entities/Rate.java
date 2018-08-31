package com.darash.carrepairer.entities;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table(value = "rate_of_repairer")
public class Rate {

    @PrimaryKey
    private UUID id = UUIDs.random();


}

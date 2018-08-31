package com.darash.carrepairer.entities;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table(value = "complaint_Of_repairer")  // شکایت ثبت شده از راننده
public class Complaint {
    @PrimaryKey
    private UUID id = UUIDs.random();

}

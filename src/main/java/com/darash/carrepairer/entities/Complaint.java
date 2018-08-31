package com.darash.carrepairer.entities;

import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Table(value = "complaint_Of_repairer")  // شکایت ثبت شده از راننده
public class Complaint {

}

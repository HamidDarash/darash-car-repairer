//package com.darash.carrepairer.entities;
//
//import com.datastax.driver.core.utils.UUIDs;
//import org.springframework.data.cassandra.core.cql.Ordering;
//import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
//import org.springframework.data.cassandra.core.mapping.Column;
//import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
//import org.springframework.data.cassandra.core.mapping.Table;
//
//import java.io.Serializable;
//import java.util.Objects;
//import java.util.UUID;
//
//@Table(value = "user_types")
//public class UserType implements Serializable {
//    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
//    private UUID id = UUIDs.random();
//
//    @PrimaryKeyColumn(name = "name", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
//    private String name;
//
//    @Column
//    private String description;
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof UserType)) return false;
//        UserType userType = (UserType) o;
//        return Objects.equals(id, userType.id) &&
//                Objects.equals(name, userType.name) &&
//                Objects.equals(description, userType.description);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id, name, description);
//    }
//
//    public UserType(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
//
//    @Override
//    public String toString() {
//        return "UserType{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                '}';
//    }
//}

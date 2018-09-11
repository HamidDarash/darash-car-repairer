package com.darash.carrepairer.entities;

import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Objects;
import java.util.UUID;

@UserDefinedType(value = "representation_service")
public class RepresentationService {
    private UUID id = UUID.randomUUID();
    private String service;
    private String describtion;
    private String price;

    public RepresentationService(String service, String describtion, String price) {
        this.service = service;
        this.describtion = describtion;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "RepresentationService{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", describtion='" + describtion + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RepresentationService)) return false;
        RepresentationService that = (RepresentationService) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getService(), that.getService()) &&
                Objects.equals(getDescribtion(), that.getDescribtion()) &&
                Objects.equals(getPrice(), that.getPrice());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getService(), getDescribtion(), getPrice());
    }
}

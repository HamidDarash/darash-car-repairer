package com.darash.carrepairer.solr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.util.UUID;

@SolrDocument(solrCoreName = "keyspacesaipa.user_by_location")
public class UserByLocationSolrEntity {

    @Id
    @Indexed(name = "id", type = "String")
    private String id;

    @Indexed(name = "location",type = "String")
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

package com.darash.carrepairer.solr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "keyspacesaipa.user_request_by_location")
public class UserRequestByLocationSolrEntity {


    @Id
    @Indexed(name = "id", type = "String")
    private String id;

    @Indexed(name = "user_id",type = "String")
    private String user_id;

    @Indexed(name = "repairer_id",type = "String")
    private String repairer_id;

    @Indexed(name = "location",type = "String")
    private String location;

    @Indexed(name = "status",type = "String")
    private String status;

    @Indexed(name = "errorcode",type = "String")
    private String errorcode;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRepairer_id() {
        return repairer_id;
    }

    public void setRepairer_id(String repairer_id) {
        this.repairer_id = repairer_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }
}

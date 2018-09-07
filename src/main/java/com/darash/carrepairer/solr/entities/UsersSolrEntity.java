package com.darash.carrepairer.solr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "keyspacesaipa.users")
public class UsersSolrEntity {

    @Id
    @Indexed(name = "id", type = "String")
    private String id;

    @Indexed(name = "email", type = "String")
    private String email;

    @Indexed(name = "mobile", type = "String")
    private String mobile;

    @Indexed(name = "fullname", type = "String")
    private String fullname;

    @Indexed(name = "telephone", type = "String")
    private String telephone;

    @Indexed(name = "internationalcode", type = "String")
    private String internationalcode;

    @Indexed(name = "isActive", type = "String")
    private Boolean isActive;

    @Indexed(name = "isOnline", type = "String")
    private boolean isOnline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getInternationalcode() {
        return internationalcode;
    }

    public void setInternationalcode(String internationalcode) {
        this.internationalcode = internationalcode;
    }
}

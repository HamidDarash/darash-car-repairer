package com.darash.carrepairer.solr.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "keyspacesaipa.users")
public class UsersSolrEntity {
/*
<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<schema name="autoSolrSchema" version="1.5">
  <types>
    <fieldType class="org.apache.solr.schema.UUIDField" name="UUIDField"/>
    <fieldType class="org.apache.solr.schema.BoolField" name="BoolField"/>
    <fieldType class="org.apache.solr.schema.StrField" name="StrField"/>
    <fieldType class="org.apache.solr.schema.BinaryField" name="BinaryField"/>
    <fieldType class="org.apache.solr.schema.TrieDateField" name="TrieDateField"/>
  </types>
  <fields>
    <field docValues="true" indexed="true" multiValued="false" name="id" type="UUIDField"/>
    <field docValues="true" indexed="true" multiValued="false" name="usertypeid" type="UUIDField"/>
    <field indexed="true" multiValued="false" name="isactive" type="BoolField"/>
    <field indexed="true" multiValued="false" name="password" type="StrField"/>
    <field indexed="true" multiValued="false" name="email" type="StrField"/>
    <field indexed="true" multiValued="false" name="caridavatar" type="BinaryField"/>
    <field indexed="true" multiValued="false" name="fullname" type="StrField"/>
    <field indexed="true" multiValued="false" name="avatar" type="BinaryField"/>
    <field indexed="true" multiValued="false" name="telephone" type="StrField"/>
    <field indexed="true" multiValued="false" name="internationalcode" type="StrField"/>
    <field docValues="true" indexed="true" multiValued="false" name="eventtime" type="TrieDateField"/>
    <field docValues="true" indexed="true" multiValued="false" name="timestamp" type="UUIDField"/>
    <field indexed="true" multiValued="false" name="ip" type="StrField"/>
    <field indexed="true" multiValued="false" name="address" type="StrField"/>
    <field indexed="true" multiValued="false" name="mobile" type="StrField"/>
    <field indexed="true" multiValued="false" name="isonline" type="BoolField"/>
  </fields>
  <uniqueKey>(id,email,timestamp,internationalcode)</uniqueKey>
</schema>
 */

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

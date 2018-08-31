package com.darash.carrepairer.entities;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Table(value = "users")
public class User implements Serializable {
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

    @CassandraType(type = DataType.Name.INT)
    private UserType userType;

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInternationalcode() {
        return internationalcode;
    }

    public void setInternationalcode(String internationalcode) {
        this.internationalcode = internationalcode;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public byte[] getCarIdAvatar() {
        return carIdAvatar;
    }

    public void setCarIdAvatar(byte[] carIdAvatar) {
        this.carIdAvatar = carIdAvatar;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public User(String internationalcode, String fullname, String password, String email, String address, String mobile, String telephone, byte[] avatar, byte[] carIdAvatar, Boolean isActive, Boolean isOnline, String ip) {
        this.eventTime = new Date();
        this.internationalcode = internationalcode;
        this.fullname = fullname;
        this.password = password;
        this.email = email;
        this.address = address;
        this.mobile = mobile;
        this.telephone = telephone;
        this.avatar = avatar;
        this.carIdAvatar = carIdAvatar;
        this.isActive = isActive;
        this.isOnline = isOnline;
        this.ip = ip;
    }
}

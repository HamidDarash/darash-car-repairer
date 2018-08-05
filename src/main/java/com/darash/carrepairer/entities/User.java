package com.darash.carrepairer.entities;

import com.datastax.driver.core.DataType;
import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Table(value = "users")
public class User implements Serializable {
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED, ordering = Ordering.ASCENDING)
    private UUID id = UUIDs.random() ;

    @PrimaryKeyColumn(name = "timestamp", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    private UUID timeStamp = UUIDs.timeBased();

    @Column
    private Date eventTime;

    @PrimaryKeyColumn(name = "internationalcode", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.ASCENDING)
    private String internationalcode;
    @Column
    private String fullname;
    @Column
    private String password;
    @PrimaryKeyColumn(name = "email", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
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
    private boolean isOnline;
    @Column
    private String ip;

    @Column
    private UUID usertypeid;

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

    public boolean getOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public UUID getUsertypeid() {
        return usertypeid;
    }

    public void setUsertypeid(UUID usertypeid) {
        this.usertypeid = usertypeid;
    }

    public UUID getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(UUID timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }

    public User(String internationalcode, String fullname, String password, String email, String address, String mobile, String telephone, byte[] avatar, byte[] carIdAvatar, Boolean isActive, Boolean isOnline, String ip, UUID usertypeid) {
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
        this.usertypeid = usertypeid;
    }

    public boolean isOnline() {
        return isOnline;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", timeStamp=" + timeStamp +
                ", eventTime=" + eventTime +
                ", internationalcode='" + internationalcode + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", telephone='" + telephone + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                ", carIdAvatar=" + Arrays.toString(carIdAvatar) +
                ", isActive=" + isActive +
                ", isOnline=" + isOnline +
                ", ip='" + ip + '\'' +
                ", usertypeid=" + usertypeid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return isOnline() == user.isOnline() &&
                Objects.equals(getId(), user.getId()) &&
                Objects.equals(getTimeStamp(), user.getTimeStamp()) &&
                Objects.equals(getEventTime(), user.getEventTime()) &&
                Objects.equals(getInternationalcode(), user.getInternationalcode()) &&
                Objects.equals(getFullname(), user.getFullname()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getMobile(), user.getMobile()) &&
                Objects.equals(getTelephone(), user.getTelephone()) &&
                Arrays.equals(getAvatar(), user.getAvatar()) &&
                Arrays.equals(getCarIdAvatar(), user.getCarIdAvatar()) &&
                Objects.equals(isActive, user.isActive) &&
                Objects.equals(getIp(), user.getIp()) &&
                Objects.equals(getUsertypeid(), user.getUsertypeid());
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(getId(), getTimeStamp(), getEventTime(), getInternationalcode(), getFullname(), getPassword(), getEmail(), getAddress(), getMobile(), getTelephone(), isActive, isOnline(), getIp(), getUsertypeid());
        result = 31 * result + Arrays.hashCode(getAvatar());
        result = 31 * result + Arrays.hashCode(getCarIdAvatar());
        return result;
    }
}

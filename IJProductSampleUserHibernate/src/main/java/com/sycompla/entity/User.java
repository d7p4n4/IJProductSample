package com.sycompla.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Userek", catalog = "UserTeszt", schema = "dbo")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "guid")
    public String guid;

    @Column(name = "createdAt")
    public Date createdAt;

    @Column(name = "updatedAt")
    public Date updatedAt;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "oAuthToken")
    public String oAuthToken;

    @Column(name = "language")
    public String language;

    @Column(name = "phoneNumber")
    public String phoneNumber;

    @Column(name = "userName")
    public String userName;

    public User() {}

    public User(String guid, Date createdAt, Date updatedAt, String name, String email, String password, String oAuthToken, String language, String phoneNumber, String userName) {
        this.guid = guid;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.name = name;
        this.email = email;
        this.password = password;
        this.oAuthToken = oAuthToken;
        this.language = language;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getoAuthToken() {
        return oAuthToken;
    }

    public void setoAuthToken(String oAuthToken) {
        this.oAuthToken = oAuthToken;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
} // User

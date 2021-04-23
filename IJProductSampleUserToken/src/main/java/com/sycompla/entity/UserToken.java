package com.sycompla.entity;

import javax.persistence.*;

@Entity
@Table(name = "UserToken", catalog = "UserDb", schema = "dbo")
public class UserToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "userGuid")
    public String userGuid;

    @Column(name = "fbToken")
    public String fbToken;

    public UserToken() {}

    public UserToken(String userGuid, String fbToken) {
        this.userGuid = userGuid;
        this.fbToken = fbToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserGuid() {
        return userGuid;
    }

    public void setUserGuid(String userGuid) {
        this.userGuid = userGuid;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
} // UserToken

package com.sycompla.entity;

import javax.persistence.*;

@Entity
@Table(name = "Request", catalog = "UserDb", schema = "dbo")
@org.hibernate.annotations.Entity(
        dynamicUpdate = true
)
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "guid")
    public String guid;

    @Column(name = "checkData")
    public String checkData;

    public Request() {}

    public Request(String guid, String checkData) {
        this.guid = guid;
        this.checkData = checkData;
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

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }
} // Request

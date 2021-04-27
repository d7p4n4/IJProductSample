package com.sycompla.entity;

import javax.persistence.*;

@Entity
@Table(name = "CycleTimeTest", catalog = "UserTeszt", schema = "dbo")
public class CycleTimeTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;

    @Column(name = "guid")
    public String guid;

    @Column(name = "name")
    public String name;

    public CycleTimeTest() {
    }

    public CycleTimeTest(String guid, String name) {
        this.guid = guid;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
} // CycleTimeTest
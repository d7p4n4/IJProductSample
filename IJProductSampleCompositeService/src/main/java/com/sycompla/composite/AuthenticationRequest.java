package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceRequest;

public class AuthenticationRequest extends Ac4yServiceRequest {

    public int id;

    public String guid;

    public String fbToken;

    public AuthenticationRequest() {}

    public AuthenticationRequest(int id, String guid, String fbToken) {
        this.id = id;
        this.guid = guid;
        this.fbToken = fbToken;
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

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
} // AuthenticationRequest

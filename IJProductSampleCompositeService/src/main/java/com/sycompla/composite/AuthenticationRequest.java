package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceRequest;

public class AuthenticationRequest extends Ac4yServiceRequest {

    public int id;

    public String checkData;

    public String fbToken;

    public AuthenticationRequest() {}

    public AuthenticationRequest(String checkData, String fbToken) {
        this.checkData = checkData;
        this.fbToken = fbToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
} // AuthenticationRequest

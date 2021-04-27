package com.sycompla.object.compositeService;

import ac4y.service.domain.Ac4yServiceRequest;

public class LogInRequest extends Ac4yServiceRequest {

    public String fbToken;

    public LogInRequest() {}

    public LogInRequest(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
} // LogInRequest

package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.RequestToken;

public class LogInResponse extends Ac4yServiceResponse {

    public String fbToken;

    public RequestToken authenticationRequest;

    public LogInResponse() {}

    public LogInResponse(String fbToken, RequestToken authenticationRequest) {
        this.fbToken = fbToken;
        this.authenticationRequest = authenticationRequest;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

    public RequestToken getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(RequestToken authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }
} // LogInResponse

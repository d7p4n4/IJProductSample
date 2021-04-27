package com.sycompla.object.compositeService;

import ac4y.service.domain.Ac4yServiceResponse;

public class LogInResponse extends Ac4yServiceResponse {

    public String fbToken;

    public AuthenticationRequest authenticationRequest;

    public LogInResponse() {}

    public LogInResponse(String fbToken, AuthenticationRequest authenticationRequest) {
        this.fbToken = fbToken;
        this.authenticationRequest = authenticationRequest;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

    public AuthenticationRequest getAuthenticationRequest() {
        return authenticationRequest;
    }

    public void setAuthenticationRequest(AuthenticationRequest authenticationRequest) {
        this.authenticationRequest = authenticationRequest;
    }
} // LogInResponse

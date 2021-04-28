package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceRequest;

public class GetUserGuidByTokenRequest extends Ac4yServiceRequest {

    public String fbToken;

    public GetUserGuidByTokenRequest() {}

    public GetUserGuidByTokenRequest(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

} // GetUserGuidByTokenRequest

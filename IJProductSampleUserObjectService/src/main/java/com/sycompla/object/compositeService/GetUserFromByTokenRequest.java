package com.sycompla.object.compositeService;

import ac4y.service.domain.Ac4yServiceRequest;

public class GetUserFromByTokenRequest extends Ac4yServiceRequest {

    public String fbToken;

    public GetUserFromByTokenRequest() {}

    public GetUserFromByTokenRequest(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

} // GetUserFromByTokenRequest

package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceRequest;

public class IsExistsByFbTokenRequest extends Ac4yServiceRequest {

    public String fbToken;

    public IsExistsByFbTokenRequest() {}

    public IsExistsByFbTokenRequest(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }
} // IsExistsByFbTokenRequest

package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.object.userToken.GetByFbTokenRequest;

public class GetUserByTokenRequest extends Ac4yServiceRequest {

    public String fbToken;

    public GetUserByTokenRequest() {}

    public GetUserByTokenRequest(String fbToken) {
        this.fbToken = fbToken;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

} // GetUserByTokenRequest

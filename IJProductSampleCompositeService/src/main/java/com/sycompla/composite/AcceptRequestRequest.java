package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceRequest;

public class AcceptRequestRequest extends Ac4yServiceRequest {

    public String guid;

    public String fbToken;

    public AcceptRequestRequest() {}

    public AcceptRequestRequest(String guid, String fbToken) {
        this.guid = guid;
        this.fbToken = fbToken;
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
} // AcceptRequestRequest

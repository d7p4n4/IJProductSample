package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceRequest;

public class GetByGuidRequest extends Ac4yServiceRequest {

    public String guid;

    public GetByGuidRequest() {}

    public GetByGuidRequest(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
} // GetByGuidRequest
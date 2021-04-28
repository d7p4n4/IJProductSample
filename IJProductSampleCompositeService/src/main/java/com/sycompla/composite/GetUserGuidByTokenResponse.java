package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceResponse;

public class GetUserGuidByTokenResponse extends Ac4yServiceResponse {

    public String guid;

    public GetUserGuidByTokenResponse() {}

    public GetUserGuidByTokenResponse(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

} // GetUserGuidByTokenResponse

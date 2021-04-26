package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.RequestToken;

public class InsertResponse extends Ac4yServiceResponse {

    public RequestToken requestToken;

    public InsertResponse() {}

    public InsertResponse(RequestToken requestToken) {

        this.requestToken = requestToken;

    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(RequestToken requestToken) {
        this.requestToken = requestToken;
    }
} // InsertResponse

package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.RequestToken;

public class InsertRequest extends Ac4yServiceRequest {

    public RequestToken requestToken;

    public InsertRequest() {}

    public InsertRequest(RequestToken requestToken) {
        this.requestToken = requestToken;
    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(RequestToken requestToken) {
        this.requestToken = requestToken;
    }
} // InsertRequest

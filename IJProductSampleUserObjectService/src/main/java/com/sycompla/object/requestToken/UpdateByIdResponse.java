package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.RequestToken;

public class UpdateByIdResponse extends Ac4yServiceResponse {

    public RequestToken requestToken;

    public UpdateByIdResponse() {}

    public UpdateByIdResponse(RequestToken requestToken) {

        this.requestToken = requestToken;

    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(RequestToken requestToken) {
        this.requestToken = requestToken;
    }
} // UpdateByIdResponse

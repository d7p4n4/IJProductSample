package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.RequestToken;

public class UpdateByIdRequest extends Ac4yServiceRequest {

    public RequestToken requestToken;

    public int id;

    public UpdateByIdRequest() {}

    public UpdateByIdRequest(RequestToken requestToken, int id) {
        this.requestToken = requestToken;
        this.id = id;
    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(RequestToken requestToken) {
        this.requestToken = requestToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // UpdateByIdRequest

package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.RequestToken;

public class UpdateByGuidRequest extends Ac4yServiceRequest {

    public String guid;

    public RequestToken requestToken;

    public UpdateByGuidRequest() {}

    public UpdateByGuidRequest(String guid, RequestToken requestToken) {
        this.guid = guid;
        this.requestToken = requestToken;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public RequestToken getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(RequestToken requestToken) {
        this.requestToken = requestToken;
    }
} // UpdateByGuidRequest

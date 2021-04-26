package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceRequest;

public class IsExistsByGuidRequest extends Ac4yServiceRequest {

    public String guid;

    public IsExistsByGuidRequest() {}

    public IsExistsByGuidRequest(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
} // IsExistsByGuidRequest

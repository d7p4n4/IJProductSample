package com.sycompla.object.compositeService;

import ac4y.service.domain.Ac4yServiceRequest;

public class AcceptAuthenticationRequest extends Ac4yServiceRequest {

    public String guid;

    public String checkData;

    public AcceptAuthenticationRequest() {}

    public AcceptAuthenticationRequest(String guid, String checkData) {
        this.guid = guid;
        this.checkData = checkData;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

} // AcceptAuthenticationRequest

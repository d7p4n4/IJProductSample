package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceRequest;

public class GetByIdRequest extends Ac4yServiceRequest {

    public int id;

    public GetByIdRequest() {}

    public GetByIdRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // GetByIdRequest

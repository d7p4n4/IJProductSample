package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceRequest;

public class DeleteRequest extends Ac4yServiceRequest {

    public int id;

    public DeleteRequest() {}

    public DeleteRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // DeleteRequest

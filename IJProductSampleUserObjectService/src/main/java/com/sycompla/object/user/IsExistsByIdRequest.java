package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceRequest;

public class IsExistsByIdRequest extends Ac4yServiceRequest {

    public int id;

    public IsExistsByIdRequest() {}

    public IsExistsByIdRequest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // IsExistsByIdRequest

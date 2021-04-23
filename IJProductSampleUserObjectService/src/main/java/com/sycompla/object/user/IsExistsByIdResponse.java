package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceResponse;

public class IsExistsByIdResponse extends Ac4yServiceResponse {

    public Boolean exists;

    public IsExistsByIdResponse() {}

    public IsExistsByIdResponse(Boolean exists) {
        this.exists = exists;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }
} // IsExistsByIdResponse

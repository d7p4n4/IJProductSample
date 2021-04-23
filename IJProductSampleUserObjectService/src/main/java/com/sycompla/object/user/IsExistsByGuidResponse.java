package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceResponse;

public class IsExistsByGuidResponse extends Ac4yServiceResponse {

    public Boolean exists;

    public IsExistsByGuidResponse() {}

    public IsExistsByGuidResponse(Boolean exists) {
        this.exists = exists;
    }

    public Boolean getExists() {
        return exists;
    }

    public void setExists(Boolean exists) {
        this.exists = exists;
    }

} // IsExistsByGuidResponse

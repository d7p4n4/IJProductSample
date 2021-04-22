package com.sycompla.objectService.category;

import ac4y.service.domain.Ac4yServiceRequest;

public class GetCategoryByIdRequest extends Ac4yServiceRequest {

    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

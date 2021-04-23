package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class GetByIdResponse extends Ac4yServiceResponse {

    public User user;

    public GetByIdResponse() {}

    public GetByIdResponse(User user) {

        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // GetByIdResponse

package com.sycompla.object;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class UpdateByIdResponse extends Ac4yServiceResponse {

    public User user;

    public UpdateByIdResponse() {}

    public UpdateByIdResponse(User user) {

        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // UpdateByIdResponse

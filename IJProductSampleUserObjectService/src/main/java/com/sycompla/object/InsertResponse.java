package com.sycompla.object;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class InsertResponse extends Ac4yServiceResponse {

    public User user;

    public InsertResponse() {}

    public InsertResponse(User user) {

        this.user = user;

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // InsertResponse

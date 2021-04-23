package com.sycompla.object;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;

public class InsertRequest extends Ac4yServiceRequest {

    public User user;

    public InsertRequest() {}

    public InsertRequest(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // InsertRequest

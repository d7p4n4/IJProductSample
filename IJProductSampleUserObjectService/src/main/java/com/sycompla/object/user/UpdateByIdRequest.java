package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;

public class UpdateByIdRequest extends Ac4yServiceRequest {

    public User user;

    public int id;

    public UpdateByIdRequest() {}

    public UpdateByIdRequest(User user, int id) {
        this.user = user;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // UpdateByIdRequest

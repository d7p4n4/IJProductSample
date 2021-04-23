package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class UpdateByGuidResponse extends Ac4yServiceResponse {

    public User user;

    public UpdateByGuidResponse() {}

    public UpdateByGuidResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // UpdateByGuidResponse

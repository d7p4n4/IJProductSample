package com.sycompla.object;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class GetByGuidResponse extends Ac4yServiceResponse {

    public User user;

    public GetByGuidResponse() {}

    public GetByGuidResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // GetByGuidResponse

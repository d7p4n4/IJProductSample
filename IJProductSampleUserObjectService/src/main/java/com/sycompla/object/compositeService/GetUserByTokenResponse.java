package com.sycompla.object.compositeService;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class GetUserByTokenResponse extends Ac4yServiceResponse {

    public User user;

    public GetUserByTokenResponse() {}

    public GetUserByTokenResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // GetUserByTokenResponse

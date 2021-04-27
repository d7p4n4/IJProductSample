package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

public class GetUserFromByTokenResponse extends Ac4yServiceResponse {

    public User user;

    public GetUserFromByTokenResponse() {}

    public GetUserFromByTokenResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // GetUserFromByTokenResponse

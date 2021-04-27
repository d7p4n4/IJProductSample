package com.sycompla.composite;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;

public class SignUpRequest extends Ac4yServiceRequest {

    public String fbToken;

    public User user;

    public SignUpRequest() {}

    public SignUpRequest(String fbToken, User user) {
        this.fbToken = fbToken;
        this.user = user;
    }

    public String getFbToken() {
        return fbToken;
    }

    public void setFbToken(String fbToken) {
        this.fbToken = fbToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // SignUpRequest

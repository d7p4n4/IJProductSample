package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;

public class InsertRequest extends Ac4yServiceRequest {

    public UserToken userToken;

    public InsertRequest() {}

    public InsertRequest(UserToken userToken) {
        this.userToken = userToken;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }
} // InsertRequest

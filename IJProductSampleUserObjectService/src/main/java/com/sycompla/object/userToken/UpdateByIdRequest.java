package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;

public class UpdateByIdRequest extends Ac4yServiceRequest {

    public UserToken userToken;

    public int id;

    public UpdateByIdRequest() {}

    public UpdateByIdRequest(UserToken userToken, int id) {
        this.userToken = userToken;
        this.id = id;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // UpdateByIdRequest

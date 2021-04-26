package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;

public class UpdateByGuidResponse extends Ac4yServiceResponse {

    public UserToken userToken;

    public UpdateByGuidResponse() {}

    public UpdateByGuidResponse(UserToken userToken) {
        this.userToken = userToken;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }
} // UpdateByGuidResponse

package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;

public class GetByGuidResponse extends Ac4yServiceResponse {

    public UserToken userToken;

    public GetByGuidResponse() {}

    public GetByGuidResponse(UserToken userToken) {
        this.userToken = userToken;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }
} // GetByGuidResponse

package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;

public class UpdateByGuidRequest extends Ac4yServiceRequest {

    public String guid;

    public UserToken userToken;

    public UpdateByGuidRequest() {}

    public UpdateByGuidRequest(String guid, UserToken userToken) {
        this.guid = guid;
        this.userToken = userToken;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public UserToken getUserToken() {
        return userToken;
    }

    public void setUserToken(UserToken userToken) {
        this.userToken = userToken;
    }
} // UpdateByGuidRequest

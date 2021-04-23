package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.User;

public class UpdateByGuidRequest extends Ac4yServiceRequest {

    public String guid;

    public User user;

    public UpdateByGuidRequest() {}

    public UpdateByGuidRequest(String guid, User user) {
        this.guid = guid;
        this.user = user;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
} // UpdateByGuidRequest

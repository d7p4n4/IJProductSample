package com.sycompla.object.user;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;

import java.util.List;

public class GetListResponse extends Ac4yServiceResponse {

    public List<User> userList;

    public GetListResponse() {}

    public GetListResponse(List<User> userList) {

        this.userList = userList;

    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
} // GetListResponse

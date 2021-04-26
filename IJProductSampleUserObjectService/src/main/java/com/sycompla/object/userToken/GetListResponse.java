package com.sycompla.object.userToken;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.User;
import com.sycompla.entity.UserToken;

import java.util.List;

public class GetListResponse extends Ac4yServiceResponse {

    public List<UserToken> userTokenList;

    public GetListResponse() {}

    public GetListResponse(List<UserToken> userTokenList) {

        this.userTokenList = userTokenList;

    }

    public List<UserToken> getUserTokenList() {
        return userTokenList;
    }

    public void setUserTokenList(List<UserToken> userTokenList) {
        this.userTokenList = userTokenList;
    }
} // GetListResponse

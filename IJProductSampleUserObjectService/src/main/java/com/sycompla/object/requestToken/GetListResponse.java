package com.sycompla.object.requestToken;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.RequestToken;
import com.sycompla.entity.RequestToken;

import java.util.List;

public class GetListResponse extends Ac4yServiceResponse {

    public List<RequestToken> requestTokenList;

    public GetListResponse() {}

    public GetListResponse(List<RequestToken> requestTokenList) {

        this.requestTokenList = requestTokenList;

    }

    public List<RequestToken> getRequestTokenList() {
        return requestTokenList;
    }

    public void setRequestTokenList(List<RequestToken> requestTokenList) {
        this.requestTokenList = requestTokenList;
    }
} // GetListResponse

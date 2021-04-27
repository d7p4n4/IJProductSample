package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.CycleTimeTest;

import java.util.List;

public class GetListResponse extends Ac4yServiceResponse {

    public List<CycleTimeTest> cycleTimeTestList;

    public GetListResponse() {}

    public GetListResponse(List<CycleTimeTest> cycleTimeTestList) {

        this.cycleTimeTestList = cycleTimeTestList;

    }

    public List<CycleTimeTest> getCycleTimeTestList() {
        return cycleTimeTestList;
    }

    public void setCycleTimeTestList(List<CycleTimeTest> cycleTimeTestList) {
        this.cycleTimeTestList = cycleTimeTestList;
    }
} // GetListResponse

package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.CycleTimeTest;

public class GetByIdResponse extends Ac4yServiceResponse {

    public CycleTimeTest cycleTimeTest;

    public GetByIdResponse() {}

    public GetByIdResponse(CycleTimeTest cycleTimeTest) {

        this.cycleTimeTest = cycleTimeTest;

    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }
} // GetByIdResponse

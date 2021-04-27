package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.CycleTimeTest;

public class GetByGuidResponse extends Ac4yServiceResponse {

    public CycleTimeTest cycleTimeTest;

    public GetByGuidResponse() {}

    public GetByGuidResponse(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }
} // GetByGuidResponse

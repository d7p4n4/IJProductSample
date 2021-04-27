package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.CycleTimeTest;

public class InsertResponse extends Ac4yServiceResponse {

    public CycleTimeTest cycleTimeTest;

    public InsertResponse() {}

    public InsertResponse(CycleTimeTest cycleTimeTest) {

        this.cycleTimeTest = cycleTimeTest;

    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }
} // InsertResponse

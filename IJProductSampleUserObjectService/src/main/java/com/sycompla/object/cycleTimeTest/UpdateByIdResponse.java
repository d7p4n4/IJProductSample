package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entity.CycleTimeTest;

public class UpdateByIdResponse extends Ac4yServiceResponse {

    public CycleTimeTest cycleTimeTest;

    public UpdateByIdResponse() {}

    public UpdateByIdResponse(CycleTimeTest cycleTimeTest) {

        this.cycleTimeTest = cycleTimeTest;

    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }
} // UpdateByIdResponse

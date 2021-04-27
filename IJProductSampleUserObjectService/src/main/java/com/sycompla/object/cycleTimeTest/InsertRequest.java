package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.CycleTimeTest;

public class InsertRequest extends Ac4yServiceRequest {

    public CycleTimeTest cycleTimeTest;

    public InsertRequest() {}

    public InsertRequest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }
} // InsertRequest

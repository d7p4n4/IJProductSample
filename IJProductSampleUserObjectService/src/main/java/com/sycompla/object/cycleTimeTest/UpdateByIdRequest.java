package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.CycleTimeTest;

public class UpdateByIdRequest extends Ac4yServiceRequest {

    public CycleTimeTest cycleTimeTest;

    public int id;

    public UpdateByIdRequest() {}

    public UpdateByIdRequest(CycleTimeTest cycleTimeTest, int id) {
        this.cycleTimeTest = cycleTimeTest;
        this.id = id;
    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
} // UpdateByIdRequest

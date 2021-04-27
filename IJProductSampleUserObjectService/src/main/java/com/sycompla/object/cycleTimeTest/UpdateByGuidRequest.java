package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yServiceRequest;
import com.sycompla.entity.CycleTimeTest;

public class UpdateByGuidRequest extends Ac4yServiceRequest {

    public String guid;

    public CycleTimeTest cycleTimeTest;

    public UpdateByGuidRequest() {}

    public UpdateByGuidRequest(String guid, CycleTimeTest cycleTimeTest) {
        this.guid = guid;
        this.cycleTimeTest = cycleTimeTest;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public CycleTimeTest getCycleTimeTest() {
        return cycleTimeTest;
    }

    public void setCycleTimeTest(CycleTimeTest cycleTimeTest) {
        this.cycleTimeTest = cycleTimeTest;
    }
} // UpdateByGuidRequest

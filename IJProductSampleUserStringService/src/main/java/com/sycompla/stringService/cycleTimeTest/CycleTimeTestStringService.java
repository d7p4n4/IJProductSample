package com.sycompla.stringService.cycleTimeTest;

import com.sycompla.object.cycleTimeTest.*;

public class CycleTimeTestStringService {

    public String getList(String request) {

        return new CycleTimeTestObjectService().getList(
                (GetListRequest) new GetListRequest().getFromJson(request)
        ).getAsJson();

    } // getList

    public String getById(String request) {

        return new CycleTimeTestObjectService().getById(
                (GetByIdRequest) new GetByIdRequest().getFromJson(request)
        ).getAsJson();

    } // getById

    public String getByGuid(String request) {

        return new CycleTimeTestObjectService().getByGuid(
                (GetByGuidRequest) new GetByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // getByGuid

    public String isExistsById(String request) {

        return new CycleTimeTestObjectService().isExistsById(
                (IsExistsByIdRequest) new IsExistsByIdRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsById

    public String isExistsByGuid(String request) {

        return new CycleTimeTestObjectService().isExistsByGuid(
                (IsExistsByGuidRequest) new IsExistsByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsByGuid

    public String insert(String request) {

        return new CycleTimeTestObjectService().insert(
                (InsertRequest) new InsertRequest().getFromJson(request)
        ).getAsJson();

    } // insert

    public String updateById(String request) {

        return new CycleTimeTestObjectService().updateById(
                (UpdateByIdRequest) new UpdateByIdRequest().getFromJson(request)
        ).getAsJson();

    } // updateById

    public String updateByGuid(String request) {

        return new CycleTimeTestObjectService().updateByGuid(
                (UpdateByGuidRequest) new UpdateByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // updateByGuid

    public String delete(String request) {

        return new CycleTimeTestObjectService().delete(
                (DeleteRequest) new DeleteRequest().getFromJson(request)
        ).getAsJson();

    } // delete

    public String deleteByGuid(String request) {

        return new CycleTimeTestObjectService().deleteByGuid(
                (DeleteByGuidRequest) new DeleteByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // deleteByGuid


} // CyCleTimeTestStringService

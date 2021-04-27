package com.sycompla.test.cycleTimeTest;

import com.sycompla.entity.CycleTimeTest;
import com.sycompla.object.cycleTimeTest.CycleTimeTestObjectService;
import com.sycompla.object.cycleTimeTest.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOG = LogManager.getLogger(Run.class);

    public GetByIdResponse getById() {

        GetByIdResponse response = new CycleTimeTestObjectService()
                .getById(new GetByIdRequest(
                        2
                ));

        return response;

    } // getById

    public GetByGuidResponse getByGuid() {

        GetByGuidResponse response = new CycleTimeTestObjectService()
                .getByGuid(new GetByGuidRequest(
                        "tesztguid"
                ));

        return response;

    } // getByGuid

    public GetListResponse getList() {

        GetListResponse response = new CycleTimeTestObjectService()
                .getList(new GetListRequest());

        return  response;

    } // getList

    public IsExistsByIdResponse isExistsById() {

        IsExistsByIdResponse response = new CycleTimeTestObjectService()
                .isExistsById(new IsExistsByIdRequest(
                        2
                ));

        return response;

    } // isExistsById

    public IsExistsByGuidResponse isExistsByGuid() {

        IsExistsByGuidResponse response = new CycleTimeTestObjectService()
                .isExistsByGuid(new IsExistsByGuidRequest(
                        "tesztguid"
                ));

        return response;

    } // isExistsByGuid

    public InsertResponse insert() {

        InsertResponse response = new CycleTimeTestObjectService()
                .insert(new InsertRequest(
                        new CycleTimeTest(
                                "tesztguid"
                                , "tesztname"
                        )
                ));

        return response;

    } // insert

    public UpdateByIdResponse updateById() {

        CycleTimeTest updatedCycleTimeTest = new CycleTimeTest();

        updatedCycleTimeTest.setGuid("694896851");


        UpdateByIdResponse response = new CycleTimeTestObjectService()
                .updateById(new UpdateByIdRequest(
                            updatedCycleTimeTest
                            , 2
                        )
                );

        return response;

    } // updateById

    public UpdateByGuidResponse updateByGuid() {

        CycleTimeTest updatedCycleTimeTest = new CycleTimeTest();

        updatedCycleTimeTest.setGuid("UPDATED");

        UpdateByGuidResponse response = new CycleTimeTestObjectService()
                .updateByGuid(new UpdateByGuidRequest(
                                "tesztguid"
                                , updatedCycleTimeTest
                        )
                );

        return response;

    } // updateByGuid

    public DeleteResponse delete() {

        DeleteResponse response = new CycleTimeTestObjectService()
                .delete(new DeleteRequest(
                        3
                ));

        return response;

    } // delete

    public DeleteByGuidResponse deleteByGuid() {

        DeleteByGuidResponse response = new CycleTimeTestObjectService()
                .deleteByGuid(new DeleteByGuidRequest(
                        "UPDATED"
                ));

        return response;

    } // deleteByGuid

    public static void main(String[] args) {

        new Run().getList();
        new Run().getById();
        new Run().getByGuid();
        new Run().isExistsById();
        new Run().isExistsByGuid();
        new Run().insert();
        new Run().updateById();
        new Run().updateByGuid();
        new Run().delete();
        new Run().deleteByGuid();

    } // main

} // Run
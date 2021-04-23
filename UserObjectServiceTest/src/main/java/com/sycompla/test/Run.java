package com.sycompla.test;

import com.sycompla.entity.User;
import com.sycompla.object.user.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;

public class Run {

    private static final Logger LOG = LogManager.getLogger(Run.class);

    public GetByIdResponse getById() {

        GetByIdResponse response = new UserObjectService()
                .getById(new GetByIdRequest(
                        255
                ));

        return response;

    } // getById

    public GetByGuidResponse getByGuid() {

        GetByGuidResponse response = new UserObjectService()
                .getByGuid(new GetByGuidRequest(
                        "9B77759771EF323AEB9F25EF1D98334F8B8931AD30B3998EF7446A7D1633B8D8DF31BD627411B75B9105643D9FE70B7CEA73BBB3673080EEDB625C195E0F3E68"
                ));

        return response;

    } // getByGuid

    public GetListResponse getList() {

        GetListResponse response = new UserObjectService()
                .getList(new GetListRequest());

        return  response;

    } // getList

    public IsExistsByIdResponse isExistsById() {

        IsExistsByIdResponse response = new UserObjectService()
                .isExistsById(new IsExistsByIdRequest(
                        55
                ));

        return response;

    } // isExistsById

    public IsExistsByGuidResponse isExistsByGuid() {

        IsExistsByGuidResponse response = new UserObjectService()
                .isExistsByGuid(new IsExistsByGuidRequest(
                        "teszdtguid"
                ));

        return response;

    } // isExistsByGuid

    public InsertResponse insert() {

        InsertResponse response = new UserObjectService()
                .insert(new InsertRequest(
                        new User(
                            "tesztG"
                                , new Date()
                                , new Date()
                                , "tester János"
                                , "test@mail.hu"
                                , "pwd123"
                                , "testtoken"
                                , "magyar"
                                , "+123456789"
                                , "uName"
                        )
                ));

        return response;

    } // insert

    public UpdateByIdResponse updateById() {

        User updatedUser = new User();

        updatedUser.setLanguage("updated");

        UpdateByIdResponse response = new UserObjectService()
                .updateById(new UpdateByIdRequest(
                            updatedUser
                            , 63
                        )
                );

        return response;

    } // updateById

    public UpdateByGuidResponse updateByGuid() {

        User updatedUser = new User();

        updatedUser.setLanguage("updated");

        UpdateByGuidResponse response = new UserObjectService()
                .updateByGuid(new UpdateByGuidRequest(
                                "tesztguid"
                                , updatedUser
                        )
                );

        return response;

    } // updateByGuid

    public DeleteResponse delete() {

        DeleteResponse response = new UserObjectService()
                .delete(new DeleteRequest(
                        88
                ));

        return response;

    } // delete

    public DeleteByGuidResponse deleteByGuid() {

        DeleteByGuidResponse response = new UserObjectService()
                .deleteByGuid(new DeleteByGuidRequest(
                        "tesztdguid"
                ));

        return response;

    } // deleteByGuid

    public static void main(String[] args) {

        //new Run().getList();
        //new Run().getById();
        //new Run().getByGuid();
        //new Run().getById();
        //new Run().isExistsById();
        //new Run().isExistsByGuid();
        //new Run().insert();
        //new Run().updateById();
//        new Run().updateByGuid();
//        new Run().delete();
        new Run().deleteByGuid();

    } // main

} // Run
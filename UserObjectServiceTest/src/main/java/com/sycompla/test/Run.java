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
                        2
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

    public IsExistsByIdResponse isExistsById(IsExistsByIdRequest request) {

        IsExistsByIdResponse response = new UserObjectService()
                .isExistsById(new IsExistsByIdRequest(
                        5
                ));

        return response;

    } // isExistsById

    public IsExistsByGuidResponse isExistsById(IsExistsByGuidRequest request) {

        IsExistsByGuidResponse response = new UserObjectService()
                .isExistsByGuid(new IsExistsByGuidRequest(
                        "tesztguid"
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

    public UpdateByIdResponse updateById(UpdateByIdRequest request) {

        User updatedUser = new User();

        updatedUser.setLanguage("updated");

        UpdateByIdResponse response = new UserObjectService()
                .updateById(new UpdateByIdRequest(
                            updatedUser
                            , 4
                        )
                );

        return response;

    } // updateById

    public DeleteResponse delete(DeleteRequest request) {

        DeleteResponse response = new UserObjectService()
                .delete(new DeleteRequest(
                        8
                ));

        return response;

    } // delete

    public DeleteByGuidResponse deleteByGuid(DeleteByGuidRequest request) {

        DeleteByGuidResponse response = new UserObjectService()
                .deleteByGuid(new DeleteByGuidRequest(
                        "tesztguid"
                ));

        return response;

    } // deleteByGuid

    public static void main(String[] args) {

        new Run().getList();
        //new Run().getById();

    } // main

} // Run
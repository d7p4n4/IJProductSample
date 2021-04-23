package com.sycompla.test;

import com.sycompla.entity.User;
import com.sycompla.object.*;
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

    public GetListResponse getList() {

        GetListResponse response = new UserObjectService()
                .getList(new GetListRequest());

        return  response;

    } // getList

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

    public static void main(String[] args) {

        //new Run().getCategoryById();
        new Run().getById();

    } // main

} // Run
package com.sycompla.test;

import com.sycompla.entity.User;
import com.sycompla.object.user.GetByIdRequest;
import com.sycompla.object.user.InsertRequest;
import com.sycompla.stringService.user.UserStringService;

import java.util.Date;

public class Run {

    public void getById(String request) {

        //String request = new GetByIdRequest(2).getAsJson();

        System.out.println(
                new UserStringService().getById(
                        request
                )
        );

    } // getById

    public void insert() {

        String request = new InsertRequest(
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
        ).getAsJson();

    } // insert

    public static void main(String[] args) {

        //new Run().getList();
      //  new Run().getById("{'id': 2}");
        //new Run().getByGuid();
        //new Run().getById();
        //new Run().isExistsById();
        //new Run().isExistsByGuid();
        new Run().insert();
        //new Run().updateById();
//        new Run().updateByGuid();
//        new Run().delete();
//        new Run().deleteByGuid();

    } // main

} // Run
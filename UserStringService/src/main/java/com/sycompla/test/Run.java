package com.sycompla.test;

import com.sycompla.entity.User;
import com.sycompla.object.user.DeleteByGuidRequest;
import com.sycompla.object.user.GetByIdRequest;
import com.sycompla.object.user.InsertRequest;
import com.sycompla.object.user.UpdateByIdRequest;
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

    public void deleteByGuid(String request) {

        String requestAsString = new DeleteByGuidRequest("tesztguid").getAsJson();

        String response = new UserStringService().deleteByGuid(request);

        System.out.println(response);

    } // deleteByGuid

    public void updateById(String request) {

        String requestAsString = new UpdateByIdRequest(
                new User(
                        "tesztG"
                        , "tester János"
                        , "test@mail.hu"
                        , "pwd123"
                        , "testtoken"
                        , "magyar"
                        , "+123456789"
                        , "uName"
                )
                , 6
        ).getAsJson();

        String response = new UserStringService().updateById(request);

        System.out.println(response);

    } // updateById

    public static void main(String[] args) {

        //new Run().getList();
      //  new Run().getById("{'id': 2}");
        //new Run().getByGuid();
        //new Run().getById();
        //new Run().isExistsById();
        //new Run().isExistsByGuid();
//        new Run().insert();
        new Run().updateById("{\"user\":{\"id\":0,\"guid\":\"null\",\"name\":\"tester János\",\"email\":\"test@mail.hu\",\"password\":\"pwd123\",\"oAuthToken\":\"testtoken\",\"language\":\"magyar\",\"phoneNumber\":\"+123456789\",\"userName\":\"uName\"},\"id\":10}");
//        new Run().updateByGuid();
//        new Run().delete();
//        new Run().deleteByGuid("{\"guid\":\"tesztguid\"}");

    } // main

} // Run
package com.sycompla.test.userToken;

import com.sycompla.entity.UserToken;
import com.sycompla.object.userToken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOG = LogManager.getLogger(Run.class);

    public GetByIdResponse getById() {

        GetByIdResponse response = new UserTokenObjectService()
                .getById(new GetByIdRequest(
                        2
                ));

        return response;

    } // getById

    public GetByGuidResponse getByGuid() {

        GetByGuidResponse response = new UserTokenObjectService()
                .getByGuid(new GetByGuidRequest(
                        "9B77759771EF323AEB9F25EF1D98334F8B8931AD30B3998EF7446A7D1633B8D8DF31BD627411B75B9105643D9FE70B7CEA73BBB3673080EEDB625C195E0F3E68"
                ));

        return response;

    } // getByGuid

    public GetListResponse getList() {

        GetListResponse response = new UserTokenObjectService()
                .getList(new GetListRequest());

        return  response;

    } // getList

    public IsExistsByIdResponse isExistsById() {

        IsExistsByIdResponse response = new UserTokenObjectService()
                .isExistsById(new IsExistsByIdRequest(
                        5
                ));

        return response;

    } // isExistsById

    public IsExistsByGuidResponse isExistsByGuid() {

        IsExistsByGuidResponse response = new UserTokenObjectService()
                .isExistsByGuid(new IsExistsByGuidRequest(
                        "tesztguid"
                ));

        return response;

    } // isExistsByGuid

    public InsertResponse insert() {

        InsertResponse response = new UserTokenObjectService()
                .insert(new InsertRequest(
                        new UserToken(
                                "userguid"
                                , "token"
                        )
                ));

        return response;

    } // insert

    public UpdateByIdResponse updateById() {

        UserToken updatedUserToken = new UserToken();

        updatedUserToken.setFbToken("UPDATED");

        UpdateByIdResponse response = new UserTokenObjectService()
                .updateById(new UpdateByIdRequest(
                            updatedUserToken
                            , 6
                        )
                );

        return response;

    } // updateById

    public UpdateByGuidResponse updateByGuid() {

        UserToken updatedUserToken = new UserToken();

        updatedUserToken.setFbToken("UPDATED");

        UpdateByGuidResponse response = new UserTokenObjectService()
                .updateByGuid(new UpdateByGuidRequest(
                                "tesztguid"
                                , updatedUserToken
                        )
                );

        return response;

    } // updateByGuid

    public DeleteResponse delete() {

        DeleteResponse response = new UserTokenObjectService()
                .delete(new DeleteRequest(
                        88
                ));

        return response;

    } // delete

    public DeleteByGuidResponse deleteByGuid() {

        DeleteByGuidResponse response = new UserTokenObjectService()
                .deleteByGuid(new DeleteByGuidRequest(
                        "userguid"
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
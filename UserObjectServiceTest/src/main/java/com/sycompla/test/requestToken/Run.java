package com.sycompla.test.requestToken;

import com.sycompla.entity.RequestToken;
import com.sycompla.object.requestToken.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOG = LogManager.getLogger(Run.class);

    public GetByIdResponse getById() {

        GetByIdResponse response = new RequestTokenObjectService()
                .getById(new GetByIdRequest(
                        255
                ));

        return response;

    } // getById

    public GetByGuidResponse getByGuid() {

        GetByGuidResponse response = new RequestTokenObjectService()
                .getByGuid(new GetByGuidRequest(
                        "9B77759771EF323AEB9F25EF1D98334F8B8931AD30B3998EF7446A7D1633B8D8DF31BD627411B75B9105643D9FE70B7CEA73BBB3673080EEDB625C195E0F3E68"
                ));

        return response;

    } // getByGuid

    public GetListResponse getList() {

        GetListResponse response = new RequestTokenObjectService()
                .getList(new GetListRequest());

        return  response;

    } // getList

    public IsExistsByIdResponse isExistsById() {

        IsExistsByIdResponse response = new RequestTokenObjectService()
                .isExistsById(new IsExistsByIdRequest(
                        55
                ));

        return response;

    } // isExistsById

    public IsExistsByGuidResponse isExistsByGuid() {

        IsExistsByGuidResponse response = new RequestTokenObjectService()
                .isExistsByGuid(new IsExistsByGuidRequest(
                        "9B77759771EF323AEB9F25dEF1D98334F8B8931AD30B3998EF7446A7D1633B8D8DF31BD627411B75B9105643D9FE70B7CEA73BBB3673080EEDB625C195E0F3E68"
                ));

        return response;

    } // isExistsByGuid

    public InsertResponse insert() {

        InsertResponse response = new RequestTokenObjectService()
                .insert(new InsertRequest(
                        new RequestToken(
                                "UserGuid"
                                , "625"
                        )
                ));

        return response;

    } // insert

    public UpdateByIdResponse updateById() {

        RequestToken updatedRequestToken = new RequestToken();

        updatedRequestToken.setCheckData("694896851");


        UpdateByIdResponse response = new RequestTokenObjectService()
                .updateById(new UpdateByIdRequest(
                            updatedRequestToken
                            , 2
                        )
                );

        return response;

    } // updateById

    public UpdateByGuidResponse updateByGuid() {

        RequestToken updatedRequestToken = new RequestToken();

        updatedRequestToken.setGuid("UPDATED");

        UpdateByGuidResponse response = new RequestTokenObjectService()
                .updateByGuid(new UpdateByGuidRequest(
                                "UserGuid"
                                , updatedRequestToken
                        )
                );

        return response;

    } // updateByGuid

    public DeleteResponse delete() {

        DeleteResponse response = new RequestTokenObjectService()
                .delete(new DeleteRequest(
                        3
                ));

        return response;

    } // delete

    public DeleteByGuidResponse deleteByGuid() {

        DeleteByGuidResponse response = new RequestTokenObjectService()
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
package com.sycompla.stringService.userToken;

import com.sycompla.object.userToken.*;

public class UserTokenStringService {

    public String getList(String request) {

        return new UserTokenObjectService().getList(
                (GetListRequest) new GetListRequest().getFromJson(request)
        ).getAsJson();

    } // getList

    public String getById(String request) {

        return new UserTokenObjectService().getById(
                (GetByIdRequest) new GetByIdRequest().getFromJson(request)
        ).getAsJson();

    } // getById

    public String getByGuid(String request) {

        return new UserTokenObjectService().getByGuid(
                (GetByGuidRequest) new GetByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // getByGuid

    public String isExistsById(String request) {

        return new UserTokenObjectService().isExistsById(
                (IsExistsByIdRequest) new IsExistsByIdRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsById

    public String isExistsByGuid(String request) {

        return new UserTokenObjectService().isExistsByGuid(
                (IsExistsByGuidRequest) new IsExistsByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsByGuid

    public String insert(String request) {

        return new UserTokenObjectService().insert(
                (InsertRequest) new InsertRequest().getFromJson(request)
        ).getAsJson();

    } // insert

    public String updateById(String request) {

        return new UserTokenObjectService().updateById(
                (UpdateByIdRequest) new UpdateByIdRequest().getFromJson(request)
        ).getAsJson();

    } // updateById

    public String updateByGuid(String request) {

        return new UserTokenObjectService().updateByGuid(
                (UpdateByGuidRequest) new UpdateByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // updateByGuid

    public String delete(String request) {

        return new UserTokenObjectService().delete(
                (DeleteRequest) new DeleteRequest().getFromJson(request)
        ).getAsJson();

    } // delete

    public String deleteByGuid(String request) {

        return new UserTokenObjectService().deleteByGuid(
                (DeleteByGuidRequest) new DeleteByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // deleteByGuid

} // UserTokenStringService

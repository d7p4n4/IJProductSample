package com.sycompla.stringService.user;

import com.sycompla.object.user.*;

public class UserStringService {

    public String getList(String request) {

        return new UserObjectService().getList(
                (GetListRequest) new GetListRequest().getFromJson(request)
        ).getAsJson();

    } // getList

    public String getById(String request) {

        return new UserObjectService().getById(
                (GetByIdRequest) new GetByIdRequest().getFromJson(request)
        ).getAsJson();

    } // getById

    public String getByGuid(String request) {

        return new UserObjectService().getByGuid(
                (GetByGuidRequest) new GetByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // getByGuid

    public String isExistsById(String request) {

        return new UserObjectService().isExistsById(
                (IsExistsByIdRequest) new IsExistsByIdRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsById

    public String isExistsByGuid(String request) {

        return new UserObjectService().isExistsByGuid(
                (IsExistsByGuidRequest) new IsExistsByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsByGuid

    public String insert(String request) {

        return new UserObjectService().insert(
                (InsertRequest) new InsertRequest().getFromJson(request)
        ).getAsJson();

    } // insert

    public String updateById(String request) {

        return new UserObjectService().updateById(
                (UpdateByIdRequest) new UpdateByIdRequest().getFromJson(request)
        ).getAsJson();

    } // updateById

    public String updateByGuid(String request) {

        return new UserObjectService().updateByGuid(
                (UpdateByGuidRequest) new UpdateByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // updateByGuid

    public String delete(String request) {

        return new UserObjectService().delete(
                (DeleteRequest) new DeleteRequest().getFromJson(request)
        ).getAsJson();

    } // delete

    public String deleteByGuid(String request) {

        return new UserObjectService().deleteByGuid(
                (DeleteByGuidRequest) new DeleteByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // deleteByGuid

} // UserStringService

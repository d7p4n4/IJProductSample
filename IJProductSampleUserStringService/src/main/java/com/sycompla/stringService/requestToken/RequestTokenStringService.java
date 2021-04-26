package com.sycompla.stringService.requestToken;

import com.sycompla.object.requestToken.*;

public class RequestTokenStringService {

    public String getList(String request) {

        return new RequestTokenObjectService().getList(
                (GetListRequest) new GetListRequest().getFromJson(request)
        ).getAsJson();

    } // getList

    public String getById(String request) {

        return new RequestTokenObjectService().getById(
                (GetByIdRequest) new GetByIdRequest().getFromJson(request)
        ).getAsJson();

    } // getById

    public String getByGuid(String request) {

        return new RequestTokenObjectService().getByGuid(
                (GetByGuidRequest) new GetByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // getByGuid

    public String isExistsById(String request) {

        return new RequestTokenObjectService().isExistsById(
                (IsExistsByIdRequest) new IsExistsByIdRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsById

    public String isExistsByGuid(String request) {

        return new RequestTokenObjectService().isExistsByGuid(
                (IsExistsByGuidRequest) new IsExistsByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // isExistsByGuid

    public String insert(String request) {

        return new RequestTokenObjectService().insert(
                (InsertRequest) new InsertRequest().getFromJson(request)
        ).getAsJson();

    } // insert

    public String updateById(String request) {

        return new RequestTokenObjectService().updateById(
                (UpdateByIdRequest) new UpdateByIdRequest().getFromJson(request)
        ).getAsJson();

    } // updateById

    public String updateByGuid(String request) {

        return new RequestTokenObjectService().updateByGuid(
                (UpdateByGuidRequest) new UpdateByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // updateByGuid

    public String delete(String request) {

        return new RequestTokenObjectService().delete(
                (DeleteRequest) new DeleteRequest().getFromJson(request)
        ).getAsJson();

    } // delete

    public String deleteByGuid(String request) {

        return new RequestTokenObjectService().deleteByGuid(
                (DeleteByGuidRequest) new DeleteByGuidRequest().getFromJson(request)
        ).getAsJson();

    } // deleteByGuid

} // RequestTokenStringService

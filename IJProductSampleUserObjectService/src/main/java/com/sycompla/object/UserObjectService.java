package com.sycompla.object;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.hibernate.UserHibernate;

public class UserObjectService {

    public GetByIdResponse getById(GetByIdRequest request) {

        GetByIdResponse response = new GetByIdResponse();

        try {

            response.setUser(new UserHibernate().getById(request.getId()));

            response.setResult(
                    new Ac4yProcessResult(
                            1
                            , "ok"
                            , null
                    )
            );

            return response;

        } catch (Exception exception) {

            response.setResult(
                    new Ac4yProcessResult(
                            -1
                            , exception.getMessage()
                            , null
                    )
            );

            return response;

        }

    } // getCategoryById

    public GetListResponse getList(GetListRequest request) {

        GetListResponse response = new GetListResponse();

        try {

            response.setUserList(new UserHibernate().getList());

            response.setResult(
                    new Ac4yProcessResult(
                            1
                            , "ok"
                            , null
                    )
            );

            return response;

        } catch (Exception exception) {

            response.setResult(
                    new Ac4yProcessResult(
                            -1
                            , exception.getMessage()
                            , null
                    )
            );

            return response;

        }

    } // getList

    public InsertResponse insert(InsertRequest request) {

        InsertResponse response = new InsertResponse();

        try {

            response.setUser(new UserHibernate().insert(request.getUser()));

            response.setResult(
                    new Ac4yProcessResult(
                            1
                            , "ok"
                            , null
                    )
            );

            return response;

        } catch (Exception exception) {

            response.setResult(
                    new Ac4yProcessResult(
                            -1
                            , exception.getMessage()
                            , null
                    )
            );

            return response;

        }

    } // insert

    public UpdateByIdResponse updateById(UpdateByIdRequest request) {

        UpdateByIdResponse response = new UpdateByIdResponse();

        try {

            response.setUser(new UserHibernate().updateById(request.getUser(), request.getId()));

            response.setResult(
                    new Ac4yProcessResult(
                            1
                            , "ok"
                            , null
                    )
            );

            return response;

        } catch (Exception exception) {

            response.setResult(
                    new Ac4yProcessResult(
                            -1
                            , exception.getMessage()
                            , null
                    )
            );

            return response;

        }

    } // updateById

    public DeleteResponse delete(DeleteRequest request) {

        DeleteResponse response = new DeleteResponse();

        try {

            new UserHibernate().delete(request.getId());

            response.setResult(
                    new Ac4yProcessResult(
                            1
                            , "ok"
                            , null
                    )
            );

            return response;

        } catch (Exception exception) {

            response.setResult(
                    new Ac4yProcessResult(
                            -1
                            , exception.getMessage()
                            , null
                    )
            );

            return response;

        }

    } // delete

} // UserObjectService

package com.sycompla.object.user;

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

    } // getById

    public GetByGuidResponse getByGuid(GetByGuidRequest request) {

        GetByGuidResponse response = new GetByGuidResponse();

        try {

            response.setUser(new UserHibernate().getByGuid(request.getGuid()));

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

    } // getByGuid

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

    public IsExistsByIdResponse isExistsById(IsExistsByIdRequest request) {

        IsExistsByIdResponse response = new IsExistsByIdResponse();

        try {

            response.setExists(new UserHibernate().isExistsById(request.getId()));

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

    } // IsExistsByIdResponse

    public IsExistsByGuidResponse isExistsByGuid(IsExistsByGuidRequest request) {

        IsExistsByGuidResponse response = new IsExistsByGuidResponse();

        try {

            response.setExists(new UserHibernate().isExistsByGuid(request.getGuid()));

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

    } // IsExistsByGuidResponse

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

    public UpdateByGuidResponse updateByGuid(UpdateByGuidRequest request) {

        UpdateByGuidResponse response = new UpdateByGuidResponse();

        try {

            response.setUser(new UserHibernate().updateByGuid(request.getUser(), request.getGuid()));

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

    } // updateByGuid

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

    public DeleteByGuidResponse deleteByGuid(DeleteByGuidRequest request) {

        DeleteByGuidResponse response = new DeleteByGuidResponse();

        try {

            new UserHibernate().deleteByGuid(request.getGuid());

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

    } // deleteByGuid

} // UserObjectService

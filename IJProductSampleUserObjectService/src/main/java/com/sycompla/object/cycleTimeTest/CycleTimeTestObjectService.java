package com.sycompla.object.cycleTimeTest;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.hibernate.CycleTimeTestHibernate;
import com.sycompla.hibernate.CycleTimeTestHibernate;

public class CycleTimeTestObjectService {

    public GetByIdResponse getById(GetByIdRequest request) {

        GetByIdResponse response = new GetByIdResponse();

        try {

            response.setCycleTimeTest(new CycleTimeTestHibernate().getById(request.getId()));

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

            response.setCycleTimeTest(new CycleTimeTestHibernate().getByGuid(request.getGuid()));

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

            response.setCycleTimeTestList(new CycleTimeTestHibernate().getList());

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

            if(new CycleTimeTestHibernate().isExistsById(request.getId())) {

                response.setResult(
                        new Ac4yProcessResult(
                                1
                                , "exists"
                                , null
                        )
                );

            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "not exists"
                                , null
                        )
                );

            }

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

            if(new CycleTimeTestHibernate().isExistsByGuid(request.getGuid())) {

                response.setResult(
                        new Ac4yProcessResult(
                                1
                                , "exists"
                                , null
                        )
                );

            } else {

                response.setResult(
                        new Ac4yProcessResult(
                                -1
                                , "not exists"
                                , null
                        )
                );

            }

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

            response.setCycleTimeTest(new CycleTimeTestHibernate().insert(request.getCycleTimeTest()));

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

            response.setCycleTimeTest(new CycleTimeTestHibernate().updateById(request.getCycleTimeTest(), request.getId()));

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

            response.setCycleTimeTest(new CycleTimeTestHibernate().updateByGuid(request.getCycleTimeTest(), request.getGuid()));

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

            new CycleTimeTestHibernate().delete(request.getId());

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

            new CycleTimeTestHibernate().deleteByGuid(request.getGuid());

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

} // UserTokenObjectService

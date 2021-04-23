package com.sycompla.objectService.category;

import ac4y.service.domain.Ac4yProcessResult;
import com.sycompla.hibernate.CategoryHibernateCap;

public class CategoryObjectServices {

    public GetCategoryByIdResponse getCategoryById(GetCategoryByIdRequest request) {

        GetCategoryByIdResponse response = new GetCategoryByIdResponse();

        try {

            response.setCategory(new CategoryHibernateCap().getOneRecord(request.getId()));

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

    public GetCategoryListResponse getCategoryList(GetCategoryListRequest request) {

        GetCategoryListResponse response = new GetCategoryListResponse();

        try {

            response.setCategoryList(new CategoryHibernateCap().getList());

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

    } // getCategoryList

    public GetCategoryListResponse getCategoryListStringRequest(String request) {

        GetCategoryListResponse response = new GetCategoryListResponse();

        try {

            response.setCategoryList(new CategoryHibernateCap().getList());

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

    } // getCategoryListStringRequest


}

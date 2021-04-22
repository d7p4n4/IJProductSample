package com.sycompla.test;


import com.sycompla.objectService.category.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOG = LogManager.getLogger(Run.class);

    public GetCategoryByIdResponse getCategoryById() {

        GetCategoryByIdResponse response = new CategoryObjectServices()
                .getCategoryById(new GetCategoryByIdRequest(
                        2
                ));

        return response;

    } // getCategoryById

    public GetCategoryListResponse getCategoryList() {

        GetCategoryListResponse response = new CategoryObjectServices()
                .getCategoryList(new GetCategoryListRequest());

        return  response;

    } // getCategoryList

    public static void main(String[] args) {

        //new Run().getCategoryById();
        new Run().getCategoryList();

    } // main

} // Run
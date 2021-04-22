package com.sycompla.test;


import com.sycompla.objectService.category.CategoryObjectServices;
import com.sycompla.objectService.category.GetCategoryByIdRequest;
import com.sycompla.objectService.category.GetCategoryByIdResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Run {

    private static final Logger LOG = LogManager.getLogger(Run.class);

    public GetCategoryByIdResponse getCategoryById() {

        GetCategoryByIdResponse response = new CategoryObjectServices()
                .getCategoryById(new GetCategoryByIdRequest(
                        2
                ));

        System.out.println(response);

        return response;

    } // getCategoryById

    public static void main(String[] args) {

        new Run().getCategoryById();

    } // main

} // Run
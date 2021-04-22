package com.sycompla.test;


import com.sycompla.category.CategoryStringServices;
import com.sycompla.objectService.category.*;

public class Run {

    //private static final Logger LOG = LogManager.getLogger(Run.class);

    public String getCategoryList() {


        return new CategoryStringServices()
                .getCategoryList("");


    } // getCategoryList
    public static void main(String[] args) {

        System.out.println(new Run().getCategoryList());

    } // main

} // Run
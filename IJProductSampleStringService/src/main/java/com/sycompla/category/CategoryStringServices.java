package com.sycompla.category;

import com.sycompla.objectService.category.CategoryObjectServices;
import com.sycompla.objectService.category.GetCategoryListRequest;

public class CategoryStringServices {

    public String getCategoryList(String request) {

        return new CategoryObjectServices().getCategoryList(
                (GetCategoryListRequest) new GetCategoryListRequest().getFromJson(request)
        ).getAsJson();

    } // getCategoryList

} // CategoryStringServices

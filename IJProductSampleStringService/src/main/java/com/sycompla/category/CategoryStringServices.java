package com.sycompla.category;

import com.sycompla.cap.CategoryHibernateCap;
import com.sycompla.gson.GsonCap;
import com.sycompla.objectService.category.GetCategoryByIdRequest;
import com.sycompla.objectService.category.GetCategoryByIdResponse;

public class CategoryStringServices {

    public String getCategoryById(GetCategoryByIdRequest request) {

        CategoryHibernateCap cap = new CategoryHibernateCap();

        GetCategoryByIdResponse response = new GetCategoryByIdResponse();

        response.setCategory(cap.getOneRecord(request.getId()));

        return new GsonCap().getObjectAsJson(response.getCategory());

    };

}

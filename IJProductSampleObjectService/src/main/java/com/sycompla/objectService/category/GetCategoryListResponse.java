package com.sycompla.objectService.category;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entities.Category;

import java.util.List;

public class GetCategoryListResponse extends Ac4yServiceResponse {

    public List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
} // GetCategoryListResponse

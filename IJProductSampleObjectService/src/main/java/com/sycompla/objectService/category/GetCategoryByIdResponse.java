package com.sycompla.objectService.category;

import ac4y.service.domain.Ac4yServiceResponse;
import com.sycompla.entities.Category;

public class GetCategoryByIdResponse extends Ac4yServiceResponse {

    public Category category;

    public String categoryString;

    public String getCategoryString() {
        return categoryString;
    }

    public void setCategoryString(String categoryString) {
        this.categoryString = categoryString;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

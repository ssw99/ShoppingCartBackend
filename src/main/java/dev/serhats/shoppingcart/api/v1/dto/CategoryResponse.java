package dev.serhats.shoppingcart.api.v1.dto;

import dev.serhats.shoppingcart.model.Category;
import lombok.Data;

@Data
public class CategoryResponse {
    private long id;
    private String name;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}

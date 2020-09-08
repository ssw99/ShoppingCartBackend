package dev.serhats.shoppingcart.api.v1.dto;

import dev.serhats.shoppingcart.model.Product;
import lombok.Data;

@Data
public class ProductResponse {
    private final long id;
    private String name;
    private double price;
    private int amount;
    private long categoryId;

    public ProductResponse(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.amount = product.getAmount();
        this.categoryId = product.getCategory().getId();
    }
}

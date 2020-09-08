package dev.serhats.shoppingcart.api.v1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductRequest {
    private String name;
    private double price;
    private int amount;
    private long categoryId;
}

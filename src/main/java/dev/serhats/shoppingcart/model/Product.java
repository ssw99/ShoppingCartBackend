package dev.serhats.shoppingcart.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseModel {
    @NotBlank(message = "Products must have a name!")
    @Column(nullable = false)
    private String name;

    @NotNull(message = "Price can't be null!")
    @Min(value = 0, message = "Price is not valid!")
    @Column(nullable = false)
    private double price;

    @NotNull(message = "Amount of the product can't be null!")
    @Min(value = 0,  message = "Price is not valid!")
    @Column(nullable = false)
    private int amount;

    @NotNull(message = "Category can't be null!")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    /**
     * Orders this product is in it
     */
    @ManyToMany(mappedBy = "products")
    private List<Order> orders;
    /**
     * Carts this product is in it
     */
    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;
}

package dev.serhats.shoppingcart.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orders;
    /**
     * Carts this product is in it
     */
    @OneToMany(mappedBy = "product")
    private List<CartProduct> carts;

    public Product(String name, double price, int amount, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.category = category;
    }
}

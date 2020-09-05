package dev.serhats.shoppingcart.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderProduct extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    @Min(value = 0, message = "Please enter valid quantity value!")
    private int quantity;

    public OrderProduct(Order order, CartProduct cartProduct) {
        this.order = order;
        this.product = cartProduct.getProduct();
        this.quantity = cartProduct.getQuantity();
    }
}

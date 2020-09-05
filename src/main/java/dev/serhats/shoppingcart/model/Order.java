package dev.serhats.shoppingcart.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "orders")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Order extends BaseModel {
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> products;

    public Order(User user) {
        this.user = user;
    }

}

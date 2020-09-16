package dev.serhats.shoppingcart.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

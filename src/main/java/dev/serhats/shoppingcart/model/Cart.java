package dev.serhats.shoppingcart.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseModel {
    @MapsId
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartProduct> products;
}

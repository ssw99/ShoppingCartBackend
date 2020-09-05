package dev.serhats.shoppingcart.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Cart extends BaseModel {
    @MapsId
    @OneToOne
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartProduct> products;
}

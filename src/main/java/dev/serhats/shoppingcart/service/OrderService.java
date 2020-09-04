package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.model.Cart;
import dev.serhats.shoppingcart.model.Order;
import dev.serhats.shoppingcart.model.repo.OrderRepo;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService extends BaseService<Order, OrderRepo> {
    @Transactional
    void order(Cart cart);
    @Transactional
    void order(long cartId);
}

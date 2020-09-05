package dev.serhats.shoppingcart.service.impl;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.model.Cart;
import dev.serhats.shoppingcart.model.Order;
import dev.serhats.shoppingcart.model.OrderProduct;
import dev.serhats.shoppingcart.model.User;
import dev.serhats.shoppingcart.model.repo.OrderProductRepo;
import dev.serhats.shoppingcart.model.repo.OrderRepo;
import dev.serhats.shoppingcart.service.CartService;
import dev.serhats.shoppingcart.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultOrderService implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderProductRepo orderProductRepo;
    private final CartService cartService;

    @Override
    public void order(Cart cart) throws EntityNotFoundException {
        User user = cart.getUser();
        Order order = Order.builder().user(user).build();
        save(order);

        cart.getProducts().forEach(cartProduct -> {
            OrderProduct orderProduct = OrderProduct.builder()
                    .order(order)
                    .product(cartProduct.getProduct())
                    .quantity(cartProduct.getQuantity())
                    .build();
            orderProductRepo.save(orderProduct);
        });
    }

    @Override
    public void order(long cartId) throws EntityNotFoundException {
        order(cartService.getById(cartId));
    }

    @Override
    public OrderRepo getRepo() {
        return orderRepo;
    }
}

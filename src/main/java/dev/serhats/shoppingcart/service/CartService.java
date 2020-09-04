package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.model.Cart;
import dev.serhats.shoppingcart.model.Product;
import dev.serhats.shoppingcart.model.repo.CartRepo;

import java.util.List;

public interface CartService extends BaseService<Cart, CartRepo> {
    List<Product> getProducts(long cartId);
    void addToCart(long cartId, Product product);
    void addToCart(long cartId, long productId);
    void removeOneFromCart(long cartId, Product product);
    void removeOneFromCart(long cartId,long productId);
    void removeAllFromCart(long cartId,Product product);
    void removeAllFromCart(long cartId,long productId);
    void clearCart(long cartId);
}

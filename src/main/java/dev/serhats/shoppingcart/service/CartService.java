package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.exception.NotEnoughAmountOfProductException;
import dev.serhats.shoppingcart.model.Cart;
import dev.serhats.shoppingcart.model.Product;
import dev.serhats.shoppingcart.model.repo.CartRepo;

import java.util.List;

public interface CartService extends BaseService<Cart, CartRepo> {
    List<Product> getProducts(long cartId) throws EntityNotFoundException;
    void addToCart(long cartId, Product product) throws EntityNotFoundException, NotEnoughAmountOfProductException;
    void addToCart(long cartId, long productId) throws EntityNotFoundException, NotEnoughAmountOfProductException;
    void removeOneFromCart(long cartId, Product product) throws EntityNotFoundException;
    void removeOneFromCart(long cartId,long productId) throws EntityNotFoundException;
    void removeAllFromCart(long cartId,Product product) throws EntityNotFoundException;
    void removeAllFromCart(long cartId,long productId) throws EntityNotFoundException;
    void clearCart(long cartId) throws EntityNotFoundException;
}

package dev.serhats.shoppingcart.service.impl;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.exception.NotEnoughAmountOfProductException;
import dev.serhats.shoppingcart.model.Cart;
import dev.serhats.shoppingcart.model.CartProduct;
import dev.serhats.shoppingcart.model.Product;
import dev.serhats.shoppingcart.model.repo.CartProductRepo;
import dev.serhats.shoppingcart.model.repo.CartRepo;
import dev.serhats.shoppingcart.service.CartService;
import dev.serhats.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DefaultCartService implements CartService {
    private final CartRepo cartRepo;
    private final CartProductRepo cartProductRepo;
    private final ProductService productService;

    @Override
    public List<Product> getProducts(long cartId) throws EntityNotFoundException {
        Cart cart = getById(cartId);
        return cart.getProducts().stream().map(CartProduct::getProduct).collect(Collectors.toList());
    }

    @Override
    public void addToCart(long cartId, Product product) throws EntityNotFoundException, NotEnoughAmountOfProductException {
        addToCart(cartId, product.getId());
    }

    @Override
    public void addToCart(long cartId, long productId) throws EntityNotFoundException, NotEnoughAmountOfProductException {
        Cart cart = getById(cartId);
        productService.decreaseAmountByOne(productId);

        Optional<CartProduct> cartProductOptional = getCartProduct(cart, productId);
        if (cartProductOptional.isPresent()) {
            cartProductOptional.get().setQuantity(cartProductOptional.get().getQuantity() + 1);
        } else {
            CartProduct cartProduct = CartProduct.builder()
                    .product(productService.getById(productId))
                    .cart(cart)
                    .quantity(1)
                    .build();
        }
    }

    @Override
    public void removeOneFromCart(long cartId, Product product) throws EntityNotFoundException {
        removeOneFromCart(cartId, product.getId());
    }

    @Override
    public void removeOneFromCart(long cartId, long productId) throws EntityNotFoundException {
        Cart cart = getById(cartId);
        getCartProduct(cart, productId).ifPresent(cartProduct -> {
            if (cartProduct.getQuantity() > 1) {
                cartProduct.setQuantity(cartProduct.getQuantity() - 1);
            }else {
                cartProductRepo.delete(cartProduct);
            }
        });
    }

    @Override
    public void removeAllFromCart(long cartId, Product product) throws EntityNotFoundException {
        removeAllFromCart(cartId, product.getId());
    }

    @Override
    public void removeAllFromCart(long cartId, long productId) throws EntityNotFoundException {
        Cart cart = getById(cartId);
        getCartProduct(cart, productId).ifPresent(cartProductRepo::delete);

    }

    @Override
    public void clearCart(long cartId) throws EntityNotFoundException {
        Cart cart = getById(cartId);
        cart.getProducts().forEach(cartProductRepo::delete);
    }

    @Override
    public CartRepo getRepo() {
        return cartRepo;
    }

    private Optional<CartProduct> getCartProduct(Cart cart, long productId) {
        return cart.getProducts().stream().filter(cartProduct ->
            cartProduct.getProduct().getId() == productId
        ).findFirst();
    }
}

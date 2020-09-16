package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.exception.NotEnoughAmountOfProductException;
import dev.serhats.shoppingcart.model.Product;
import dev.serhats.shoppingcart.model.repo.ProductRepo;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService extends BaseService<Product, ProductRepo> {
    @Transactional
    Product updateAmount(long productId, int amount) throws EntityNotFoundException;

    @Transactional
    Product updatePrice(long productId, double price) throws EntityNotFoundException;

    @Transactional
    Product decreaseAmountByOne(long productId) throws EntityNotFoundException, NotEnoughAmountOfProductException;
}

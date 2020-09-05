package dev.serhats.shoppingcart.service.impl;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.exception.NotEnoughAmountOfProductException;
import dev.serhats.shoppingcart.model.Product;
import dev.serhats.shoppingcart.model.repo.ProductRepo;
import dev.serhats.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public Product updateAmount(long productId, int amount) throws EntityNotFoundException {
        Product product = getById(productId);
        product.setAmount(amount);
        return save(product);
    }

    @Override
    public Product updatePrice(long productId, double price) throws EntityNotFoundException {
        Product product = getById(productId);
        product.setPrice(price);
        return save(product);
    }

    @Override
    public Product decreaseAmountByOne(long productId) throws EntityNotFoundException, NotEnoughAmountOfProductException {
        Product product = getById(productId);
        if (product.getAmount() < 0) throw new NotEnoughAmountOfProductException();
        return null;
    }

    @Override
    public ProductRepo getRepo() {
        return productRepo;
    }
}

package dev.serhats.shoppingcart.service;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.model.Category;
import dev.serhats.shoppingcart.model.repo.CategoryRepo;


public interface CategoryService extends BaseService<Category, CategoryRepo> {
    Category updateName(long categoryId, String name) throws EntityNotFoundException;
}

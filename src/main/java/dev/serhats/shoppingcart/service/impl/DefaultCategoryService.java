package dev.serhats.shoppingcart.service.impl;

import dev.serhats.shoppingcart.exception.EntityNotFoundException;
import dev.serhats.shoppingcart.model.Category;
import dev.serhats.shoppingcart.model.repo.CategoryRepo;
import dev.serhats.shoppingcart.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCategoryService implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public Category updateName(long categoryId, String name) throws EntityNotFoundException {
        Category category = getById(categoryId);
        category.setName(name);
        return save(category);
    }

    @Override
    public CategoryRepo getRepo() {
        return categoryRepo;
    }
}

package dev.serhats.shoppingcart.api.v1.controller;

import dev.serhats.shoppingcart.api.v1.dto.CategoryRequest;
import dev.serhats.shoppingcart.api.v1.dto.CategoryResponse;
import dev.serhats.shoppingcart.model.Category;
import dev.serhats.shoppingcart.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;


    @GetMapping("{id}")
    public CategoryResponse get(@PathVariable long id) {
        return new CategoryResponse(categoryService.getById(id));
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll().stream().map(CategoryResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryRequest categoryRequest,
                                    HttpServletRequest request) {
        Category category = new Category(categoryRequest.getName());
        category = categoryService.save(category);

        URI location = URI.create(request.getRequestURL() + "/" + category.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}

package dev.serhats.shoppingcart.api.v1.controller;

import dev.serhats.shoppingcart.api.v1.dto.CategoryRequest;
import dev.serhats.shoppingcart.api.v1.dto.CategoryResponse;
import dev.serhats.shoppingcart.model.Category;
import dev.serhats.shoppingcart.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> getAll() {
        return categoryService.getAll().stream().map(CategoryResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse create(@RequestBody CategoryRequest categoryRequest,
                                   HttpServletRequest request,
                                   HttpServletResponse response) {
        Category category = new Category(categoryRequest.getName());
        category = categoryService.save(category);
        response.setHeader("Location", request.getRequestURL() + "" + category.getId());
        return new CategoryResponse(category);
    }

    @GetMapping("{id}")
    public CategoryResponse get(@PathVariable long id) {
        return new CategoryResponse(categoryService.getById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CategoryResponse> delete(@PathVariable long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}

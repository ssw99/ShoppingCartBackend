package dev.serhats.shoppingcart.api.v1.controller;

import dev.serhats.shoppingcart.api.v1.dto.ProductRequest;
import dev.serhats.shoppingcart.api.v1.dto.ProductResponse;
import dev.serhats.shoppingcart.model.Category;
import dev.serhats.shoppingcart.model.Product;
import dev.serhats.shoppingcart.service.CategoryService;
import dev.serhats.shoppingcart.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    private final CategoryService categoryService;


    @GetMapping("{id}")
    public ProductResponse get(@PathVariable long id) {
        return new ProductResponse(productService.getById(id));
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return productService.getAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ProductRequest productRequest,
                                    HttpServletRequest request) {
        Category category = categoryService.getById(productRequest.getCategoryId());
        Product product = productService.save(new Product(
                productRequest.getName(),
                productRequest.getPrice(),
                productRequest.getAmount(),
                category));

        URI location = URI.create(request.getRequestURL() + "/" + product.getId());
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        productService.delete(id);
        return ResponseEntity.ok().build();
    }
}

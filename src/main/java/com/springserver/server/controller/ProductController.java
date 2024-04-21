package com.springserver.server.controller;

import com.springserver.server.dto.ProductDTO;
import com.springserver.server.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{category_name}/products")
    public List<ProductDTO> getProductsByCategory(@PathVariable("category_name") String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

}

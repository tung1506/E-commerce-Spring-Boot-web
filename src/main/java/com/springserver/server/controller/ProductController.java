package com.springserver.server.controller;

import com.springserver.server.dto.ProductDTO;
import com.springserver.server.service.product.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{category_name}/products")
    /*
    Trả về danh sách sản phẩm theo tên danh mục, bao gồm:
    - Tên sản phẩm
    - Giá gốc
    - Giá khuyến mãi
    - Danh sách hình ảnh sản phẩm (mỗi sản phẩm có thể có nhiều hình ảnh)
     */
    public List<ProductDTO> getProductsByCategory(@PathVariable("category_name") String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

}

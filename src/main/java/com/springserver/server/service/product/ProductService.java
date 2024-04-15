package com.springserver.server.service.product;

import com.springserver.server.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getProductsByCategory(String categoryName);
}
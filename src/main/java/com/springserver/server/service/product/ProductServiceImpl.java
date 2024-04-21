package com.springserver.server.service.product;

import com.springserver.server.domain.ProductItem;
import com.springserver.server.dto.ProductDTO;
import com.springserver.server.repository.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ProductDTO> getProductsByCategory(String categoryName) {
        return productRepository.findByProductCategory_CategoryName(categoryName).stream()
                .map(product -> {
                    ProductDTO productDTO = new ProductDTO();
                    productDTO.setProductName(product.getProductName());
                    productDTO.setDescription(product.getProductDescription());

                    product.getProductItems().stream()
                            .findFirst()
                            .flatMap(productItem -> productItem.getProductImages().stream().findFirst())
                            .ifPresent(productImage -> productDTO.setImageFilename(productImage.getImageFilename()));

                    productDTO.setMinOriginalPrice(findMinPrice(product.getProductItems(), ProductItem::getOriginalPrice));
                    productDTO.setMaxOriginalPrice(findMaxPrice(product.getProductItems(), ProductItem::getOriginalPrice));

                    // Get the lowest and highest sale price of product items
                    productDTO.setMinSalePrice(findMinPrice(product.getProductItems(), ProductItem::getSalePrice));
                    productDTO.setMaxSalePrice(findMaxPrice(product.getProductItems(), ProductItem::getSalePrice));

                    return productDTO;
                })
                .collect(Collectors.toList());
    }

    private Integer findMinPrice(@org.jetbrains.annotations.NotNull List<ProductItem> productItems, Function<ProductItem, Integer> priceExtractor) {
        return productItems.stream()
                .map(priceExtractor)
                .min(Integer::compareTo)
                .orElse(null);
    }

    private Integer findMaxPrice(@NotNull List<ProductItem> productItems, Function<ProductItem, Integer> priceExtractor) {
        return productItems.stream()
                .map(priceExtractor)
                .max(Integer::compareTo)
                .orElse(null);
    }
}
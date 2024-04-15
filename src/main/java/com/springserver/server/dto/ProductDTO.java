package com.springserver.server.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String productName;
    private String description;
    private String imageFilename;
    private Integer minOriginalPrice;
    private Integer maxOriginalPrice;
    private Integer minSalePrice;
    private Integer maxSalePrice;
}

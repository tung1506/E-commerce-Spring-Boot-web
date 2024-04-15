package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_item")
public class ProductItem {
    @Id
    @Column(name = "product_item_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "colour_id", nullable = false)
    private Integer colourId;

    @Column(name = "original_price", nullable = false)
    private Integer originalPrice;

    @Column(name = "sale_price", nullable = false)
    private Integer salePrice;

    @Column(name = "product_code", nullable = false)
    private String productCode;

    @OneToMany(mappedBy = "productItem", orphanRemoval = true)
    private List<ProductVariation> productVariations = new ArrayList<>();

    @OneToMany(mappedBy = "productItem", orphanRemoval = true)
    private List<ProductImage> productImages = new ArrayList<>();

}
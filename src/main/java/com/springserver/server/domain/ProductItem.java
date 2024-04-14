package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_item")
public class ProductItem {
    @Id
    @Column(name = "product_item_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "colour_id", nullable = false)
    private Colour colour;

    @Column(name = "original_price", nullable = false)
    private Integer originalPrice;

    @Column(name = "sale_price", nullable = false)
    private Integer salePrice;

    @Column(name = "product_code", nullable = false)
    private String productCode;

}
package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_variation")
public class ProductVariation {
    @Id
    @Column(name = "variation_id", nullable = false)
    private Integer id;


    @Column(name = "qty_in_stock", nullable = false)
    private Integer qtyInStock;

    @ManyToOne
    @JoinColumn(name = "product_item_id")
    private ProductItem productItem;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private SizeOption sizeOption;

}
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_item_id", nullable = false)
    private ProductItem productItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "size_id", nullable = false)
    private SizeOption size;

    @Column(name = "qty_in_stock", nullable = false)
    private Integer qtyInStock;

}
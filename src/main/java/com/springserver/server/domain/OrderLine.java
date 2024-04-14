package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_line")
public class OrderLine {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_item_id", nullable = false)
    private ProductItem productItem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private ShopOrder order;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @Column(name = "price", nullable = false)
    private Integer price;

}
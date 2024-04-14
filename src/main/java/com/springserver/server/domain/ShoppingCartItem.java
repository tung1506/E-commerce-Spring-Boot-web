package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private UserShoppingCart userShoppingCart;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_item_id", nullable = false)
    private ProductItem productItem;

    @Column(name = "qty", nullable = false)
    private Integer qty;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private UserShoppingCart shoppingCart;

}
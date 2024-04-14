package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "shop_order")
public class ShopOrder {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_method", nullable = false)
    private PaymentMethod paymentMethod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipping_address", nullable = false)
    private Address shippingAddress;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shipping_method", nullable = false)
    private ShippingMethod shippingMethod;

    @Column(name = "order_total", nullable = false)
    private Integer orderTotal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

}
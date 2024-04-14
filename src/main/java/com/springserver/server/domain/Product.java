package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_category_id", nullable = false)
    private ProductCategory productCategory;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Lob
    @Column(name = "product_description", nullable = false)
    private String productDescription;

}
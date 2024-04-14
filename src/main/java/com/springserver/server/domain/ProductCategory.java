package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @Column(name = "product_category_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_gender_id", nullable = false)
    private ProductGender productGender;

    @Column(name = "category_name", nullable = false, length = 100)
    private String categoryName;

    @Lob
    @Column(name = "category_image", nullable = false)
    private String categoryImage;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

}
package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product_gender")
public class ProductGender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_gender_id", nullable = false)
    private Integer id;

    @Column(name = "gender_name", nullable = false, length = 100)
    private String genderName;

    @OneToMany(mappedBy = "productGender" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductCategory> productCategories = new ArrayList<>();

}
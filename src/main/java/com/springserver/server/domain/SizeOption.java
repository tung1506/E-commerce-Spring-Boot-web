package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "size_option")
public class SizeOption {
    @Id
    @Column(name = "size_id", nullable = false)
    private Integer id;

    @Column(name = "size_name", nullable = false, length = 100)
    private String sizeName;

    @Column(name = "sort_order", nullable = false)
    private Integer sortOrder;

    @OneToMany(mappedBy = "sizeOption", orphanRemoval = true)
    private List<ProductVariation> productVariations = new ArrayList<>();

}
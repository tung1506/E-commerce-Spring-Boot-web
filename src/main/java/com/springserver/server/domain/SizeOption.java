package com.springserver.server.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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

}
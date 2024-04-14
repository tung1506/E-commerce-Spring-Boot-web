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
@Table(name = "product_gender")
public class ProductGender {
    @Id
    @Column(name = "product_gender_id", nullable = false)
    private Integer id;

    @Column(name = "gender_name", nullable = false, length = 100)
    private String genderName;

}
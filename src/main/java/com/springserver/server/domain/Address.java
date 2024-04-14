package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "unit_numer", nullable = false)
    private String unitNumer;

    @Column(name = "street_number", nullable = false)
    private String streetNumber;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2", nullable = false)
    private String addressLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "region", nullable = false)
    private String region;

    @Column(name = "postal_code", nullable = false, length = 100)
    private String postalCode;

}
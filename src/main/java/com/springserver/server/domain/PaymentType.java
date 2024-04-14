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
@Table(name = "payment_type")
public class PaymentType {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "payment_name", nullable = false)
    private String paymentName;

}
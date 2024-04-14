package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "payment_type", nullable = false)
    private PaymentType paymentType;

    @Column(name = "provider", nullable = false)
    private String provider;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "expired_date", nullable = false)
    private LocalDate expiredDate;

    @Column(name = "is_default", nullable = false)
    private Boolean isDefault = false;

}
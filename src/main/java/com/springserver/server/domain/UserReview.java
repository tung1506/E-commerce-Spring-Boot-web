package com.springserver.server.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user_review")
public class UserReview {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private SiteUser user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ordered_product", nullable = false, referencedColumnName = "product_item_id")
    private OrderLine orderedProduct;

    @Column(name = "rating_value", nullable = false)
    private Integer ratingValue;

    @Lob
    @Column(name = "comment", nullable = false)
    private String comment;

}
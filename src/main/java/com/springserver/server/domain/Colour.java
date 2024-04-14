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
@Table(name = "colour")
public class Colour {
    @Id
    @Column(name = "colour_id", nullable = false)
    private Integer id;

    @Column(name = "colour_name", nullable = false, length = 100)
    private String colourName;

}
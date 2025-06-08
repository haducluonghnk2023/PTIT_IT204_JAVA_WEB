package com.data.session20.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "seed")
@Getter
@Setter
public class Seed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seedName;
    private String description;
    private Double price;
    private int stock;
    private String image;
}

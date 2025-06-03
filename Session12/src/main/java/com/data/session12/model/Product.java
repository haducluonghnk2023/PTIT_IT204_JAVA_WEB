package com.data.session12.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private Double price;
    private Integer quantity;
    private String image;
}

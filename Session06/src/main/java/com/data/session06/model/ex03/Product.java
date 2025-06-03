package com.data.session06.model.ex03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    private String name;
    private double price;
    private String imageUrl;
}

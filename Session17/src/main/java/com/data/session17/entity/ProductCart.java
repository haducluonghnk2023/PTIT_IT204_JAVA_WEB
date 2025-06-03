package com.data.session17.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product_cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long productId;
    private int quantity;
    @Transient
    private Product product;

}

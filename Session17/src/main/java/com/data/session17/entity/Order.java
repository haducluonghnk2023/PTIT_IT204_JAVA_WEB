package com.data.session17.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Data
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    @OneToMany
    private List<ProductCart> listProduct;
    private String recipientName;
    private String phoneNumber;
    private String address;
    private double totalMoney;
    private String status;
}

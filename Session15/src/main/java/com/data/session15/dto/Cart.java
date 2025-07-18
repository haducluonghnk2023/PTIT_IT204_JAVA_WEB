package com.data.session15.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {
    private int idCart;
    private int idUser;
    private int idProduct;
    private int quantity;
}

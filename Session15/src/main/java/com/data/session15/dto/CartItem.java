package com.data.session15.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private Product06 product;
    private int quantity;

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

package com.data.session06.model.ex03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCart {
    private int id;
    private int userId;
    private int productId;
    private int quantity;
}

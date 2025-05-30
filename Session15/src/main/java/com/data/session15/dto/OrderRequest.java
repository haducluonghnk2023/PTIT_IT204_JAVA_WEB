package com.data.session15.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private int userId;
    private String recipientName;
    private String address;
    private String phoneNumber;

    private int productId;
    private int quantity;
    private BigDecimal currentPrice;
}

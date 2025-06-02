package com.data.session16.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Trip {
    private int id;
    private String departure;     // Nơi đi
    private String destination;   // Nơi đến
    private String departureTime; // Giờ khởi hành
    private double price;
}

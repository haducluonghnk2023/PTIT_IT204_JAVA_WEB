package com.data.session12.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seat {
    private Integer id;
    private Integer busId;
    private String seatName;
    private boolean status;
    private Double price;
}

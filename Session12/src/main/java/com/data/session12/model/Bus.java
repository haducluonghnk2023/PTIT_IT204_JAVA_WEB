package com.data.session12.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bus {
    private Integer id;
    private String licensePlate;
    private String busType;
    private Integer rowSeat;
    private Integer colSeat;
    private Integer totalSeat;
    private String image;
}

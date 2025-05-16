package com.data.session09.model.ex04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seat {
    private Long id;
    private Long screenRoomId;
    private Double price = 50000.0;
    private String status;
    private String seatNumber;
}

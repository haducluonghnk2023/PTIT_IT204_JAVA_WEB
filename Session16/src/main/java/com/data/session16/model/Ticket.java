package com.data.session16.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private int id;
    private int userId;
    private int tripId;
    private String seatList;
    private double totalMoney;
    private String departureDate;
}

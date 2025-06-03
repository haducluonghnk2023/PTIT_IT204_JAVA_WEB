package com.data.session10.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private String movieTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date showTime;
    private List<Seat> seats;
    private double totalAmount;
}

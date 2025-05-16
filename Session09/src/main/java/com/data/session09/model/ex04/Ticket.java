package com.data.session09.model.ex04;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private Long id;
    private Long customerId;
    private Long scheduleId;
    private List<Seat> listSeat;
    private Double totalMoney;
    private Date created_at;
}

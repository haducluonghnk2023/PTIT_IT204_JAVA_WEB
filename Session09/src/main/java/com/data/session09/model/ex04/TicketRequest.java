package com.data.session09.model.ex04;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class TicketRequest {
    private Long customerId;
    private Long scheduleId;
    private List<Long> seatIds;
}

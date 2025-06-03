package com.data.session09.model.ex03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {
    private Long id;
    private String movieTitle;
    private Date showTime;
    private Long screenRoomId;
    private Integer availableSeats;
    private String format;
}

package com.data.session09.model.ex03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScreenRoom {
    private Long id;
    private String screenRoomName;
    private Integer totalSeat;
}

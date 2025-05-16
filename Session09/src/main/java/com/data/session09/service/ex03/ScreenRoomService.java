package com.data.session09.service.ex03;

import com.data.session09.model.ex03.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    List<ScreenRoom> findAll();
    ScreenRoom findById(Long id);
}

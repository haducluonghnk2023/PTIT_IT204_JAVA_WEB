package com.data.session09.repository.ex03;

import com.data.session09.model.ex03.ScreenRoom;

import java.util.List;

public interface ScreenRoomRepo {
    List<ScreenRoom> findAll();
    ScreenRoom findById(Long id);
}

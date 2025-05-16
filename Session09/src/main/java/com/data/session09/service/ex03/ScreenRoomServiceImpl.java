package com.data.session09.service.ex03;

import com.data.session09.model.ex03.ScreenRoom;
import com.data.session09.repository.ex03.ScreenRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScreenRoomServiceImpl implements  ScreenRoomService {

    @Autowired
    private ScreenRoomRepo screenRoomRepo;
    @Override
    public List<ScreenRoom> findAll() {
        return screenRoomRepo.findAll();
    }

    @Override
    public ScreenRoom findById(Long id) {
        return screenRoomRepo.findById(id);
    }
}

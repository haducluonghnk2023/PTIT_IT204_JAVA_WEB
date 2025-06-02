package com.data.session16.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Bus {
    private int id;
    private String licensePlate;
    private BusType busType;
    private int rowSeats;
    private int columnSeats;
    private int totalSeats;
    private String imageUrl;
    private MultipartFile image;
}

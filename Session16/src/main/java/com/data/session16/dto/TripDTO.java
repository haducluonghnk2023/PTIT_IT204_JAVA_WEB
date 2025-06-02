package com.data.session16.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class TripDTO {
    @NotBlank(message = "Nơi đi không được để trống")
    private String departure;     // Nơi đi
    @NotBlank(message = "Nơi đến không được để trống")
    private String destination;   // Nơi đến
    @NotBlank(message = "Giờ khởi hành không được để trống")
    private String departureTime; // Giờ khởi hành
}

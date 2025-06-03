package com.data.session16.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Getter
@Setter
public class BusTrip {
    private int id;

    @NotBlank(message = "Điểm đi không được để trống")
    private String departurePoint;

    @NotBlank(message = "Điểm đến không được để trống")
    private String destination;

    @NotBlank(message = "Thời gian khởi hành không được để trống")
    private String departureTime;

    @NotBlank(message = "Thời gian đến không được để trống")
    private String arrivalTime;

    @NotNull(message = "Xe không được để trống")
    private Integer busId;

    @Min(value = 1, message = "Số ghế phải lớn hơn 0")
    private int seatsAvailable;

    private String image;

    private MultipartFile imageFile;
}

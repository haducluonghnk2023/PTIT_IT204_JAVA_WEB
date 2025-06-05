package com.data.session19.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "theaters")
@Getter
@Setter
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên rạp không được để trống")
    private String theaterName;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @Min(value = 1, message = "Số lượng phòng chiếu phải lớn hơn 0")
    private Integer numberScreenRoom;

    private boolean status;
}
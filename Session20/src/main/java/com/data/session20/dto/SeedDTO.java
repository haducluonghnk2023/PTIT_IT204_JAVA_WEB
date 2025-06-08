package com.data.session20.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;

@Getter
@Setter
public class SeedDTO {

    @NotBlank(message = "Tên hạt giống không được để trống")
    private String seedName;

    private MultipartFile file;

    @NotBlank(message = "Mô tả không được để trống")
    private String description;

    @Min(value = 1000, message = "Giá phải lớn hơn hoặc bằng 1000 VNĐ")
    private double price;

    @Min(value = 0, message = "Tồn kho phải >= 0")
    private int stock;
}

package com.data.session15.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resume {
    private Long id;

    @NotBlank(message = "Tên đầy đủ không được để trống")
    @Size(min = 2, max = 100, message = "Tên phải từ 2-100 ký tự")
    private String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^[0-9]{10,11}$", message = "Số điện thoại phải có 10-11 chữ số")
    private String phoneNumber;

    @Size(max = 500, message = "Trình độ học vấn không vượt quá 500 ký tự")
    private String education;

    @Size(max = 1000, message = "Kinh nghiệm làm việc không vượt quá 1000 ký tự")
    private String experience;

    @Size(max = 500, message = "Kỹ năng không vượt quá 500 ký tự")
    private String skills;
}

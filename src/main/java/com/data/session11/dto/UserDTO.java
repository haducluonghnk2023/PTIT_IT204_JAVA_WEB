package com.data.session11.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải có độ dài từ 2 đến 30 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;

    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;

    private boolean status;
}

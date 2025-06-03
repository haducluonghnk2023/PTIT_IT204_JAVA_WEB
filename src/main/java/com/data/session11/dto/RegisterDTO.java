package com.data.session11.dto;

import com.data.session11.validation.ValidEmail;
import com.data.session11.validation.ValidPassword;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class RegisterDTO {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @ValidEmail
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @ValidPassword
    private String password;
}

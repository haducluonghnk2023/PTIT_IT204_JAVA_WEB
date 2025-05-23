package com.data.session11.dto;

import com.data.session11.validation.ValidPhoneNumber;
import com.data.session11.validation.groups.AdminGroup;
import com.data.session11.validation.groups.UserGroup;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class UserRegistrationDto {
    @NotBlank(message = "Tên không được để trống")
    private String name;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    private String email;

    @NotNull(message = "Vai trò không được để trống")
    private String role;

    // Trường riêng cho Admin
    @NotBlank(message = "Mã quản trị là bắt buộc", groups = AdminGroup.class)
    private String adminCode;

    // Trường riêng cho User
    @Min(value = 13, message = "Người dùng phải từ 13 tuổi", groups = UserGroup.class)
    private Integer age;

    @NotBlank(message = "Số điện thoại không được để trống")
    @ValidPhoneNumber
    private String phoneNumber;

}

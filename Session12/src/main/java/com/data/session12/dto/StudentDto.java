package com.data.session12.dto;

import com.data.session12.model.Status;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Data
public class StudentDto {
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String phone;
    @NotBlank
    private boolean sex;
    @NotBlank
    private Date birthday;
    @NotBlank
    private String avatar;
    @NotBlank
    private Status status;
}

package com.data.session12.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private boolean sex;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date birthday;
    private String avatar;
    private Status status;
    private transient MultipartFile avatarFile;
}



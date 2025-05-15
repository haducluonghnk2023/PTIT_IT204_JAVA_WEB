package com.data.session08.model.ex05;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User05 {
    private String name;
    private int age;
    private Date birthday;
    private String email;
    private String phone;
}

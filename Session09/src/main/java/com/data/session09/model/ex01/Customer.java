package com.data.session09.model.ex01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Customer {
    private Long id;
    private String userName;
    private String phone;
    private String address;
    private String gender;
    private String email;
    private String password;
}

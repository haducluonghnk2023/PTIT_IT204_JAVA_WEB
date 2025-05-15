package com.data.session08.model.ex08;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User08 {
    private int id;
    private String username;
    private String password;
    private String email;
    private double balance = 10000;
}

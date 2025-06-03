package com.data.session08.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Customer {
    private int id;
    private String name;
    private String email;
    private Gender gender;
    private CustomerType customerType;
}

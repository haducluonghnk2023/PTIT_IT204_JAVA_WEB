package com.data.session05.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contact {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}

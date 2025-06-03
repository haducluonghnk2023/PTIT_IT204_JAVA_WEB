package com.data.session11.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private int id;

    private String title;

    private String email;

    private int quantity;

    private Date birthday;

    private Date eventDate;
}

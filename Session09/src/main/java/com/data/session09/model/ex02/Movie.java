package com.data.session09.model.ex02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    private Long id;
    private String title;
    private String director;
    private String genre;
    private String description;
    private Integer duration;
    private String language;
}

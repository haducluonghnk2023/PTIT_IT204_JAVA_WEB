package com.data.session11.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MoviesDTO {
    private Integer id;

    @NotBlank
    @Size(max = 100)
    private String title;

    @NotBlank
    @Size(max = 50)
    private String director;

    private Date release_date;

    @NotBlank
    @Size(max = 30)
    private String genre;

    private String poster;
}

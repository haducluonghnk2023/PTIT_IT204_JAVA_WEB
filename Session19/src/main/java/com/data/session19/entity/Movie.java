package com.data.session19.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên phim không được để trống")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    private String director;

    @NotNull(message = "Năm phát hành không được để trống")
    @Min(value = 1888, message = "Năm phát hành không hợp lệ")
    private Integer releaseYear;

    private String genre;

    @NotNull(message = "Thời lượng không được để trống")
    @Min(value = 1, message = "Thời lượng phim phải lớn hơn 0")
    private Integer duration;

    private String language;

    @NotBlank(message = "URL ảnh áp phích không được để trống")
    @Pattern(
            regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$",
            message = "URL ảnh áp phích không hợp lệ"
    )
    private String poster;

    private boolean status;
}

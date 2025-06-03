package com.data.session10.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int id;
    private String title;
    private String isbn;
    private double price;
    private MultipartFile fileImage;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;
}

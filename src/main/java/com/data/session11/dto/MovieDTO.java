package com.data.session11.dto;

import com.data.session11.validation.CheckMovieExistByTitle;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovieDTO {
    private int id;

    @NotBlank(message = "Title không được để trống!")
    @CheckMovieExistByTitle
    private String title;

    @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$",
            message = "Email không hợp lệ!")
    private String email;

    @Min(value = 1, message = "Số lượng: 1 - 20!")
    @Max(value = 20, message = "Số lượng: 1 - 20!")
    private int quantity;

    @Past(message = "Ngày sinh phải ngày quá khứ!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @Future(message = "Sự kiện tới phải là ngày tương lai!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
}

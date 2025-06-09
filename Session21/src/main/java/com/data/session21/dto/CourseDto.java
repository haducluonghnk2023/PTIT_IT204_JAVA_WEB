package com.data.session21.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
@Getter
@Setter
public class CourseDto {
    private Integer id;

    @NotBlank(message = "Tên khóa học không được để trống")
    @Size(max = 100, message = "Tên khóa học không được vượt quá 100 ký tự")
    private String name;

    @NotBlank(message = "Mô tả khóa học không được để trống")
    private String description;

    private List<Integer> studentIds;
}

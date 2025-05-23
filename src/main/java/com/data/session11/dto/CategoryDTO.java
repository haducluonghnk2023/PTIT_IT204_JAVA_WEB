package com.data.session11.dto;

import com.data.session11.validation.UniqueCategoryName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Data
public class CategoryDTO {
    private Integer id;

    @NotBlank(message = "Tên danh mục không được để trống")
    @Size(max = 50, message = "Tên danh mục tối đa 50 ký tự")
    @UniqueCategoryName
    private String categoryName;

    private Boolean status = true;
}

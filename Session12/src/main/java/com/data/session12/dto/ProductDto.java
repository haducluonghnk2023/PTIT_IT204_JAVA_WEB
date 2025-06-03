package com.data.session12.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private Double price;
    @NotBlank
    private Integer quantity;
    @NotBlank
    private String image;
}

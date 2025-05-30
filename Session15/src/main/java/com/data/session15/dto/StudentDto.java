package com.data.session15.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDto {
    private String studentId;
    private String studentName;
    private int studentAge;
    private String studentClass;
    private String studentEmail;
    private String studentAddress;
    private String studentPhone;
}

package com.data.session21.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
@Getter
@Setter
public class StudentDto {
    private Integer id;
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 100, message = "Tên phải có độ dài từ 2 đến 100 ký tự")
    private String name;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "\\d{10,11}", message = "Số điện thoại phải có 10 hoặc 11 chữ số")
    private String phone;

    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean sex;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bod;

    @NotNull(message = "Trạng thái không được để trống")
    private Boolean status;

    // File upload
    private MultipartFile imageFile; // ảnh đại diện (avatar)

    // Danh sách khóa học ID (nếu cần xử lý chọn khóa học)
    private List<Integer> courseIds;

    // Trường dùng để hiển thị tên file đã lưu nếu có
    private String avatar;
}

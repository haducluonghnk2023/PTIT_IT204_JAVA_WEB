package com.data.session10.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfile {
    private MultipartFile profilePicture;
    private String username;
}

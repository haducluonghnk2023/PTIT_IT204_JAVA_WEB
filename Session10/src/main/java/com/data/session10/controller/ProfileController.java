package com.data.session10.controller;

import com.data.session10.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Controller
public class ProfileController {

    @Autowired
    private ServletContext servletContext;

    @GetMapping("upload")
    public String showProfile(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "uploadForm";
    }

    @PostMapping("upload")
    public String handleProfileUpload(@ModelAttribute("userProfile") UserProfile userProfile, Model model) {
        MultipartFile file = userProfile.getProfilePicture();
        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename();
            System.out.println("Uploaded file: " + fileName);

            String filePath = servletContext.getRealPath("/uploads");
            File uploadFile = new File(filePath);
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            try {
                file.transferTo(new File(uploadFile, fileName));
                System.out.println("File saved to: " + uploadFile.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        model.addAttribute("userProfile", userProfile);
        return "profileDetail";
    }
}

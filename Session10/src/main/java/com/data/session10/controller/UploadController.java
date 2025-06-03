package com.data.session10.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session10.model.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class UploadController {

    @Autowired
    private Cloudinary cloudinary;
    @GetMapping("/uploadFile")
    public String showUploadForm(Model model) {
        model.addAttribute("uploadFile", new UploadFile());
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String handleFileUpload(@ModelAttribute("uploadFile") UploadFile uploadFile,
                                   Model model) {

        MultipartFile file = uploadFile.getFile();
        try {
            // upload lên Cloudinary
            Map<?, ?> uploadResult =
                    cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

            // Cloudinary trả về khóa "secure_url" (hoặc "url")
            String imageUrl = (String) uploadResult.get("secure_url");
            if (imageUrl == null || imageUrl.isEmpty()) {
                throw new RuntimeException("Cloudinary không trả về URL ảnh!");
            }

            // đưa URL qua view
            model.addAttribute("imageUrl", imageUrl);
        } catch (Exception e) {
            // có thể log và trả về trang lỗi thân thiện hơn
            throw new RuntimeException("Upload thất bại", e);
        }

        return "uploadSuccess";
    }

}

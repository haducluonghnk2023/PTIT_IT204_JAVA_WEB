package com.data.session10.controller;

import com.data.session10.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@Controller
public class DocumentController {

    @Autowired
    private ServletContext servletContext;
    @GetMapping("/uploadDocument")
    public String showUploadForm(Model model) {
        model.addAttribute("document", new Document());
        return "documentForm";
    }

    @PostMapping("/uploadDocument")
    public String handleDocumentUpload(Document document, Model model) {
        MultipartFile file = document.getFile();
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
        model.addAttribute("message", "Tài liệu đã được tải lên thành công!");
        return "uploadSuccess";
    }
}

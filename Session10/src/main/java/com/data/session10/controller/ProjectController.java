package com.data.session10.controller;

import com.data.session10.model.Document;
import com.data.session10.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class ProjectController {
    private final ServletContext servletContext;

    // Danh sách lưu tạm dự án
    private final List<Project> projectList = new ArrayList<>();

    public ProjectController(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    // Trang hiển thị danh sách dự án
    @GetMapping("/projects")
    public String listProjects(Model model) {
        model.addAttribute("projects", projectList);
        return "listProject";
    }

    // Trang form tạo mới
    @GetMapping("/createProject")
    public String showProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "projectForm";
    }

    // Xử lý tạo dự án
    @PostMapping("/createProject")
    public String createProject(@ModelAttribute("project") Project project,
                                @RequestParam("files") MultipartFile[] files,
                                Model model) {
        List<Document> documentList = new ArrayList<>();
        String uploadsDir = servletContext.getRealPath("/projectDocs/");
        File dir = new File(uploadsDir);
        if (!dir.exists()) dir.mkdirs();

        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    File uploadedFile = new File(uploadsDir + fileName);
                    try (FileOutputStream fos = new FileOutputStream(uploadedFile)) {
                        fos.write(file.getBytes());
                    }

                    Document doc = new Document();
                    doc.setFileName(fileName);
                    documentList.add(doc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi upload file.");
            return "projectForm";
        }

        project.setDocuments(documentList);
        projectList.add(project); // Thêm vào danh sách

        return "redirect:/projects"; // Chuyển hướng về danh sách
    }

    // Trang chỉnh sửa
    @GetMapping("/editProject")
    public String editProject(@RequestParam("name") String projectName, Model model) {
        for (Project p : projectList) {
            if (p.getName().equals(projectName)) {
                model.addAttribute("project", p);
                return "projectForm";
            }
        }
        model.addAttribute("message", "Không tìm thấy dự án.");
        return "redirect:/projects";
    }

    // Cập nhật lại dự án
    @PostMapping("/updateProject")
    public String updateProject(@ModelAttribute("project") Project project,
                                @RequestParam("files") MultipartFile[] files,
                                Model model) {
        // Xóa dự án cũ
        Iterator<Project> iterator = projectList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getName().equals(project.getName())) {
                iterator.remove();
                break;
            }
        }

        // Upload file như tạo mới
        List<Document> documentList = new ArrayList<>();
        String uploadsDir = servletContext.getRealPath("/projectDocs/");
        File dir = new File(uploadsDir);
        if (!dir.exists()) dir.mkdirs();

        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    String fileName = file.getOriginalFilename();
                    File uploadedFile = new File(uploadsDir + fileName);
                    try (FileOutputStream fos = new FileOutputStream(uploadedFile)) {
                        fos.write(file.getBytes());
                    }

                    Document doc = new Document();
                    doc.setFileName(fileName);
                    documentList.add(doc);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi khi cập nhật file.");
            return "projectForm";
        }

        project.setDocuments(documentList);
        projectList.add(project); // Thêm lại
        return "redirect:/projects";
    }

    // Xóa dự án
    @PostMapping("/deleteProject")
    public String deleteProject(@RequestParam("projectName") String projectName) {
        Iterator<Project> iterator = projectList.iterator();
        while (iterator.hasNext()) {
            Project project = iterator.next();
            if (project.getName().equals(projectName)) {
                iterator.remove();
                break;
            }
        }

        return "redirect:/projects";
    }
}

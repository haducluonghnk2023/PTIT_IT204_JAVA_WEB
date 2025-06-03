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
        model.addAttribute("actionUrl", "/createProject");
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
            model.addAttribute("actionUrl", "/createProject");
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
                model.addAttribute("actionUrl", "/updateProject");
                return "projectForm";
            }
        }
        model.addAttribute("message", "Không tìm thấy dự án.");
        return "redirect:/projects";
    }

    // Cập nhật lại dự án
    @PostMapping("/updateProject")
    public String updateProject(@ModelAttribute("project") Project updatedProject,
                                @RequestParam("files") MultipartFile[] files,
                                Model model) {

        Project existingProject = null;
        for (Project p : projectList) {
            if (p.getName().equals(updatedProject.getName())) {
                existingProject = p;
                break;
            }
        }

        if (existingProject == null) {
            model.addAttribute("message", "Không tìm thấy dự án để cập nhật.");
            model.addAttribute("actionUrl", "/updateProject");
            return "projectForm";
        }

        // Cập nhật thông tin mô tả
        existingProject.setDescription(updatedProject.getDescription());

        // Xử lý upload file mới
        List<Document> newDocuments = new ArrayList<>();
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
                    newDocuments.add(doc);
                }
            }

            // Gộp tài liệu cũ và mới
            existingProject.getDocuments().addAll(newDocuments);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi khi cập nhật file.");
            model.addAttribute("actionUrl", "/updateProject");
            return "projectForm";
        }

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

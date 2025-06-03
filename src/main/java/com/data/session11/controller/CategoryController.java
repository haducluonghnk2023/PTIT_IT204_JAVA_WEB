package com.data.session11.controller;

import com.data.session11.dto.CategoryDTO;
import com.data.session11.model.Category;
import com.data.session11.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        return "categoryList";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("categoryDto", new CategoryDTO());
        return "categoryForm";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("categoryDto") CategoryDTO dto,
                              BindingResult result,
                              RedirectAttributes redirect,
                              Model model) {

        // Kiểm tra lỗi validation từ @NotBlank, @Size,...
        if (result.hasErrors()) {
            return "categoryForm";
        }

        // Kiểm tra danh mục đã tồn tại
        if (categoryService.existsByCategoryName(dto.getCategoryName())) {
            model.addAttribute("errorMessage", "Tên danh mục đã tồn tại.");
            return "categoryForm";
        }

        // Nếu hợp lệ thì tạo mới Category entity và lưu
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        category.setStatus(true); // Mặc định là 1

        categoryService.save(category);

        redirect.addFlashAttribute("message", "Thêm danh mục thành công");
        return "redirect:/categories";
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Category category = categoryService.findById(id);
        if (category == null) {
            return "redirect:/categories";
        }
        CategoryDTO dto = new CategoryDTO();
        dto.setCategoryName(category.getCategoryName());
        model.addAttribute("categoryDto", dto);
        model.addAttribute("categoryId", id);
        return "categoryForm";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable("id") int id,
                                 @Valid @ModelAttribute("categoryDto") CategoryDTO dto,
                                 BindingResult result,
                                 RedirectAttributes redirect,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categoryId", id);
            return "categoryForm";
        }

        Category category = categoryService.findById(id);
        if (category == null) {
            redirect.addFlashAttribute("errorMessage", "Không tìm thấy danh mục.");
            return "redirect:/categories";
        }

        if (!category.getCategoryName().equals(dto.getCategoryName()) &&
                categoryService.existsByCategoryName(dto.getCategoryName())) {
            model.addAttribute("errorMessage", "Tên danh mục đã tồn tại.");
            model.addAttribute("categoryId", id);
            return "categoryForm";
        }

        category.setCategoryName(dto.getCategoryName());
        categoryService.update(category);

        redirect.addFlashAttribute("message", "Cập nhật danh mục thành công");
        return "redirect:/categories";
    }

    // === XOÁ ===
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id,
                                 RedirectAttributes redirect) {
        categoryService.deleteById(id);
        redirect.addFlashAttribute("message", "Xóa danh mục thành công");
        return "redirect:/categories";
    }
}

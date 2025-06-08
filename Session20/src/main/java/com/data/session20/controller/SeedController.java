package com.data.session20.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.data.session20.dto.SeedDTO;
import com.data.session20.entity.Seed;
import com.data.session20.service.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seeds")
public class SeedController {
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private SeedService seedService;

    @GetMapping
    public String seeds(@RequestParam(value = "keyword", required = false) String keyword,
                        Model model) {
        List<Seed> seeds;

        if (keyword != null && !keyword.isEmpty()) {
            seeds = seedService.searchByKeyword(keyword);
        } else {
            seeds = seedService.findAll();
        }

        model.addAttribute("seeds", seeds);
        model.addAttribute("keyword", keyword);
        return "seed_list";
    }


    @GetMapping("/add")
    public String addSeed(Model model) {
        model.addAttribute("seedDTO", new SeedDTO());
        model.addAttribute("isEdit", false);
        return "form_seed";
    }

    @PostMapping("/add")
    public String addSeed(@Valid @ModelAttribute("seedDTO") SeedDTO seedDTO,
                          BindingResult bindingResult,
                          Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("isEdit", false);
            return "form_seed";
        }

        MultipartFile file = seedDTO.getFile();

        if (file == null || file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh");
            model.addAttribute("isEdit", false);
            return "form_seed";
        }

        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) uploadResult.get("url");

            if (imageUrl != null) {
                Seed seed = new Seed();
                seed.setSeedName(seedDTO.getSeedName());
                seed.setDescription(seedDTO.getDescription());
                seed.setPrice(seedDTO.getPrice());
                seed.setStock(seedDTO.getStock());
                seed.setImage(imageUrl);

                seedService.save(seed);
                return "redirect:/seeds";
            } else {
                model.addAttribute("error", "Upload ảnh thất bại");
                model.addAttribute("isEdit", false);
                return "form_seed";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi upload: " + e.getMessage());
            model.addAttribute("isEdit", false);
            return "form_seed";
        }
    }

    @GetMapping("/edit/{id}")
    public String editSeed(@PathVariable Long id, Model model) {
        Seed seed = seedService.findById(id);
        if (seed != null) {
            SeedDTO seedDTO = new SeedDTO();
            seedDTO.setSeedName(seed.getSeedName());
            seedDTO.setDescription(seed.getDescription());
            seedDTO.setPrice(seed.getPrice());
            seedDTO.setStock(seed.getStock());

            model.addAttribute("seedDTO", seedDTO);
            model.addAttribute("seedId", seed.getId());
            model.addAttribute("imageUrl", seed.getImage());
            model.addAttribute("isEdit", true);

            return "form_seed";
        }
        return "redirect:/seeds";
    }

    @PostMapping("/edit/{id}")
    public String updateSeed(@PathVariable Long id,
                             @Valid @ModelAttribute("seedDTO") SeedDTO seedDTO,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("seedId", id);
            model.addAttribute("isEdit", true);
            Seed existingSeed = seedService.findById(id);
            if (existingSeed != null) {
                model.addAttribute("imageUrl", existingSeed.getImage());
            }
            return "form_seed";
        }

        try {
            Seed existingSeed = seedService.findById(id);
            if (existingSeed == null) {
                return "redirect:/seeds";
            }

            MultipartFile file = seedDTO.getFile();

            // Chỉ upload ảnh mới nếu có file được chọn
            if (file != null && !file.isEmpty()) {
                Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = (String) uploadResult.get("url");
                if (imageUrl != null) {
                    existingSeed.setImage(imageUrl);
                }
            }

            // Cập nhật thông tin khác
            existingSeed.setSeedName(seedDTO.getSeedName());
            existingSeed.setDescription(seedDTO.getDescription());
            existingSeed.setPrice(seedDTO.getPrice());
            existingSeed.setStock(seedDTO.getStock());

            seedService.update(existingSeed);
            return "redirect:/seeds";

        } catch (Exception e) {
            model.addAttribute("error", "Lỗi khi cập nhật: " + e.getMessage());
            model.addAttribute("seedId", id);
            model.addAttribute("isEdit", true);
            return "form_seed";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteSeed(@PathVariable Long id) {
        Seed seed = seedService.findById(id);
        if (seed != null) {
            seedService.deleteById(id);
        }
        return "redirect:/seeds";
    }
}
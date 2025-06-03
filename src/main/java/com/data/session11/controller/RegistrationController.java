package com.data.session11.controller;

import com.data.session11.dto.UserRegistrationDto;
import com.data.session11.validation.groups.AdminGroup;
import com.data.session11.validation.groups.Default;
import com.data.session11.validation.groups.UserGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class RegistrationController {
    @GetMapping("/registration")
    public String showForm(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "register";
    }

    @PostMapping("/registration")
    public String processForm(@ModelAttribute("user")  @Validated UserRegistrationDto userDto, BindingResult result, Model model) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<UserRegistrationDto>> defaultViolations = validator.validate(userDto, Default.class);

        for (ConstraintViolation<UserRegistrationDto> violation : defaultViolations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            result.rejectValue(propertyPath, null, message);
        }

        // Validate theo nhóm tương ứng với role
        Class<?> group = "admin".equals(userDto.getRole()) ? AdminGroup.class : UserGroup.class;
        Set<ConstraintViolation<UserRegistrationDto>> groupViolations = validator.validate(userDto, group);

        for (ConstraintViolation<UserRegistrationDto> violation : groupViolations) {
            String propertyPath = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            result.rejectValue(propertyPath, null, message);
        }

        if (result.hasErrors()) {
            return "register";
        }

        model.addAttribute("message", "Đăng ký thành công!");
        return "registerSuccess";
    }
}

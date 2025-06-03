package com.data.session11.validation;

import com.data.session11.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCategoryName, String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && !categoryRepository.existsByCategoryName(value);
    }
}


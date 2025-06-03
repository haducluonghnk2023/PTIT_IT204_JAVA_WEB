package com.data.session11.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) return false;

        // Kiểm tra độ dài ≥ 8, có chữ thường, chữ hoa và số
        return password.length() >= 8 &&
                password.matches(".*[a-z].*") &&
                password.matches(".*[A-Z].*") &&
                password.matches(".*\\d.*");
    }
}
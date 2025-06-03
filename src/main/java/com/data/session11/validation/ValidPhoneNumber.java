package com.data.session11.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default "Số điện thoại không hợp lệ. Phải bắt đầu bằng 0 và có 10 chữ số";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
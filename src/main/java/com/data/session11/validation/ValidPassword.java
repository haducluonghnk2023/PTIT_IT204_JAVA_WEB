package com.data.session11.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {
    String message() default "Mật khẩu phải có ít nhất 8 ký tự, bao gồm chữ hoa, chữ thường và số";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

package com.elara.app.validation_utils_test.annotation;

import com.elara.app.validation_utils_test.validator.HexColorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = HexColorValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface HexColor {

    String message() default "Invalid hex color code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
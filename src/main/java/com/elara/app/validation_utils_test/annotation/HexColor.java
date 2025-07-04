package com.elara.app.validation_utils_test.annotation;

import com.elara.app.validation_utils_test.validator.HexColorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = HexColorValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface HexColor {

    String message() default "Invalid hex color code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
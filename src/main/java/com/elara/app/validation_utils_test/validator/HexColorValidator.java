package com.elara.app.validation_utils_test.validator;

import com.elara.app.validation_utils_test.annotation.HexColor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HexColorValidator implements ConstraintValidator<HexColor, String> {

    private static final String HEX_COLOR_PATTERN = "^#([0-9a-fA-F]{6})$";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isEmpty()) return true;
        return value.matches(HEX_COLOR_PATTERN);
    }
}
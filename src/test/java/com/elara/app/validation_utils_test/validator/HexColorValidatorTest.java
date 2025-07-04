package com.elara.app.validation_utils_test.validator;

import com.elara.app.validation_utils_test.annotation.HexColor;
import jakarta.validation.Payload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HexColorValidatorTest {

    private HexColor createAnnotation() {
        return new HexColor() {

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public String message() {
                return "";
            }

            @Override
            public Class<?>[] groups() {
                return new Class[0];
            }

            @Override
            public Class<? extends Payload>[] payload() {
                return new Class[0];
            }
        };
    }

    @Nested
    class ValidationTest {
        HexColorValidator hexColorValidator = new HexColorValidator();

        @BeforeEach
        void init() {
            hexColorValidator.initialize(createAnnotation());
        }

        @Test
        void acceptsValidFullHexColor() {
            assertTrue(hexColorValidator.isValid("#1A2B3C", null));
        }

        @Test
        void acceptsNullValue() {
            assertTrue(hexColorValidator.isValid(null, null));
        }

        @Test
        void acceptsEmptyValue() {
            assertTrue(hexColorValidator.isValid("", null));
        }

        @Test
        void rejectsShorthandWithHash() {
            assertFalse(hexColorValidator.isValid("#123", null));
        }

        @Test
        void rejectsShorthandWithoutHash() {
            assertFalse(hexColorValidator.isValid("123", null));
        }

        @Test
        void rejectsWithoutHash() {
            assertFalse(hexColorValidator.isValid("1A2B3C", null));
        }

        @Test
        void rejectsInvalidCharacters() {
            assertFalse(hexColorValidator.isValid("#ZZZZZZ", null));
        }

    }

}
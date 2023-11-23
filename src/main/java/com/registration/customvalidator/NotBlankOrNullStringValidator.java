package com.registration.customvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankOrNullStringValidator implements ConstraintValidator<NotBlankOrNull, String> {

	@Override
	public void initialize(NotBlankOrNull constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !value.trim().isEmpty();
	}

}

package com.example.demo.api;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class DealNameValidator implements ConstraintValidator<DealName, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {	
		return !StringUtils.isEmpty(value) && value.startsWith("D");
	}

}

package com.example.demo;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {InstructorExistsValidator.class})
@ReportAsSingleViolation
public @interface InstructorExists {
	String message() default "{instructorexists}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
	@Target(FIELD)
	@Retention(RUNTIME)
	@Documented
	public static @interface List{
		InstructorExists[] value();
	}
	
}

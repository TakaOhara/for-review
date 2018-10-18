package com.example.demo;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Instructor;
import com.example.demo.repositories.InstructorRepository;

public class InstructorExistsValidator implements ConstraintValidator<InstructorExists, String> {
	
	@Autowired
	InstructorRepository repository;
	
	@Override
	public void initialize(InstructorExists annotation) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context){
		
		if(value == null) {
			return true;
		}
		
		Optional<Instructor> inst = repository.findByEmail(value);
		
		if(!inst.isPresent()) {
			return true;
		}else {
			return false;
		}
		
	}
}

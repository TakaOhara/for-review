package com.example.demo;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.UserInfo;
import com.example.demo.repositories.UserInfoRepository;

public class UserInfoExistsValidator implements ConstraintValidator<UserInfoExists, String> {
	
	@Autowired
	UserInfoRepository repository;
	
	@Override
	public void initialize(UserInfoExists annotation) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context){
		
		if(value == null) {
			return true;
		}
		
		UserInfo userInfo = repository.findByEmail(value);
		
		if(userInfo == null) {
			return true;
		}else {
			return false;
		}
		
	}
}

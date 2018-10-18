package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
	
	public UserInfo findByEmail(String email);

}

package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repositories.UserInfoRepository;

@Service
public class UserInfoService implements UserDetailsService {
	
	@Autowired
	UserInfoRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(email);//user@test到着
		if(email == null || "".equals(email)) {
			throw new UsernameNotFoundException("Username is empty");
		}
		
		UserInfo userInfo = repository.findByEmail(email);
		System.out.println(userInfo);
		//UserInfo(username=test_user, email=test@user, password=test, 
		//enabled=true, authority=ROLE_USER)到着
		if(userInfo == null) {
			throw new UsernameNotFoundException("User not found for email:" + email);
		}
		
		
		return userInfo;
	}
	
	@Transactional
	public void save(UserInfo userInfo) {
		String hushPass = passwordEncoder.encode(userInfo.getPassword());
		userInfo.setPassword(hushPass);
		repository.save(userInfo);
	}

}

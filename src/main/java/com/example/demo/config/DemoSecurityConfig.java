package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.example.demo.service.UserInfoService;

@Configuration
@EnableWebSecurity//security基本設定
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private DataSource securityDataSource;
	
	@Autowired
	private UserInfoService userInfoService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("john").password("{noop}test123").roles("EMPLOYEE");
//		auth.inMemoryAuthentication().withUser("mary").password("{noop}test123").roles("MANAGER");
//		auth.inMemoryAuthentication().withUser("susan").password("{noop}test123").roles("ADMIN");
		
//		auth.jdbcAuthentication().dataSource(securityDataSource);
		
//		auth.userDetailsService(userInfoService);
		
		
		auth.authenticationProvider(createAuthProvider());
		
	}	
	
	private AuthenticationProvider createAuthProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userInfoService);
		authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return authProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		boolean isEnableLoginSystem = true;
		
		if(isEnableLoginSystem) {
		http.authorizeRequests()
				.antMatchers("/","/register/**").permitAll()//**はそれより下の階層全て
				.anyRequest().authenticated()//それ以外は認証無しでのアクセス不可
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.defaultSuccessUrl("/task", true)
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		}
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		//セキュリティ設定を無視
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**","/bootstrap/**");
	}
	

	
	//beans
	//bcrypt bean definition
	//1.ハッシュ化前に認証を試す場合はコメントアウトしておかないとパスワードがハッシュ化されているか判定してしまう。
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userInfoService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
		return auth;
	}

	
}

package com.edocode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
//			.requestMatchers().authenticated()
			.antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
//			.requestMatchers().permitAll()
			.antMatchers("/notices", "/contact").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();
	}
	
}

package com.SpringSecurity.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Config {
	
	   @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		   http.authorizeHttpRequests(auth ->auth.anyRequest().authenticated());
		   http.formLogin(Customizer.withDefaults());
	        return http.build();
	    }
	   
	   
	   public UserDetailsService userDetailService() {
		   UserDetails ajay =User.withUsername("ajay").password("{noop}1234")
				   .roles("USER").build();
		   UserDetails narmada =User.withUsername("narmada").password("{noop}1234").roles("USER").build();
		   return new InMemoryUserDetailsManager(ajay,narmada);
	   }

}

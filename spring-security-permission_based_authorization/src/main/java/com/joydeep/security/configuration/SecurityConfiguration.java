package com.joydeep.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder().encode("admin@123")).roles("ADMIN")
				.authorities("ACCESS_TEST1", "ACCESS_TEST_2").and().withUser("dan")
				.password(passwordEncoder().encode("dan@123")).roles("USER").and().withUser("manager")
				.password(passwordEncoder().encode("manager@123")).roles("MANAGER").authorities("ACCESS_TEST1");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/index").permitAll().antMatchers("/profile/**").authenticated()
				.antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
				.antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1").antMatchers("/api/public/test2")
				.hasAuthority("ACCESS_TEST2").and().httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

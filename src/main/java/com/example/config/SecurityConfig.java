package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.service.MyAuthenticationProvider;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/res/**");
		web.ignoring().antMatchers("/dist/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").access("ROLE_ADMIN")
			.antMatchers("/guest/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/**").authenticated();

		http.csrf().disable();

		http.formLogin().loginPage("/guest/login")
			.loginProcessingUrl("/guest/login_processing")
			.failureUrl("/guest/login?error")
			.defaultSuccessUrl("/user/index", true)
			.usernameParameter("loginId")
			.passwordParameter("password");

		http.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout_processing"))
			.logoutSuccessUrl("/guest/index")
			.invalidateHttpSession(true);

		http.authenticationProvider(myAuthenticationProvider);
	}
}

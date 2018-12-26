package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.example.domain.User;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Autowired UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String loginEmail = authentication.getName();
		String password = authentication.getCredentials().toString();
		return authenticate(loginEmail, password);
	}

	public Authentication authenticate(String loginEmail, String password) throws AuthenticationException {
		User user = userService.login(loginEmail, password);
		if(user == null) return null;
		user = userService.updated(user.getId());

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		String role = "";
		switch (user.getUserType()) {
		case "관리자": role = "ROLE_ADMIN"; break;
		case "사용자": role = "ROLE_USER"; break;
		}
		grantedAuthorities.add(new SimpleGrantedAuthority(role));
		return new MyAuthentication(loginEmail, password, grantedAuthorities, user);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

	public class MyAuthentication extends UsernamePasswordAuthenticationToken {
		private static final long serialVersionUID = 1L;
		User user;

		public MyAuthentication (String loginEmail, String password,
									List<GrantedAuthority> grantedAuthorities, User user) {
			super(loginEmail, password, grantedAuthorities);
			this.user = user;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}
	}

}

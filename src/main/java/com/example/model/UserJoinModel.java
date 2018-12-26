package com.example.model;

import java.util.Date;

import com.example.domain.User;

import lombok.Data;

@Data
public class UserJoinModel {

	String name;
	String loginEmail;
	String password;
	String rePassword;
	String nickName;

	public User toUser() {
		User user = new User();
		user.setLoginEmail(this.loginEmail);
		user.setPassword(this.password);
		user.setName(this.name);
		user.setMakeTime(new Date());
		if(this.nickName == null || this.nickName.isEmpty()) {
			user.setNickName(this.name);
		} else {
			user.setNickName(this.nickName);
		}
		return user;
	}
}

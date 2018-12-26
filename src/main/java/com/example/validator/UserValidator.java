package com.example.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.model.UserJoinModel;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return UserJoinModel.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object object, Errors errors) {
		
		UserJoinModel userModel = (UserJoinModel) object;
		
		String name = userModel.getName();
		String loginEmail = userModel.getLoginEmail();
		String password = userModel.getPassword();
		String rePassword = userModel.getRePassword();
		
		if(loginEmail == null || loginEmail.trim().isEmpty()) {
			errors.rejectValue("loginEmail", null, "필수 입력 항목입니다.");
		}
		String regex = "[0-9a-zA-Z][0-9a-zA-Z._-]{4,20}@[a-z]++.[a-z]+";
		if(!loginEmail.matches(regex)) {
			errors.rejectValue("loginEmail", null, "올바른 이메일을 입력해주세요.");
		}
		if(name == null || name.trim().isEmpty()) {
			errors.rejectValue("name", null, "필수 입력 항목입니다.");
		}
		if(name.trim().length()<2) {
			errors.rejectValue("name", null, "정확한 이름을 입력해주세요.");
		}
		if(password.trim().length() < 8 || password.trim().length() > 15) {
			errors.rejectValue("password", null, "8~15자 이내로 입력해주세요.");
		}
		if(!password.equals(rePassword)) {
			errors.rejectValue("rePassword", null, "비밀번호가 일치하지 않습니다.");
		}
	}
}

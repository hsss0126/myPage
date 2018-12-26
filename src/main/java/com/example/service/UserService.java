package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.example.domain.User;
import com.example.model.UserJoinModel;
import com.example.repository.UserRepository;
import com.example.utils.Encryption;
import com.example.validator.UserValidator;

@Service
public class UserService {

	@Autowired UserRepository userRepository;

	@Transactional
	public User login(String loginEmail, String password) {
		User user = userRepository.findOneByLoginEmail(loginEmail);
		if(user == null) return null;
		String pw = Encryption.encrypt(password, Encryption.SHA256);
		if(user.getPassword().equals(pw) == false) return null;
		userRepository.updateLogin(user.getId(), new Date(), true, user.getAccessCount()+1);
		return user;
	}
	
	public User updated(int id) {
		return userRepository.findOneById(id);
	}
	
	@Transactional
	public void logout(int id) {
		userRepository.updateLogout(id, false);
	}
	
	public boolean isVaild(UserJoinModel userJoinModel, BindingResult bindingResult) {
		User user = userRepository.findOneByLoginEmail(userJoinModel.getLoginEmail());
		if(user != null) {
			bindingResult.rejectValue("loginEmail", null, "이미 가입된 이메일입니다.");
			return false;
		}
		UserValidator userValidator = new UserValidator();
		userValidator.validate(userJoinModel, bindingResult);
		if(bindingResult.hasErrors()) {
			return false;
		}
		return true;
	}

	public User join(User user) {
		user.setEnabled(false);
		user.setUserType("미인증");
		user.setPassword(Encryption.encrypt(user.getPassword(), Encryption.SHA256));
		
		return userRepository.save(user);
	}
	
	public void certify(int id) {
		User user = userRepository.findOneById(id);
		if(user != null && user.getUserType().equals("미인증")) {
			user.setUserType("사용자");
			userRepository.save(user);
		}
	}
}

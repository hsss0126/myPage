package com.example.service;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.example.domain.User;

@Component
@PropertySource("classpath:mailserver.properties")
public class MailService {

	@Autowired private JavaMailSender mailSender;
	
	@Value("${mailserver.username}")
	private String from;//보내는 사람
	private String subject = "님 가입을 축하합니다.";//메일제목(생략가능)
	
	public void sendMail(User user) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setFrom(from);
			messageHelper.setTo(user.getLoginEmail());
			messageHelper.setSubject(user.getName() + subject);
			messageHelper.setText("<html><body>"
					+ "<a href=\"http://localhost:8080/shs/guest/certify?id="
					+ user.getId() +"\">인증하기</a></body></html>", true);
			
			mailSender.send(message);
		}catch (Exception e) {
			System.out.println("이메일 전송 오류 캐치@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			e.printStackTrace();
		}
	}
}

package com.example.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String loginEmail;
	String password;
	String name;
	boolean enabled;
	String userType;
	Date makeTime;
	Date latelyTime;
	String nickName;
	int accessCount;
}

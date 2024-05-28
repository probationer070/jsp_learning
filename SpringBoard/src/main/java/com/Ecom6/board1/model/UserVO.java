package com.Ecom6.board1.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String mail;
	private String phone;
	private String address;
	private String regist_day;
}

package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;   			//id
	private String account; 	//账户名
	private String password; 	//密码
	private String email;		//邮箱
	private String role;
	private String permission;
	private String name;		//姓名
	private String idcard;		//身份证号
	private String phone;		//手机号 
	private String img;			//图片
}

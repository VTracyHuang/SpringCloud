package com.example.demo.handler;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;

@RestController
@RequestMapping("/find")
public class THandler {
	//查询用户资料 
	@RequestMapping("/findUserByAccount")
	public User findUserByAccount(HttpSession session) {
		System.out.println(session);
		String name = session.getAttribute("user").toString();
		System.out.println(name);
		return null;
	};
	
}

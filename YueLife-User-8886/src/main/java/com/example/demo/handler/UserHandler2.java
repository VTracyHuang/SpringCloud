package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user2")
public class UserHandler2 {
	@Autowired
	private UserService userService;
	
	//修改密码
	@RequestMapping("/updatePassword")
	public String updatePassword(@RequestParam(value = "account",required=false)String account,@RequestParam("password1")String password1,@RequestParam("password2")String password2,@RequestParam("password3")String password3) throws IOException {
		account="Emma";
		boolean flag = userService.findPassByAccount(account,password1,password2,password3);
		if(flag) {
			return "redirect:/yuelife/modiPassMsg"; 
		}
		return "redirect:/yuelife/password";
	}
	//添加我的留言
	@RequestMapping("/addWords")
	public String addWords(@RequestParam("w_name") String w_name,@RequestParam("w_email") String w_email,@RequestParam("w_content") String w_content) throws IOException {
		boolean flag =  userService.addWords(w_name, w_email, w_content);
		if(flag) {
			return "redirect:/yuelife/words";
		}
		return "redirect:/yuelife/aboutus";
	};
}

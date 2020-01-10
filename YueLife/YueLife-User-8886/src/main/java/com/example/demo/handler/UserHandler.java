package com.example.demo.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Words;
import com.example.demo.service.UserService;


@RequestMapping("/user")
@RestController
public class UserHandler {
	
	@Autowired
	private UserService userService;
	
	//查询用户资料 
	@RequestMapping("/findUserByAccount")
	public User findUserByAccount(@RequestParam("account")String account) {
		return userService.findUserByAccount(account);
	};
	
	@RequestMapping("/findUserByAccount2")
	public User findUserByAccount2(HttpSession session) {
		String account = session.getAttribute("user").toString();
		return findUserByAccount(account);
	};
	//修改用户资料
	@RequestMapping("/updateUserByAccount")
	public boolean updateUser(@RequestParam("account")String account,@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("id")String id) {
		User user = new User(Integer.parseInt(id), account, null, email, null,null,name, null, phone, null);
		return userService.updateUser(user);
	}
	
	//显示留言
	@RequestMapping("/showAllWords")
	public List<Words> showAllWords(){
		return userService.showAllWords();
		
	}

	//回复某条留言
	@RequestMapping("/replyWords")
	public boolean replyWords(@RequestParam("w_content")String w_content,@RequestParam("w_pid")String w_pid) {
		String w_account = "Tracy";
		Integer pid = new Integer(w_pid);
		return userService.replyWords(w_account,w_content,pid);
	}
	
	//显示我的留言
	@RequestMapping("showWordsByUser")
	public List<Words> showWordsByUser(String username){
		return userService.showWordsByUser(username);
	}
}

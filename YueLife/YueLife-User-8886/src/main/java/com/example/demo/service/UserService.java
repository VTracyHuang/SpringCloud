package com.example.demo.service;


import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Words;


public interface UserService {
	
	//展示我的资料信息
	public User findUserByAccount(String account);
	
	//修改我的资料信息
	public boolean updateUser(User user);
	
	//查询我的真实密码
	public boolean findPassByAccount(String account, String password1, String password2, String password3);
	
	//添加我的留言
	public boolean addWords(String w_name,String w_email,String w_content);
		
	//显示所有的留言
	public List<Words> showAllWords();
	
	//回复某条留言
	public boolean replyWords(String w_account, String w_content, Integer w_pid);
	
	public List<Words> showWordsByUser(String w_name);
}

package com.yuelife.common.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuelife.common.pojo.User;
import com.yuelife.common.pojo.Words;


@FeignClient(name = "WECLOUD-USERS") // 要请求的微服务的名字
public interface UserService {
	
	@GetMapping("/user/findUserByAccount")
	public User findUserByAccount(@RequestParam("account")String account);
	
	//修改用户资料
	@GetMapping("/user/updateUserByAccount")
	public boolean updateUser(@RequestParam("account")String account,@RequestParam("name")String name,@RequestParam("email")String email,@RequestParam("phone")String phone,@RequestParam("id")String id);

	//显示留言
	@GetMapping("/user/showAllWords")
	public List<Words> showAllWords();
	
	//回复某条留言
	@GetMapping("/user/replyWords")
	public boolean replyWords(@RequestParam("w_content")String w_content,@RequestParam("w_pid")String w_pid);
	
	//显示我的留言
	@GetMapping("/user/showWordsByUser")
	public List<Words> showWordsByUser(String username);
	
	@GetMapping("/user2/updatePassword")
	public String updatePassword(@RequestParam(value = "account",required=false)String account,@RequestParam("password1")String password1,@RequestParam("password2")String password2,@RequestParam("password3")String password3);
	
	//添加我的留言
	@GetMapping("/user2/addWords")
	public String addWords(@RequestParam("w_name")String w_name,@RequestParam("w_email")String w_email,@RequestParam("w_content")String w_content);
	
	
}

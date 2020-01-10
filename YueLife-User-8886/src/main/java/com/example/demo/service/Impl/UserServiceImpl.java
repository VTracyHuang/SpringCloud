package com.example.demo.service.Impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.Words;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserByAccount(String account) {
		return userMapper.findUserByAccount(account);
	}

	@Override
	public boolean updateUser(User user) {
		return userMapper.updateUser(user);
	}

	@Override
	public boolean addWords(String w_name,String w_email,String w_content) {
		//获取当前的系统时间
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String w_posttime = simpledateFormat.format(date);
		return userMapper.addWords( w_name,w_email,w_content,w_posttime);
	}

	@Override
	public boolean findPassByAccount(String account,String password1,String password2,String password3) {
		
		//判断两次密码是否一致
		if(password2.equals(password3)) {
			//查找真实的密码
			String realPass= userMapper.findPassByAccount(account);
			//判断真实密码和输入的真实密码是否一致
			if(realPass.equals(password1)) {
				return userMapper.updatePassword(password2,account);
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	//显示所有的留言
	@Override
	public List<Words> showAllWords() {
		return userMapper.showWordsById();
	}

	@Override
	public boolean replyWords(String w_account, String w_content, Integer w_pid) {
		//获取当前的系统时间
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpledateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String w_posttime = simpledateFormat.format(date);
        Words words = new Words(0,w_account,null,w_content,w_posttime,"1",w_pid,null);
		return  userMapper.relyWords(words);
	}
	@Override
	public List<Words> showWordsByUser(String w_name) {
		w_name="Emma";
		return userMapper.showWordsByUser(w_name);
	}
}

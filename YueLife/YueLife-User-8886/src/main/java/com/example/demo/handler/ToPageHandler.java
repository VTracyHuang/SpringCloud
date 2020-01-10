
package com.example.demo.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/yuelife")
public class ToPageHandler {
	
	//去主页
	@RequestMapping("/index")
	public void toIndex(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//去个人中心的信息资料页
	@RequestMapping("/personal")
	public void toPersonal(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/personal.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//去投诉中心
	@RequestMapping("/complaint")
	public void toComplaint(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/complaint.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//去投诉管理中心
	@RequestMapping("/back-complaint")
	public void toBackComplaint(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/back-complaint.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//去关于页 
	@RequestMapping("/aboutus")
	public void toAboutus(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/aboutus.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//去留言板
	@RequestMapping("/words")
	public void toWords(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/words.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//去修改密码的页面
	@RequestMapping("/password")
	public void toPassword(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/password.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//去修改密码的页面
	@RequestMapping("/modiPassMsg")
	public void toModiPass(HttpServletResponse response) {
		try {
			response.sendRedirect("http://localhost:8886/html/modipassmsg.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

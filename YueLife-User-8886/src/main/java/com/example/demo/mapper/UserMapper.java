package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Words;



@Mapper
public interface UserMapper {

	//展示我的资料信息
	@Select("SELECT * FROM user WHERE account=#{account}")
	public User findUserByAccount(String account);

	//更新我的资料信息
	@Update("UPDATE user SET email=#{email},name=#{name},phone=#{phone} WHERE id=#{id}")
	public boolean updateUser(User user);
	
	//显示留言
	@Select("SELECT * FROM words where w_pid=#{w_pid}")
	@Results({
		@Result(id=true,column = "w_id",property = "w_id"),
		@Result(property="replywords",column="w_id",many = @Many(select="showAllWords"))
	})
	public List<Words> showAllWords(Integer w_pid);
	
	
	@Select("SELECT * FROM words")
	@Results({
		@Result(id=true,column = "w_id",property = "w_id"),
		@Result(property="replywords",column="w_id",many = @Many(select="showAllWords"))
	})
	public List<Words> showWordsById();
	//添加我的留言
	@Insert("INSERT INTO words (w_name,w_email,w_content,w_posttime) VALUES(#{w_name},#{w_email},#{w_content},#{w_posttime})")
	public boolean addWords(@Param("w_name")String w_name,@Param("w_email")String w_email,@Param("w_content")String w_content,@Param("w_posttime")String w_posttime);

	//查询我的账号密码
	@Select("SELECT password FROM user WHERE account=#{account} ")
	public String findPassByAccount(String account);
	
	//修改我的账号密码
	@Update("UPDATE user SET password=#{password} WHERE account=#{account}")
	public boolean updatePassword(@Param("password")String password,@Param("account")String account);
	
	//回复我的留言
	@Insert("INSERT INTO words(w_name,w_content,w_posttime,w_pid) VALUES(#{w_name},#{w_content},#{w_posttime},#{w_pid})")
	public boolean relyWords(Words words);

	
	//显示我的留言
	@Select("SELECT * FROM words WHERE w_name =#{w_name}")
	public List<Words> showWordsByUser(String w_name);

}

package com.yuelife.common.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Words implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int w_id;
	private String w_name;
	private String w_email;
	private String w_content;
	private String w_posttime;
	private String w_state;
	private int w_pid;
	private List<Words> replywords;
}

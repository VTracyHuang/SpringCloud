package com.yuelife.common.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuelife.common.pojo.User;



@FeignClient(name = "woniu58-shiro")
public interface FindUser {
    @RequestMapping("/user/byname")
    public User findbyname(String name); 
}

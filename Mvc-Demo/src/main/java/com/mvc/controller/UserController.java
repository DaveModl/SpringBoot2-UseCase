package com.mvc.controller;

import com.mvc.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 返回JSON类型
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/{id}")
    public User getUser(@PathVariable("id") Long id){
        return new User(id,"Dave","test@a.com");
    }
}

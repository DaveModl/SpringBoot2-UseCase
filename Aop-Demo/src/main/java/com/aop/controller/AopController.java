package com.aop.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopController {
    @RequestMapping("/hi")
    public void sayHi(){
        System.out.println("Hi");
    }
    @RequestMapping("/hello")
    public void sayHello(){
        System.out.println("Hello");
    }
    @RequestMapping("/param/{num}")
    public void readParam(@PathVariable("num") int num){
        System.out.println("环绕方法执行");
    }
}

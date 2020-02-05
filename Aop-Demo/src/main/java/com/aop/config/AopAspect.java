package com.aop.config;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 配置切面类
 */
@Aspect
@Component
public class AopAspect {
    @Pointcut("execution(* com.aop.controller.AopController.*(..))")
    public void aspectPt() {
    }

    @Before("aspectPt()")
    public void before() {
        System.out.println("execute before..");
    }

    @After("aspectPt()")
    public void after(){
        System.out.println("execute after..");
    }

    @AfterReturning("aspectPt()")
    public void afterReturn(){
        System.out.println("after returning");
    }

    @AfterThrowing("aspectPt()")
    public void throwing(){
        System.out.println("exception throw");
    }

}

package com.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundAspect {
    @Pointcut("execution(public * com.aop.controller.AopController.readParam(int)) && args(num))")
    public void aspectPt(int num) {
    }
    @Around("aspectPt(num)")
    public void around(ProceedingJoinPoint point, int num) {
        try {
            System.out.println("执行前");
            point.proceed();
            System.out.println("读取param=" + num);
        } catch (Throwable throwable) {
            System.out.println("出现异常");
            throwable.printStackTrace();
        }
    }
}

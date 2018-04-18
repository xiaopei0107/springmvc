package com.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogService {
   
    /** 
     * 在Spring 
     * 2.0中，Pointcut的定义包括两个部分：Pointcut表示式(expression)和Pointcut签名(signature 
     * )。让我们先看看execution表示式的格式： 
     * 括号中各个pattern分别表示修饰符匹配（modifier-pattern?）、返回值匹配（ret 
     * -type-pattern）、类路径匹配（declaring 
     * -type-pattern?）、方法名匹配（name-pattern）、参数匹配（(param 
     * -pattern)）、异常类型匹配（throws-pattern?），其中后面跟着“?”的是可选项。 
     *  
     * @param point 
     * @throws Throwable 
     */  
	//Controller层切点
	@Pointcut("@annotation(com.springmvc.aop.AopMethodLog)")  //匹配AopMethodLog注解
	public void AopMethodLog1(){//切入点方法
		
	}
	
	@Before("AopMethodLog1()")
	public void doBefore(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println("进入前置通知...");
	}
	
	@After("AopMethodLog1()")
	public void doAfter(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		System.out.println("进入后置通知...");
	}
	
	
	
	
}
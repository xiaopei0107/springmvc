package com.springmvc.service.impl;

import org.springframework.stereotype.Component;

import com.springmvc.service.HelloWorldService;

@Component("helloWorldService")
public class HelloWorldServiceImpl implements HelloWorldService{

	@Override
	public String sayHello(String msg) {
		// TODO Auto-generated method stub
		System.out.println("Hello-"+msg);
		 return "Hello-"+msg;
	}
}
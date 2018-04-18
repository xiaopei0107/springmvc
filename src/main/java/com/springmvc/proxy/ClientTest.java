package com.springmvc.proxy;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 SecurityHandler handler=new SecurityHandler();  
        UserManager userManager=(UserManager)handler.createProxyInstance(new UserManagerImpl());  
        userManager.addUser("zha", "123");  
	}

}

package com.springmvc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类实现
 * @author Sotiy-赵小沛
 *
 */
public class SecurityHandler implements InvocationHandler {

	private Object object; // 代理对象

	public Object createProxyInstance(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
	}

	/**
	 * args --方法的参数 "zha", "123"
	 * method --方法名 addUser
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		 checkSecurity();  
		//调用目标方法  
		 Object ret = method.invoke(object, args);
		return ret;
	}

	private void checkSecurity() {
		System.out.println("checkSecurity");
	}

}

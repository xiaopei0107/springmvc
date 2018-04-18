package com.springmvc.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.springmvc.bean.StudentBean;

public class Test2 {

	public static void main(String[] args) {
		List<StudentBean> stuList = new ArrayList<>();
		
		StudentBean bean = new StudentBean();
		bean.setStuName("aaa");
		bean.setStuId(1);
		
		StudentBean bean2 = new StudentBean();
		bean2.setStuName("bbb");
		bean2.setStuId(2);
		
		stuList.add(bean);
		stuList.add(bean2);
		
		Map map = new HashMap();
		
		for(int i=0;i<stuList.size();i++){
			map.put(stuList.get(i).getStuId(), stuList.get(i).getStuName());
		}
		
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			System.out.println(iterator.next().equals("1"));
			
		}
	}

}

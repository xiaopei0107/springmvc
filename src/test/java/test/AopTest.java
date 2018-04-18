package test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.springmvc.bean.StudentBean;
//import com.springmvc.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-hibernate.xml" })
public class AopTest {
	
//	@Autowired
//	private StudentService studentService;
//	
//	@Ignore
//	 @Test  
//    public void inteceptorTest(){   
//		 List<StudentBean> stuList = this.studentService.getAllStudentInfo();
//			for(int i=0;i<stuList.size();i++){
//				StudentBean bean = stuList.get(i);
//				System.out.println("信息："+bean.toString());
//			}
//    }  
}

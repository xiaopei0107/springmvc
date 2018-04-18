package com.springmvc.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.aop.AopMethodLog;
import com.springmvc.pojo.TStudent;
import com.springmvc.service.StudentService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/stu")
@Api(value = "添加学生接口")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@AopMethodLog(testAop="进入学生跳转页面..")
	@RequestMapping("/toAddStu")
	public String toAddStu(Model model){
		model.addAttribute("stu", new TStudent());
		System.out.println("进入学生跳转页面..");
		return "/stu/addStudent";
	}
	
	@RequestMapping("/saveStu")
	public String saveStu(@ModelAttribute("stu") TStudent stu,HttpServletRequest request,Model model){
		System.out.println("stu:"+stu.getStuName());
		stu.setClassId(1);
		studentService.save(stu);
		
		List<TStudent> stuList = studentService.findAll();
		model.addAttribute("stuList", stuList);
		return "/stu/showStudent";
	}
	
	@RequestMapping("/addStu")
	@ApiOperation(value = "添加学生信息", httpMethod = "POST", notes = "add user")
	public String addStu(@ApiParam(required = true, name = "stu", value = "用户信息json数据") @ModelAttribute("stu") TStudent stu,HttpServletRequest request){
		System.out.println("stu:"+stu.getStuName());
		stu.setClassId(1);
		studentService.save(stu);
		return "sccuess";
	}
	
	@RequestMapping("/auto")
	public String toAuto(){
		return "/stu/autoComplete";
	}
	
	@RequestMapping("/showStu")
	public String showStu(HttpServletRequest request,Model model){

		List<TStudent> stuList = studentService.findAll();
		model.addAttribute("stuList", stuList);
		return "/stu/showStudent";
	}
	
	@RequestMapping("/searchAll")
	@ResponseBody
	public String searchAll(HttpServletResponse response){
		response.setCharacterEncoding("utf8");
		try {
			List<TStudent> stuList = studentService.findAll();
			
			JSONArray jsonarray = JSONArray.fromObject(stuList);
			//System.out.println(jsonarray.toString());
			String str = "{'store': {'book':[{'category':'reference','author':'NigelRees','title':'SayingsoftheCentury','price':8.95},{'category':'fiction','author':'EvelynWaugh','title':'SwordofHonour','price':12.99},{'category':'fiction','author':'HermanMelville','title':'MobyDick','isbn':'0-553-21311-3','price':8.99},{'category':'fiction','author':'J.R.R.Tolkien','title':'TheLordoftheRings','isbn':'0-395-19395-8','price':22.99}],'bicycle':{'color':'red','price':19.95}}}";
			System.out.println(str);
			OutputStream out = response.getOutputStream();
			out.write(str.getBytes("UTF-8"));
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "tt";
	}
	
	@RequestMapping("/searchAuto")
	@ResponseBody
	public String searchAuto(HttpServletResponse response){
		response.setCharacterEncoding("utf8");
		PrintWriter pw=null;
		try {
			List<TStudent> stuList = studentService.findAll();
			StringBuilder data = new StringBuilder();
			data.append("{").append("data").append(":").append("["); 
			for(int i=0;i<stuList.size();i++){
				TStudent stu = stuList.get(i);
				data.append("{").append('"').append("title").append('"').append(':').append('"').append(stu.getStuName()).append('"').append("},"); 
			} 
			JSONObject json = JSONObject.fromObject(data.substring(0,data.length()-1)+"]}"); 
			System.out.println("json:"+json.toString());
			//JSONArray jsonarray = JSONArray.fromObject(stuList);
			//System.out.println("jsonarray:"+jsonarray.toString());
			pw=response.getWriter();
			pw.write(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(pw!=null){
				pw.flush();
				pw.close();
			}
		}
	
		return null;
	}
	
}

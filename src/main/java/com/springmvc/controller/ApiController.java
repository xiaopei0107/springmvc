package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.springmvc.pojo.TStudent;
import com.springmvc.service.StudentService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;


@RestController
@RequestMapping("restApi")
@Api(value = "获得学生信息接口")
public class ApiController {
	@Autowired
	private StudentService studentService;
	
	/**
	 * 根据用户名获取用户对象
	 * @param name
	 * @return
	 */
	@RequestMapping("/test")
	@ResponseBody
	@ApiOperation(value = "根据用户名获取用户对象", notes = "根据用户名获取用户对象")
	public String getUserByName(@PathVariable String id) throws Exception{
	   TStudent stu = studentService.get(id);

	    if(stu != null) {
	       return JSONObject.toJSONString(stu);
	    } else {
	        return "根据{id=" + id + "}获取不到UcUser对象";
	    }
	}
}

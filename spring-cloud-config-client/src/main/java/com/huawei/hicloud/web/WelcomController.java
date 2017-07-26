package com.huawei.hicloud.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
// controller必须加@RefreshScope注解,否则post方式访问/bus/refresh不能刷新git上的配置
@RefreshScope
public class WelcomController {

	@Value("${foo}")
	String foo;
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String hi() {
		return foo;
	}
	
	@RequestMapping(value="/test/{name}/{age}", method=RequestMethod.POST)
	public String testMap(@RequestBody Map<String, Object> map, Student st) {
		System.out.println("map: " + map);
		System.out.println("Student: " + st);
		return foo;
	}
	
	
}

class Student {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
	
}

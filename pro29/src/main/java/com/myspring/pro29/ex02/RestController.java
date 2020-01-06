package com.myspring.pro29.ex02;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

// @RestController�� �������� �ʾҽ��ϴ�.
@Controller
public class RestController {
	
	@RequestMapping(value = "/res1")
	// �޼��� ȣ�� �� �����͸� �����ϵ��� �����մϴ�.
	@ResponseBody
	// Map �����͸� �������� �����մϴ�.
	public Map<String, Object> res1(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", "hong");
		map.put("name", "ȫ�浿");
		return map;
	}
	
	// �޼��� ȣ�� �� home.jsp�� �������� �����մϴ�.
	@RequestMapping(value = "/res2")
	public ModelAndView res2() {
		return new ModelAndView("home");
	}
}

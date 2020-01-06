package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// ���������� �����ϴ� Controller �������̽��� �ݵ�� �����մϴ�.
public class SimpleUrlController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// �۾��� ��ģ �� ���̸��� ModelAndView�� index.jsp�� �����Ͽ� ��ȯ�մϴ�.
		return new ModelAndView("index.jsp");
	}
}
 
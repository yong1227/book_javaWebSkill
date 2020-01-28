package com.spring.ex02;
// com.spring ���� ��Ű���� Ŭ������ ��ġ�ؾ� �ֳ����̼��� ����˴ϴ�.

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// ��Ʈ�ѷ� ���� �ڵ����� �����մϴ�.
@Controller("loginController")
public class LoginController {
	// /test/loginForm.do �� /test/loginForm2.do�� ��û �� loginForm()�� ȣ���մϴ�.
	@RequestMapping(value = { "/test/loginForm.do", "/test/loginForm2.do" }, method = { RequestMethod.GET })
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("loginForm");
		return mav;
	}
	
	// GET ��İ� POST ��� ��û �� ��� ó���մϴ�.
    @RequestMapping(value = "/test/login.do", method={RequestMethod.GET,RequestMethod.POST})
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		String userID = request.getParameter("userID");
		String userName = request.getParameter("userName");
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);

		return mav;
	}

//	@RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView login2(
//			// @RequestParam�� �̿��� �Ű������� userID�̸� �� ���� ���� userID�� �ڵ����� �����մϴ�.
//			@RequestParam("userID") String userID, 
//			// @RequestParam�� �̿��� �Ű������� userName�̸� �� ���� ���� userName�� �ڵ����� �����մϴ�.
//            @RequestParam("userName") String userName,
//            HttpServletRequest request, HttpServletResponse response) throws Exception {
//		request.setCharacterEncoding("utf-8");
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("result");
//
//		//getParameter() �޼��带 �̿��� �ʿ䰡 �����ϴ�.
//		// String userID = request.getParameter("userID");
//		// String userName = request.getParameter("userName");
//		
//		System.out.println("userID: "+userID);
//		System.out.println("userName: "+userName);
//		mav.addObject("userID", userID);
//		mav.addObject("userName", userName);
//
//		return mav;
//	}
	

	@RequestMapping(value = "/test/login2.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login2(
			// required �Ӽ��� �����ϸ� required�� �⺻���� true�Դϴ�.
			@RequestParam("userID") String userID, 
			// required �Ӽ� true
                               @RequestParam(value="userName", required=true) String userName,
                               // false
			                   @RequestParam(value="email", required=false) String email,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("result");
		
		// String userID = request.getParameter("userID");
		// String userName = request.getParameter("userName");
		
		System.out.println("userID: "+userID);
		System.out.println("userName: "+userName);
		System.out.println("email: "+ email);
		mav.addObject("userID", userID);
		mav.addObject("userName", userName);
		return mav;
	}
	
	
	@RequestMapping(value = "/test/login3.do", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login3(
			// @RequestParam�� �̿��� Map�� ���۵� �Ű����� �̸��� key, ���� value�� �����մϴ�.
			@RequestParam Map<String, String> info,
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		
		// Map�� ����� �Ű������� �̸����� ���޵� ���� �����ɴϴ�.
		String userID = info.get("userID");
		String userName = info.get("userName");
		System.out.println("userID: "+userID);
		System.out.println("userName: "+userName);
		
		// @RequestParam���� ������ Map �̸����� ���ε��մϴ�.
		mav.addObject("info", info);
		mav.setViewName("result");
		return mav;
	}
	
	
	@RequestMapping(value = "/test/login4.do", method = { RequestMethod.GET, RequestMethod.POST })
	// @ModelAttribute�� �̿��� ���޵Ǵ� �Ű����� ���� LoginVO Ŭ������ �̸��� ���� �Ӽ��� �ڵ����� �����մϴ�.
	// addObject()�� �̿��� �ʿ� ���� info�� �̿��� �ٷ� JSP���� LoginVO �Ӽ��� ������ �� �ֽ��ϴ�.
	public ModelAndView login4(@ModelAttribute("info") LoginVO loginVO,
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ModelAndView mav = new ModelAndView();
		System.out.println("userID: "+loginVO.getUserID());
		System.out.println("userName: "+loginVO.getUserName());
		mav.setViewName("result");
		return mav;
	}
	   
	@RequestMapping(value = "/test/login5.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login5(
			// �޼��� ȣ�� �� Model Ŭ���� ��ü�� �����մϴ�.
			Model model,
			                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		// JSP�� ������ �����͸� model�� addAttribute() �޼��带 �̿��ؼ� ���ε��մϴ�.
		model.addAttribute("userID", "hong");
		model.addAttribute("userName", "ȫ�浿");
		return "result";
	}	
}

package com.spring.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.member.service.MemberService;
import com.spring.member.vo.MemberVO;



// @Controller�� �̿��� MemberControllerImpl Ŭ������ ���� id�� memberController�� ���� �ڵ� �����մϴ�.
@Controller("memberController")
public class MemberControllerImpl   implements MemberController {
	// @Autowired�� �̿��� id�� memberService�� ���� �ڵ� �����մϴ�.
	@Autowired
	private MemberService memberService;
	// @Autowired�� �̿��� id�� memberVO�� ���� �ڵ� �����մϴ�.
	@Autowired
	MemberVO memberVO ;
	
	@Override
	// �� �ܰ�� ��û �� �ٷ� �ش� �޼��带 ȣ���ϵ��� �����մϴ�.
	@RequestMapping(value="/member/listMembers.do" ,method = RequestMethod.GET)
	public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		List membersList = memberService.listMembers();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("membersList", membersList);
		return mav;
	}

	@Override
	@RequestMapping(value="/member/addMember.do" ,method = RequestMethod.POST)
	public ModelAndView addMember(
			// ȸ�� ����â���� ���۵� ȸ�� ������ �ٷ� MemberVO ��ü�� �����մϴ�.
			@ModelAttribute("member") MemberVO member,
			                  HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		int result = 0;
		// ������ memberVO ��ü�� SQL������ ������ ȸ������� �մϴ�.
		result = memberService.addMember(member);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	@Override
	@RequestMapping(value="/member/removeMember.do" ,method = RequestMethod.GET)
	public ModelAndView removeMember(
			// ���۵� ID�� ���� id�� �����մϴ�.
			@RequestParam("id") String id, 
			           HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		memberService.removeMember(id);
		ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
		return mav;
	}
	
	/*@RequestMapping(value = { "/member/loginForm.do", "/member/memberForm.do" }, method =  RequestMethod.GET)*/
	// ���Խ��� �̿��� ��û���� Form.do�� ������ form() �޼��带 ȣ���մϴ�.
	@RequestMapping(value = "/member/*Form.do", method =  RequestMethod.GET)
	public ModelAndView form(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = getViewName(request);
		ModelAndView mav = new ModelAndView();
		System.out.println("viewName : " + viewName);
		mav.setViewName(viewName);
		return mav;
	}
	
	

	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
			System.out.println("uri : " + uri);
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
			System.out.println("begin : " + begin);
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
			System.out.println("end : " + end);
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
			System.out.println("end : " + end);
		} else {
			end = uri.length();
			System.out.println("end : " + end);
		}

		String viewName = uri.substring(begin, end);
		if (viewName.indexOf(".") != -1) {
			viewName = viewName.substring(0, viewName.lastIndexOf("."));
			System.out.println("viewName1 : " + viewName);
		}
		if (viewName.lastIndexOf("/") != -1) {
			viewName = viewName.substring(viewName.lastIndexOf("/"), viewName.length());
			System.out.println("viewName2 : " + viewName);
		}
		return viewName;
	}


}

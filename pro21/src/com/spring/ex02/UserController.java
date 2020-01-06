package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

// ���� ������ userMethodNameResolver ������Ƽ�� ����Ϸ��� �ݵ�� MultiActionController�� ��ӹ޾ƾ� �մϴ�.
public class UserController extends MultiActionController {
//	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String userID = "";
//		String passwd = "";
//		ModelAndView mav = new ModelAndView();
//		request.setCharacterEncoding("utf-8");
//		userID = request.getParameter("userID");
//		passwd = request.getParameter("passwd");
//
//		// ModelAndView�� �α��� ������ ���ε��մϴ�.
//		mav.addObject("userID", userID);
//		mav.addObject("passwd", passwd);
//		// ModelAndView ��ü�� �������� JSP �̸��� �����մϴ�.
//		mav.setViewName("result");
//		return mav;
//	}
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userID = "";
		String passwd = "";
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("utf-8");
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");
		//getViewName() �޼��带 ȣ���� ��û���� Ȯ��� .do�� ������ ���̸��� �����ɴϴ�.
		String viewName=getViewName(request);
		
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		//mav.setViewName("result");
		// �� �̸��� �����մϴ�.
		mav.setViewName(viewName);
	    System.out.println("ViewName:"+viewName);
		return mav;
	}

	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
	    ModelAndView mav=new ModelAndView();
	    String id=request.getParameter("id");
	    String pwd=request.getParameter("pwd");
	    String name=request.getParameter("name");
	    String email=request.getParameter("email");

	    mav.addObject("id",id);
	    mav.addObject("pwd",pwd);
	    mav.addObject("name",name);
	    mav.addObject("email",email);
	    mav.setViewName("memberInfo");
	    return mav;
	}
	
	// request ��ü���� URL ��û���� ������ .do�� ������ ��û���� ���մϴ�. 
	private  String getViewName(HttpServletRequest request) throws Exception {
	      String contextPath = request.getContextPath();
	      String uri = (String)request.getAttribute("javax.servlet.include.request_uri");
	      System.out.println("uri : " + uri);
	      //trim() ���������ߴ� �� �� ���ڿ��̸�
	      if(uri == null || uri.trim().equals("")) {
	    	 //request��ü���� uri�� �����´�.
	         uri = request.getRequestURI();
	         System.out.println("uri1 : " + uri);
	      }

	      int begin = 0;
	      //contextPath�� �� ���ڿ��� �ƴϸ�
	      if(!((contextPath==null)||("".equals(contextPath)))){
	    	 // contextPath�� ���̸� begin�� �ִ´�.
	    	 
	         begin = contextPath.length();
	         System.out.println("contextPath : " +  contextPath);
	         System.out.println("begin1 : "+ begin);
	      }

	      int end;
	      if(uri.indexOf(";")!=-1){
	         end=uri.indexOf(";");
	         System.out.println("end1 : " + end);
	      }else if(uri.indexOf("?")!=-1){
	         end=uri.indexOf("?");
	         System.out.println("end2 : "+ end);
	      }else{
	         end=uri.length();
	         System.out.println("end3 : " + end);
	      }
	      
	      String fileName=uri.substring(begin,end);
	      System.out.println("fileName1 : " + fileName);
	      if(fileName.indexOf(".")!=-1){
	         fileName=fileName.substring(0,fileName.lastIndexOf("."));
	         System.out.println("fileName2 : " + fileName);
	      }
	      if(fileName.lastIndexOf("/")!=-1){
	         fileName=fileName.substring(fileName.lastIndexOf("/"),fileName.length());
	         
	         int fileName3LIO = fileName.lastIndexOf("/");
	         int fileName3Length = fileName.length();
	        
	         System.out.println("fileName3LIO : " + fileName3LIO);
	         System.out.println("fileName3Length : " + fileName3Length);
	         System.out.println("fileName3 : " + fileName);
	      }
	      return fileName;
	   }
}

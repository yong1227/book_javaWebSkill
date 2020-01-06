package com.spring.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class AccountController  extends MultiActionController  {
	   private AccountService accService ; 
	   // �Ӽ� accService�� ���� �����ϱ� ���� setter�� �����մϴ�.
	   public void setAccService(AccountService accService){
	     this.accService = accService;
	   }	

	   public ModelAndView sendMoney(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      ModelAndView mav=new ModelAndView();
	      // �ݾ��� ��ü�մϴ�.
	      accService.sendMoney();
	      mav.setViewName("result");
	      return mav;
	   }
}

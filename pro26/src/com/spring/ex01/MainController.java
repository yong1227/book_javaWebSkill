package com.spring.ex01;
// �ֳ����̼��� ����ǵ��� �Ϸ��� �ش� Ŭ������ �ݵ�� <component-scan>���� ������ ��Ű���� ���� ��Ű���� �����ؾ� �մϴ�.

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// @Controller �ֳ����̼��� �̿��� MainController Ŭ������ ������ �ڵ� ��ȯ�մϴ�. �� id�� mainContorller �Դϴ�.
@Controller("mainController")
// @RequestMapping�� �̿��� ù ��° �ܰ��� URL ��û��/test�̸� MainController ���� ��û�մϴ�.
@RequestMapping("/test")
public class MainController {
   // @RequestMapping�� �̿��� �� ��° �ܰ��� URL ��û�� /main.do�̸� mainController ���� main1() �޼��忡�� ��û�մϴ�.
  // method = RequestMethod GET���� �����ϸ� GET ������� ��û �� �ش� �޼��尡 ȣ��˴ϴ�.
   @RequestMapping(value="/main1.do" ,method=RequestMethod.GET)
   public ModelAndView main1(HttpServletRequest request, HttpServletResponse response)  throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg","main1");
      mav.setViewName("main");
      return mav;
   }
   
   // @RequestMapping�� �̿��� �� ��°�ܰ��� URL ��û�� /main.do�̸� mainController ���� main2() �޼��忡�� ��û�մϴ�.
   // method = RequestMethod GET���� �����ϸ� GET ������� ��û �� �ش� �޼��尡 ȣ��˴ϴ�. 
   @RequestMapping(value="/main2.do" ,method = RequestMethod.GET)
   public ModelAndView main2(HttpServletRequest request, HttpServletResponse response) throws Exception{
      ModelAndView mav=new ModelAndView();
      mav.addObject("msg","main2");
      mav.setViewName("main");
      return mav;
   }
}

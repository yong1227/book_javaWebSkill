package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
//확장자만 일치하는 패턴
@WebServlet("*.do")
//@WebServlet("/*") : 모든 요청 URL 패턴
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		String context = request.getContextPath();
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		String mapping = request.getServletPath();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet3</title>");
		out.println("</head>");
		out.println("<body bgcolor='red'>");
		out.println("<b>컨텍스트 이름 : "+context +"</b><br>");
		out.println("<b>URI: "+uri+"</b><br>");
		out.println("<b>전체 경로 URL : "+url+"</b><br>");
		out.println("<b>매핑 이름 : "+mapping+"</b><br>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	
	}
	

}

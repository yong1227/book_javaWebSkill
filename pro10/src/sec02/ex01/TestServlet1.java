package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet1
 */
// ��Ȯ�� �̸����� ��ġ�ϴ� URL ����
@WebServlet("/first/test")
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// ���ؽ�Ʈ �̸��� �����´�.
		String context = request.getContextPath();
		// URI�� �����´�.
		String uri = request.getRequestURI().toString();
		// ��ü URL�� �����´�
		String url = request.getRequestURL().toString();
		// ���� ���� �̸��� �����´�.
		String mapping = request.getServletPath();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Test Servlet </title>");
		out.println("</head>");
		out.println("<body bgcolor = 'green'>");
		out.println("<b> TestServlet �Դϴ�. </b><br>");
		out.println("<b>���ؽ�Ʈ �̸� : " + context + "</b><br>");
		out.println("<b>URI : " + uri + "</b><br>");
		out.println("<b>URL : " + url + "</b><br>");
		out.println("<b>���� �̸� : " + mapping + "</b><br>");
		out.println("</body>");
		out.print("</html>");
		out.close();
		
		
	}

}

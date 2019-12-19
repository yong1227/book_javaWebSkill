package sec01.ex01;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		
		System.out.println("doGet �޼��� ȣ��");
	}

	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println("destory �޼��� ȣ��");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		
		System.out.println("init �޼��� ȣ�⤼");
	}
}

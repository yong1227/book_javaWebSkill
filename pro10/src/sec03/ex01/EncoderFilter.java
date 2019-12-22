package sec03.ex01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
// WebFilter �ֳ����̼��� �̿��� ��� ��û�� ���͸� ��ġ�� �մϴ�.
@WebFilter("/*")
public class EncoderFilter implements Filter { // ����� ���� ���ʹ� �ݵ�� Filter �������̽��� �����ؾ� �մϴ�.
	ServletContext context;
    /**
     * Default constructor. 
     */
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    	System.out.println("destroy ȣ��");    
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	// doFilter() �ȿ��� ���� ���� ����� �����մϴ�.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("doFilter ȣ��");
		
		// �ѱ� ���ڵ� ���� �۾��� �մϴ�.
		request.setCharacterEncoding("utf-8");
		
		// �� ���ø����̼��� ���ؽ�Ʈ �̸��� �����ɴϴ�.
		String context = ((HttpServletRequest) request).getContextPath();
		
		// �� ���������� ��û�� ��û URI�� �����ɴϴ�.
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		
		// ��û URI�� ���� ��θ� �����ɴϴ�.
		String realPath = request.getRealPath(pathinfo);
		String mesg = " Context  ����:" + context + "\n URI ���� : " + pathinfo + "\n ������ ���:  " + realPath;
		System.out.println(mesg);
		
		// ��û ���Ϳ��� ��û ó�� ���� �ð��� ���մϴ�.
		long begin = System.currentTimeMillis();
		
		// ���� ���ͷ� �ѱ�� �۾��� �����մϴ�.
		chain.doFilter(request, response);
		
		// ���� ���Ϳ��� ��û ó�� ���� �ð��� ���մϴ�.
		long end = System.currentTimeMillis();
		
		// �۾� ��û ���� ���� �ð� ���� ���� �۾� ���� �ð��� ���մϴ�.
		System.out.println("�۾� �ð�:" + (end - begin) + "ms");
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("utf-8 ���ڵ�............");
		context = fConfig.getServletContext();
	}

}

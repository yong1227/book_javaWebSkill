package sec04.ex01;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Application Lifecycle Listener implementation class LoginImpl
 *
 */
@WebListener
// ���ǿ� ���ε� �� �̺�Ʈ�� ó���մϴ�.
public class LoginImpl implements HttpSessionBindingListener {

	String user_id;
	String user_pw;
	
	// ���ǿ� ���ε� �� 1�� ������ŵ�ϴ�.
	static int total_user = 0;
	
    /**
     * Default constructor. 
     */
    public LoginImpl() {
        // TODO Auto-generated constructor stub
    }
    
    public LoginImpl(String user_id, String user_pw) {
		this.user_id = user_id;
		this.user_pw = user_pw;
	}

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    // ���ǿ� ���� �� �����ڼ��� ������ŵ�ϴ�.
    public void valueBound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("����� ����");
		++total_user;
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    // ���ǿ��� �Ҹ� �� ������ ���� ���ҽ�ŵ�ϴ�.
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("����� ���� ����");
		total_user--;
    }
	
}

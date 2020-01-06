package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class JsonServlet2
 */
@WebServlet("/json2")
public class JsonServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();

		// �迭�� ������ totalObject�� �����մϴ�.
		JSONObject totalObject = new JSONObject();
		// memberInfo JSON ��ü�� ������ memberArray �迭�� �����մϴ�.
		JSONArray membersArray = new JSONArray();
		// ȸ�� �� ���� ������ �� memberInfo JSON ��ü�� �����մϴ�.
		JSONObject memberInfo = new JSONObject();
		// ȸ�� ������ name/value ������ �����մϴ�.
		memberInfo.put("name", "������");
		memberInfo.put("age", "25");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "��������");
        // ȸ�� ������ �ٽ� membersArray �迭�� �����մϴ�.
		membersArray.add(memberInfo);

		// �ٸ� ȸ�� ������ name/value ������ ������ �� membersArray�� �ٽ� �����մϴ�.
		memberInfo = new JSONObject();
		memberInfo.put("name", "�迬��");
		memberInfo.put("age", "21");
		memberInfo.put("gender", "����");
		memberInfo.put("nickname", "Įġ");
		membersArray.add(memberInfo);
		
		// totalObject�� members��� name���� membersArray�� value�� �����մϴ�.
		totalObject.put("members", membersArray);
		
		// JSONObject�� ���ڿ��� ��ȯ�մϴ�.
		String jsonInfo = totalObject.toJSONString();
		System.out.print(jsonInfo);
		// JSON �����͸� �������� �����մϴ�.
		writer.print(jsonInfo);
	}

}

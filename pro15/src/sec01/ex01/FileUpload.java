package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
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

	private void doHandle(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
			String encoding = "utf-8";
			// ���ε��� ���� ��θ� �����մϴ�.
			File currentDirPath = new File("D:\\YONG\\dev\\webDev\\spring\\javaWeb\\file_repo");
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ���� ��θ� �����մϴ�.
			factory.setRepository(currentDirPath);
			// �ִ� ���ε� ������ ���� ũ�⸦ �����մϴ�.
			factory.setSizeThreshold(1024 * 1024);

			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// request ��ü���� �Ű������� List�� �����ɴϴ�.
				List items = upload.parseRequest(request);
				for (int i = 0; i < items.size(); i++) {
					// ���� ���ε�â���� ���ε�� �׸���� �ϳ��� �����ɴϴ�.
					FileItem fileItem = (FileItem) items.get(i);
	
					// �� �ʵ��̸� ���۵� �Ű����� ���� ����մϴ�.
					if (fileItem.isFormField()) {
						System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					} else {
						// �� �ʵ尡 �ƴϸ� ���� ���ε� ����� �����մϴ�.
						System.out.println("�Ķ���͸�:" + fileItem.getFieldName());
						System.out.println("���ϸ�:" + fileItem.getName());
						System.out.println("����ũ��:" + fileItem.getSize() + "bytes");
						
						// ���ε��� ���� �̸��� �����ɴϴ�.
						if (fileItem.getSize() > 0) {
							int idx = fileItem.getName().lastIndexOf("\\");
							if (idx == -1) {
								idx = fileItem.getName().lastIndexOf("/");
							}
							String fileName = fileItem.getName().substring(idx + 1);
							
							// ���ε��� ���� �̸����� ����ҿ� ������ ���ε��մϴ�.
							File uploadFile = new File(currentDirPath + "\\" + fileName);
							fileItem.write(uploadFile);
						} // end if
					} // end if
				} // end for
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}

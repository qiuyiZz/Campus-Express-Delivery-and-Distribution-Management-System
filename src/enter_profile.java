

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Login;

/**
 * Servlet implementation class enter_profile
 */
@WebServlet("/enter_profile")
public class enter_profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enter_profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����Ա���ĸ�������ҳ��
		String name;
		String role;
		String staffID;
		String job;
		
		//...............
		Login su = new Login("superuser","1234567");
		su.login();
		//��ȡ��¼�û���Ϣ
		HttpSession isession = request.getSession();
		String ID=(String) isession.getAttribute("userID");
		//ȱ����Ϣ��Login�û���staffID
		ArrayList<ArrayList> r=su.select("staff", "staffName,department", "staffID='"+ID+"'");
		name=r.get(0).get(0).toString();
		job=r.get(0).get(1).toString();
		staffID=ID;
		
		request.setAttribute("name",name);
		request.setAttribute("role","Ա��");
		request.setAttribute("phone",staffID);
		request.setAttribute("job",job);
		
		request.getRequestDispatcher("my-profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

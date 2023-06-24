

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Login;
import database.Register_Login;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �����¼
		System.out.print("login");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
		System.out.println(role);
		PrintWriter out=response.getWriter();
		Login su=new Login("superuser","1234567");
		su.login();
		ArrayList<ArrayList> report = su.select("report","*","dateID=convert(char(10),getdate(),120)");
		if(report.isEmpty()) {
			Integer totalgrid=Integer.parseInt(su.select("cabinet_details","count(*)",null).get(0).get(0).toString()); //总快递柜数
			Integer totaloccupy=Integer.parseInt(su.select("cabinet_details","count(*)","isFull=1").get(0).get(0).toString());//已占用快递柜数
			Double rate = (double) ((totaloccupy* 100/totalgrid ) / 100.0);
			su.insert("report", "getdate(),0,0,0,0,"+rate);
		}
		String LoginInfo = Register_Login.UserLogin(su,username,role);
		//.........................
		if(password.equals(LoginInfo)==false) {		// �����ж�����
			request.setAttribute("msg", "密码错误！请重新登录");
			System.out.print("22222222");
			response.sendRedirect("login.jsp");
		}
		else {
			HttpSession isession = request.getSession();
			//��һ�δ���Session
			//if(isession.getAttribute("userID")==null) {
				System.out.println("保存用户");
				isession.setAttribute("userID", username);
				isession.setMaxInactiveInterval(6000); //����Session���������ڣ�Ĭ��30min�������60min
			//}
			//��ȡsession�е��˺�
			String userID = (String) isession.getAttribute("userID"); //��ȡ�����û���
			if(role.equals("用户")) {
				System.out.print("hhhhhh");
				response.sendRedirect("index_client.jsp");
			}
			else {                     //Ա��
				response.sendRedirect("index.jsp");
			}
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����ע��
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String id=request.getParameter("phone");
		System.out.println(name);
		//
		Login su=new Login("superuser","1234567");
		su.login();
		try {
			Login LoginInfo = Register_Login.Register(su, id, name, password, "user");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "注册成功！");
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

}

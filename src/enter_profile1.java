

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
 * Servlet implementation class enter_profile1
 */
@WebServlet("/enter_profile1")
public class enter_profile1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enter_profile1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理用户的个人中心页面
				String name="hhhhhhh";
				String role="学生";
				String phone="11111111111111";
				String address="22222222222222";
				
				Login su = new Login("superuser","1234567");
				su.login();
				//获取登录用户信息
				HttpSession isession = request.getSession();
				String userID=(String) isession.getAttribute("userID");
				//
				ArrayList<ArrayList> r=su.select("users", "userName,address", "userID='"+userID+"'");
				name=r.get(0).get(0).toString();
				phone=userID;
				address=r.get(0).get(1).toString();
				
				request.setAttribute("name",name);
				request.setAttribute("role",role);
				request.setAttribute("phone",phone);
				request.setAttribute("address",address);
				
				request.getRequestDispatcher("my-profile1.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

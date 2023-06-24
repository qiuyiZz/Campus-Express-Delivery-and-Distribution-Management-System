

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
 * Servlet implementation class change_password
 */
@WebServlet("/change_password")
public class change_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newpwd=request.getParameter("newpwd");
		String oldpwd=request.getParameter("oldpwd");
		
		Login su = new Login("superuser","1234567");
		su.login();
		//获取session中的账号
		HttpSession isession = request.getSession();
		String userID = (String) isession.getAttribute("userID");
		//验证原密码输入错误，返回错误提示；否则返回设置成功
		ArrayList<ArrayList> pwd=su.select("users", "userPwd", "userID='"+userID+"'");
		//旧密码错误
		if(pwd.get(0).get(0)!=oldpwd) {
			request.setAttribute("msg", "原密码错误!");
		}
		//验证旧密码正确，设置新密码
		else{
			su.update("users","userPwd="+newpwd, "userID="+su);
			request.setAttribute("msg", "恭喜你！修改成功！");
		}			
		
		request.getRequestDispatcher("change_password.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

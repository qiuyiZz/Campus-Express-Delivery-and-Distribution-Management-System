

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Login;
import dispatch.ReceivingProcess;

/**
 * Servlet implementation class timetable
 */
@WebServlet("/timetable")
public class timetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timetable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int[][] timetable=new int[7][9];
		for(int i=0;i<7;i++) {
			for(int j=0;j<9;j++) {
				System.out.println(request.getParameter(""+(i+1)+""+(j+1)));
				timetable[i][j]=Integer.parseInt(request.getParameter(""+(i+1)+""+(j+1)).replace("繁忙","0").replace("空闲", "1"));
			}
		}
		//
		//注释部分为我的添加内容
		Login su = new Login("superuser","1234567");
		su.login();
		//获取登录用户信息
		HttpSession isession = request.getSession();
		String userID=(String) isession.getAttribute("userID");
		ReceivingProcess.ChangeTimeTable(su,userID,timetable);
		
		request.setAttribute("msg", "恭喜您！修改成功！");
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

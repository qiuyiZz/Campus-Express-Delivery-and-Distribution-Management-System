

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Login;
import dispatch.ReceivingProcess;

/**
 * Servlet implementation class timedelay
 */
@WebServlet("/timedelay")
public class timedelay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public timedelay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//保存用户的时间延迟
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		Login su = new Login("superuser","1234567");
		su.login();
		//获取登录用户信息
		HttpSession isession = request.getSession();
		String userID=(String) isession.getAttribute("userID");
		try {
			ReceivingProcess.ApplyForDelay(su,userID,starttime,endtime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "已成功申请延迟！");
		request.getRequestDispatcher("timedelay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

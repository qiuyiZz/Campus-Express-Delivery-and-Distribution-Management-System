package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.Login;

/**
 * Servlet implementation class report
 */
@WebServlet("/report")
public class report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public report() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		Login su = new Login("superuser","1234567");
		su.login();
		Date now = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String Now = formatter.format(now);
		Date Nowaday;
		try {
			Nowaday = formatter.parse(Now);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer totalgrid=Integer.parseInt(su.select("cabinet_details","count(*)",null).get(0).get(0).toString()); //总快递柜数
		Integer totaloccupy=Integer.parseInt(su.select("cabinet_details","count(*)","isFull=1").get(0).get(0).toString());//已占用快递柜数
		Double rate = (double) ((totaloccupy* 100/totalgrid ) / 100.0);
		su.update("report", "cabinetUtilization="+rate, "dateID=convert(char(10),getdate(),120)");
		ArrayList<ArrayList> report = su.select("report","*","dateID='"+Now+"'");
		//获取每日报告需要的值，替换掉此处试用的值
		HttpSession session = request.getSession();
		 session.setAttribute("date",report.get(0).get(0).toString());	
		 session.setAttribute("s_n",report.get(0).get(1).toString());	
		 session.setAttribute("w_n",report.get(0).get(2).toString());	
		 session.setAttribute("se_n",report.get(0).get(3).toString());	
		 session.setAttribute("e_n",report.get(0).get(4).toString());	
		 session.setAttribute("rate",report.get(0).get(5).toString());	
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/DailyReport.jsp");
	        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

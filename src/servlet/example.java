package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import database.Login;
import problem.ProblemProcess;

/**
 * Servlet implementation class example
 */
@WebServlet("/example")
public class example extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public example() {
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
		ArrayList<ArrayList> l = su.select("problem","expressNumber,recipientTel,retentionReminderTime,exitWay,exitTime,retentionCode",null); 
		//获取问题件表中的对应内容
				
				ArrayList<result2>lr=(ArrayList<result2>)new ArrayList();
				for(int i=0;i<l.size();i++) {
					
					lr.add(new result2(l.get(i).get(0).toString(),l.get(i).get(1).toString(),l.get(i).get(2).toString(),
							l.get(i).get(3).toString(),l.get(i).get(4).toString(),l.get(i).get(5).toString()));
				}
		
				//提醒
				 if(request.getParameter("param2")!=null) {
			        	String p2 = request.getParameter("param2"); 
			        	try {
							ProblemProcess.sendMessage(su, p2);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	
			        }
		
		//退回
		 if(request.getParameter("param3")!=null) {
	        	String p3 = request.getParameter("param3"); 
	        	ProblemProcess.setExit(su,p3,"退件");
	        	ProblemProcess.setStatus(su,p3,"成功退件");
	        	/*
	        	for(int i=0;i<lr.size();i++) {
	        		 if (lr.get(i).a.contentEquals(p3)) {
	        			 lr.remove(i);
	        		 }
	        		 
	        	 }
	        	 */
	        	
	        }
		 String jsonStringrr = JSON.toJSONString(lr);
		 int num=lr.size();
			 HttpSession session = request.getSession();
			 session.setAttribute("num_e",""+num);				
			 session.setAttribute("array_e",jsonStringrr);
				//System.out.println(num);
				//System.out.println(jsonStringrr);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/example.jsp");
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

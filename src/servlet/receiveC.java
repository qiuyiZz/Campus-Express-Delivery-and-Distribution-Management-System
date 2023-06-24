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
import dispatch.ReceivingProcess;
import problem.ProblemProcess;

/**
 * Servlet implementation class receiveC
 */
@WebServlet("/receiveC")
public class receiveC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public receiveC() {
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
		
		HttpSession isession = request.getSession();
		//获取session中的账号
		String userID = (String) isession.getAttribute("userID"); //获取到的用户名
		
		ArrayList<ArrayList> l = su.select("dispatch,express","express.expressNumber,expressCompany,recipientName,express.recipientTel,"
				+ "submissionTime,location,pickupCode,status","express.recipientTel="+userID+" and express.expressNumber=dispatch.expressNumber");
				
				ArrayList<result4>lr=(ArrayList<result4>)new ArrayList();
				for(int i=0;i<l.size();i++) {
					
					lr.add(new result4(l.get(i).get(0).toString(),l.get(i).get(1).toString(),l.get(i).get(2).toString(),
							l.get(i).get(3).toString(),l.get(i).get(4).toString(),l.get(i).get(5).toString(),
							l.get(i).get(6).toString(),l.get(i).get(7).toString()));
				}
				//取件
				String msg=null;
				if(request.getParameter("param3")!=null) {
		        	String p3 = request.getParameter("param3"); 
		        	System.out.println(su.select("express", "status", "expressNumber="+p3).get(0).get(0));
		        	if(((String) su.select("express", "status", "expressNumber="+p3).get(0).get(0)).trim().equals("已派送")) {
		        		try {
		        			ReceivingProcess.PickUp(su,p3);
		        		} catch (ParseException e) {
		        			// TODO Auto-generated catch block
		        			e.printStackTrace();
		        		}
		        		msg="已取件";
		        	}
		        	msg="不可取";
				}
				request.setAttribute("msg", msg);
				String jsonStringrr = JSON.toJSONString(lr);
				 int num=lr.size();
		 HttpSession session = request.getSession();
		 session.setAttribute("num_rc",""+num);				
		 session.setAttribute("array_rc",jsonStringrr);
			//System.out.println(num);
			//System.out.println(jsonStringrr);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/receive_client.jsp");
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

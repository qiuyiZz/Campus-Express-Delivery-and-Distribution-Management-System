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
import com.alibaba.fastjson.JSONArray;

import database.Login;
import dispatch.ReceivingProcess;


/**
 * Servlet implementation class sign
 */
@WebServlet("/sign")
public class sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("进入");
		request.setCharacterEncoding("UTF-8");
		
		
		Login su = new Login("superuser","1234567");
		su.login();
		ArrayList<ArrayList> l = su.select("dispatch,express","express.expressNumber,recipientName,dispatch.recipientTel,submissionTime,status","express.expressNumber=dispatch.expressNumber and status='已签收'");
		//获取派件表中关于签收录入的部分
		
		ArrayList<result>lr=(ArrayList<result>)new ArrayList();
		for(int i=0;i<l.size();i++) {
			lr.add(new result(l.get(i).get(0).toString(),l.get(i).get(1).toString(),l.get(i).get(2).toString(),
					l.get(i).get(3).toString(),l.get(i).get(4).toString()));
		}
		
		
	        //查询
	        if(request.getParameter("danhao")!=null) {
	        String c = request.getParameter("danhao"); 
	        ArrayList<result>lr1=(ArrayList<result>)new ArrayList();
	        System.out.println(c);
	       
	        for(int i=0;i<lr.size();i++) {
	        	if (lr.get(i).a.trim().contentEquals(c)) {
	        		System.out.println(lr.get(i).a.trim()+","+c);
	        		lr1.add(lr.get(i));
	        	}
	        }
	        String jsonStringrr1 = JSON.toJSONString(lr1);
	        HttpSession session = request.getSession();
	        session.setAttribute("num1",""+1);				
			 session.setAttribute("array1",jsonStringrr1);
			 RequestDispatcher dispatcher1 = request.getRequestDispatcher("/sign_r.jsp");
		        dispatcher1.forward(request, response);
	        }else {
	        	//System.out.println("no");
	        	//删除
	        if(request.getParameter("param1")!=null) {
	        	System.out.println("y");
	        	String p1 = request.getParameter("param1"); 
	        	 for(int i=0;i<lr.size();i++) {
	        		 if (lr.get(i).a.trim().contentEquals(p1)) {
	        			 lr.remove(i);
	        		 }
	        		 
	        	 }
	        	
	        }
	        //新建
	        String expressNumber=request.getParameter("kuaididanhao");
	        System.out.println(expressNumber);
	        if(expressNumber!=null) {
	            String recipientName=request.getParameter("shoujianren");
	            String userID=request.getParameter("dianhua");
	            System.out.println(userID);
	            String expressCompany=request.getParameter("expressCompany");
	            Double weight=Double.parseDouble(request.getParameter("weight"));
	            String size=request.getParameter("size");
	            
	            try {
					ReceivingProcess.ExpressReceipt(su, expressNumber, expressCompany, userID, recipientName, weight, size, "已签收");
					ReceivingProcess.AssignDeliveryMethod(su, expressNumber, userID);
					ReceivingProcess.AssignDeliveryTime(su, expressNumber, userID);
	            } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            l = su.select("dispatch,express","express.expressNumber,recipientName,dispatch.recipientTel,submissionTime,status","express.expressNumber=dispatch.expressNumber and status='已签收'");
	    
	    		lr=(ArrayList<result>)new ArrayList();
	    		for(int i=0;i<l.size();i++) {
	    			lr.add(new result(l.get(i).get(0).toString(),l.get(i).get(1).toString(),l.get(i).get(2).toString(),
	    					l.get(i).get(3).toString(),l.get(i).get(4).toString()));
	    		}
	        	
	        }
	        String jsonStringrr = JSON.toJSONString(lr);
			 int num=lr.size();
			 HttpSession session = request.getSession();
			 session.setAttribute("num",""+num);				
			 session.setAttribute("array",jsonStringrr);
				//System.out.println(num);
				//System.out.println(jsonStringrr);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/sign.jsp");
		        dispatcher.forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
}

package servlet;

import java.io.IOException;
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
		
		//替换掉这个arraylist
		ArrayList<ArrayList<String>>l=new ArrayList<ArrayList<String>>();
		ArrayList<String>l1=new ArrayList();
		l1.add("aa");
		l1.add("a");
		l1.add("a");
		l1.add("a");
		ArrayList<String>l2=new ArrayList();
		l2.add("bb");
		l2.add("b");
		l2.add("b");
		l2.add("b");
		ArrayList<String>l3=new ArrayList();
		l3.add("cc");
		l3.add("c");
		l3.add("c");
		l3.add("c");
		
		l.add(l1);
		l.add(l2);
		l.add(l3);
		
		
		ArrayList<result>lr=(ArrayList<result>)new ArrayList();
		for(int i=0;i<l.size();i++) {
			lr.add(new result(l.get(i).get(0),l.get(i).get(1),l.get(i).get(2),l.get(i).get(3)));
		}
		
		
	        //查询
	        if(request.getParameter("danhao")!=null) {
	        String c = request.getParameter("danhao"); 
	        ArrayList<result>lr1=(ArrayList<result>)new ArrayList();
	        System.out.println(c);
	       
	        for(int i=0;i<lr.size();i++) {
	        	if (lr.get(i).a.contentEquals(c)) {
	        		
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
	        		 if (lr.get(i).a.contentEquals(p1)) {
	        			 lr.remove(i);
	        		 }
	        		 
	        	 }
	        	
	        }
	        String a1=request.getParameter("kuaididanhao");
	        System.out.println(request.getParameter(a1));
	        if(a1!=null) {
	        	
	        
	        String a2=request.getParameter("shoujianren");
	        String a3=request.getParameter("dianhua");
	        System.out.println(a1+a2+a3);
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

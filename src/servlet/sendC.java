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

/**
 * Servlet implementation class sendC
 */
@WebServlet("/sendC")
public class sendC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//替换掉这个arraylist
				ArrayList<ArrayList<String>>l=new ArrayList<ArrayList<String>>();
				ArrayList<String>l1=new ArrayList();
				l1.add("aa");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				l1.add("a");
				
				ArrayList<String>l2=new ArrayList();
				l2.add("bb");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				l2.add("b");
				
				ArrayList<String>l3=new ArrayList();
				l3.add("cc");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				l3.add("c");
				
				
				l.add(l1);
				l.add(l2);
				l.add(l3);
				
				
				ArrayList<result3>lr=(ArrayList<result3>)new ArrayList();
				for(int i=0;i<l.size();i++) {
					
					lr.add(new result3(l.get(i).get(0),l.get(i).get(1),l.get(i).get(2),l.get(i).get(3),l.get(i).get(4),l.get(i).get(5),l.get(i).get(6),l.get(i).get(7),l.get(i).get(8),l.get(i).get(9)));
				}
				
		
				String jsonStringrr = JSON.toJSONString(lr);
				 int num=lr.size();
		 HttpSession session = request.getSession();
		 session.setAttribute("num_sc",""+num);				
		 session.setAttribute("array_sc",jsonStringrr);
			//System.out.println(num);
			//System.out.println(jsonStringrr);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/send_client.jsp");
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

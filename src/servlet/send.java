package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//获得寄件的各项信息
		String sname=request.getParameter("sname");
		String sphone=request.getParameter("sphone");
		String sadress=request.getParameter("sadress");
		String rname=request.getParameter("rname");
		String rphone=request.getParameter("rphone");
		String radress=request.getParameter("radress");
		String kuaidi=request.getParameter("kuaidi");
		String weight=request.getParameter("weight");
		
		//测试传值是否正确，可删
		 System.out.println(sname);
		 System.out.println(sphone);
		 System.out.println(sadress);
		 System.out.println(rname);
		 System.out.println(rphone);
		 System.out.println(radress);
		 System.out.println(kuaidi);
		 System.out.println(weight);		
		HttpSession session = request.getSession();
		
		if(sname.contentEquals("1")&sphone.contentEquals("1")&sadress.contentEquals("1")&rname.contentEquals("1")&rphone.contentEquals("1")&radress.contentEquals("1")&kuaidi.contentEquals("1")&weight.contentEquals("1")) {
			
			 session.setAttribute("right","y");
			 System.out.println("yes");
			
		}
		else {
			session.setAttribute("right","n");	
			 System.out.println("no");
		}
		
		//应调用寄件方法把信息存入数据库
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/send.jsp");
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

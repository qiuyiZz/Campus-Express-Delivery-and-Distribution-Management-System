package servlet;

import java.io.IOException;
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
import post.PostProcess;

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
		request.setCharacterEncoding("utf-8");
		Login su = new Login("superuser","1234567");
		su.login();
		//获取登录用户信息
		HttpSession isession = request.getSession();
		String phone=(String) isession.getAttribute("userID");
		String name=(String) su.select("users", "userName", "userID='"+phone+"'").get(0).get(0);
		System.out.println(name);
		request.setAttribute("name",name);
		request.setAttribute("phone",phone);
		//获得寄件的各项信息
		String sname=request.getParameter("sname");
		String sphone=request.getParameter("sphone");
		String sadress=request.getParameter("sadress");
		String rname=request.getParameter("rname");
		String rphone=request.getParameter("rphone");
		String radress=request.getParameter("radress");
		String kuaidi=request.getParameter("kuaidi").replace("0", "圆通快递").replace("1", "中通快递").replace("2", "申通快递").replace("3", "韵达快递").replace("4", "百世快递"); //什么意思？？
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
		
		session.setAttribute("right","y");
		System.out.println("yes");
		/*
		if(1==1) {
			
			 session.setAttribute("right","y");
			 System.out.println("yes");
			
		}
		else {
			session.setAttribute("right","n");	
			 System.out.println("no");
		}
		*/
		
		//应调用寄件方法把信息存入数据库
		
		Integer randNum = (int)(Math.random()* (999999)+1);//生成取件码，产生(0,999999]之间的随机数
        String expressNumber = String.format("%06d",randNum);//对随机数前进行补0，确保为6位数。
		post.PostProcess.CreatePostParcel(su,expressNumber,kuaidi, sname, sphone, sadress, rname, rphone, radress,Double.parseDouble(weight)+1,weight.replace("0", "小").replace("1", "中").replace("2", "大").replace("3", "超大"));
		PostProcess.setStatus(su,expressNumber,"已代收");
		//没有获取快递单号,快递公司,快递体积区间
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

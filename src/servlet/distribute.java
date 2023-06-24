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
import problem.ProblemProcess;

/**
 * Servlet implementation class distribute
 */
@WebServlet("/distribute")
public class distribute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public distribute() {
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
		
		Login su = new Login("superuser","1234567");
		su.login();
		ArrayList<ArrayList> l = su.select("dispatch,express","dispatch.expressNumber,recipientName,"
				+ "dispatch.recipientTel,deliveryMethod,remindTime,actualDelivery,pickupTime,location,pickupCode,status","dispatch.expressNumber=express.expressNumber"); //获取派件表中的对应内容
		//ArrayList<ArrayList<String>>l=new ArrayList<ArrayList<String>>();
		
		ArrayList<result1>lr=(ArrayList<result1>)new ArrayList();
		System.out.println(l.size());
		for(int i=0;i<l.size();i++) {		
			lr.add(new result1(l.get(i).get(0).toString(),l.get(i).get(1).toString(),l.get(i).get(2).toString(),l.get(i).get(3).toString(),
					l.get(i).get(4).toString(),l.get(i).get(5).toString(),l.get(i).get(6).toString(),l.get(i).get(7).toString(),l.get(i).get(8).toString(),l.get(i).get(9).toString()));
		}//共需要10个属性
		
		//转为滞留，即从派件移动到问题件 此处不能直接删除，应调用方法！！
		//
		 if(request.getParameter("param2")!=null) {
	        	String p1 = request.getParameter("param2"); 
	        	System.out.println(p1+","+lr.get(0).a);
	        	for(int i=0;i<lr.size();i++) {
	        		 if (lr.get(i).a.trim().contentEquals(p1)) {
	        		//a指代快递单号
	        			//lr.remove(i);
	        			ArrayList<ArrayList> extra = su.select("express","expressCompany,weight,size","expressNumber="+p1) ;//获取上面没有获取的快递公司,质量,尺寸参数
	        			ArrayList<ArrayList> r=su.select("dispatch,express", "*", "status='已派送' and actualDelivery<getdate()-2 and express.expressNumber="+p1+" and express.expressNumber=dispatch.expressNumber");
	        			if(r.isEmpty())
	        				break;
	        			try {
							problem.ProblemProcess.CreateProblemParcel(su, lr.get(i).a,extra.get(0).get(0).toString(),lr.get(i).c,
									lr.get(i).b,Double.parseDouble(extra.get(0).get(1).toString()), extra.get(0).get(2).toString());
							ProblemProcess.setStatus(su,lr.get(i).a.trim(),"已滞留");
	        			} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//在数据库中加入问题件
	        			//System.out.print("滞留成功");
	        		 }
	        		 
	        	 }
	        	
	        }
		 String jsonStringrr = JSON.toJSONString(lr);
		 int num=lr.size();
			 HttpSession session = request.getSession();
			 session.setAttribute("num_d",""+num);				
			 session.setAttribute("array_d",jsonStringrr);
				//System.out.println(num);
				//System.out.println(jsonStringrr);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/distribute.jsp");
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

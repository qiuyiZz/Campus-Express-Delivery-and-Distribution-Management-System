

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Login;

/**
 * Servlet implementation class enter_grid
 */
@WebServlet("/enter_grid")
public class enter_grid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enter_grid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 这里所有定义的变量都需要在数据库找出来,替换掉我这里原来自己定义的值
		Integer totalfield=8; //总区域数
		Login su = new Login("superuser","1234567");
		su.login();
		//
		System.out.println(su.select("cabinet_details","count(*)",null).get(0).get(0).toString());
		Integer totalgrid=Integer.parseInt(su.select("cabinet_details","count(*)",null).get(0).get(0).toString()); //总快递柜数
		Integer totaloccupy=Integer.parseInt(su.select("cabinet_details","count(*)","isFull=1").get(0).get(0).toString());//已占用快递柜数
		Integer totalfree=totalgrid-totaloccupy;
		List<String> occupyList = new ArrayList<String>();//存储空闲快递柜列表
		ArrayList<ArrayList> r=su.select("cabinet_details","cabinetID","isFull=1");
		String id;
		for(int i=0;i<r.size();i++) {
			id=r.get(i).get(0).toString().trim().replace("区", "_").replace("号", "");
			occupyList.add(id);
		}
		request.setAttribute("totalfield",totalfield);
		request.setAttribute("totalgrid",totalgrid);
		request.setAttribute("totaloccupy",totaloccupy);
		request.setAttribute("totalfree",totalfree);
		request.setAttribute("occupyList",occupyList);
		System.out.println(totalgrid+","+totaloccupy);
		request.getRequestDispatcher("/space_gui.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

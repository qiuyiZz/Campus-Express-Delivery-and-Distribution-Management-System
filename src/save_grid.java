

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Login;
import dispatch.DeliveryProcess;

/**
 * Servlet implementation class save_grid
 */
@WebServlet("/save_grid")
public class save_grid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public save_grid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//���������
		String grid=request.getParameter("grid").replace("_", "��")+"��";
		String order=request.getParameter("order");
		System.out.println(grid+","+order);
		Login su = new Login("superuser","1234567");
		su.login();
		//
		String msg="";
		try {
			msg=DeliveryProcess.Delivery(su, order,"�����",grid);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		Integer totalfield=8; //��������
		//
		System.out.println(su.select("cabinet_details","count(*)",null).get(0).get(0).toString());
		Integer totalgrid=Integer.parseInt(su.select("cabinet_details","count(*)",null).get(0).get(0).toString()); //�ܿ�ݹ���
		Integer totaloccupy=Integer.parseInt(su.select("cabinet_details","count(*)","isFull=1").get(0).get(0).toString());//��ռ�ÿ�ݹ���
		Integer totalfree=totalgrid-totaloccupy;
		List<String> occupyList = new ArrayList<String>();//�洢���п�ݹ��б�
		ArrayList<ArrayList> r=su.select("cabinet_details","cabinetID","isFull=1");
		String id;
		for(int i=0;i<r.size();i++) {
			id=r.get(i).get(0).toString().trim().replace("��", "_").replace("��", "");
			occupyList.add(id);
		}
		//��ʽ��['1_2', '4_4', '4_5', '6_6', '6_7', '8_5', '8_6', '8_7', '8_8', '10_1', '10_2']
		
		request.setAttribute("totalfield",totalfield);
		request.setAttribute("totalgrid",totalgrid);
		request.setAttribute("totaloccupy",totaloccupy);
		request.setAttribute("totalfree",totalfree);
		request.setAttribute("occupyList",occupyList);

		request.getRequestDispatcher("space_gui.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//���������
		String shelf=request.getParameter("shelf").replace("_", "��")+"��";
		String order=request.getParameter("order");
		System.out.println(shelf+","+order);
		Login su = new Login("superuser","1234567");
		su.login();
		//
		String msg="";
		try {
			msg=DeliveryProcess.Delivery(su, order,"������",shelf);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		Integer totalfield=8; //�ܻ�����
		Integer totalgrid=100; //�Ѵ�������
		totalgrid=Integer.parseInt((String) su.select("shelf", "sum(expressNum)", null).get(0).get(0));
		request.setAttribute("totalfield",totalfield);
		request.setAttribute("totalgrid",totalgrid);
		request.getRequestDispatcher("/space_shelf.jsp").forward(request, response);
	}

}

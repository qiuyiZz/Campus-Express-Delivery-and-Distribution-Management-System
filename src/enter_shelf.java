

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
 * Servlet implementation class enter_shelf
 */
@WebServlet("/enter_shelf")
public class enter_shelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public enter_shelf() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer totalfield=8; //总货架区
		Integer totalgrid=100; //已存入快递数
		Login su = new Login("superuser","1234567");
		su.login();
		//
		totalgrid=Integer.parseInt((String) su.select("shelf", "sum(expressNum)", null).get(0).get(0));
		request.setAttribute("totalfield",totalfield);
		request.setAttribute("totalgrid",totalgrid);
		request.getRequestDispatcher("/space_shelf.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

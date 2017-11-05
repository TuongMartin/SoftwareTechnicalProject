package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import library.CheckLoginLibrary;
import model.dao.AreaDAO;
=======
import model.dao.AreaDAO;
import model.dao.CustomersDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380

/**
 * Servlet implementation class AdminManageSales
 */
public class AdminManageAreaRealEstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManageAreaRealEstate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
=======
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
		int page_curent = 1;
		AreaDAO areaDAO = new AreaDAO();
		int sum_news = areaDAO.countItem();
		int row_count = 2;
		int sum_page = (int) Math.ceil((float)sum_news/row_count);
		request.setAttribute("sum_page", sum_page);
		if(request.getParameter("p")!=null){
			page_curent = Integer.parseInt(request.getParameter("p"));
		}
		
		request.setAttribute("page_current", page_curent);
		int offset = (page_curent -1)*row_count;
		request.setAttribute("listKhuVuc", areaDAO.getItemPagition(offset,row_count));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/area/index.jsp");
		rd.forward(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomersDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminManageSales
 */
public class AdminManageCategoryRealEstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManageCategoryRealEstate() {
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
		int page_curent = 1;
		RealEstateDAO realestateDAO = new RealEstateDAO();
		int sum_news = realestateDAO.countItem();
		int row_count = 2;
		int sum_page = (int) Math.ceil((float)sum_news/row_count);
		request.setAttribute("sum_page", sum_page);
		if(request.getParameter("p")!=null){
			page_curent = Integer.parseInt(request.getParameter("p"));
		}
		
		request.setAttribute("page_current", page_curent);
		int offset = (page_curent -1)*row_count;
		request.setAttribute("listTheLoai", realestateDAO.getItemPagition(offset,row_count));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/realestate/index.jsp?actived=1");
		rd.forward(request, response);
	}

}

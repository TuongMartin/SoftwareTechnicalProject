package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.dao.ApartmentDAO;

/**
 * Servlet implementation class AdminManageSales
 */
public class AdminManageApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminManageApartment() {
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
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		int page_curent = 1;
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		int sum_news = apartmentDAO.countItem();
		int row_count = 5;
		int sum_page = (int) Math.ceil((float)sum_news/row_count);
		request.setAttribute("sum_page", sum_page);
		if(request.getParameter("p")!=null){
			page_curent = Integer.parseInt(request.getParameter("p"));
		}
		
		request.setAttribute("page_current", page_curent);
		int offset = (page_curent -1)*row_count;
		request.setAttribute("listApartments", apartmentDAO.getItemPagition(offset,row_count));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/apartment/index.jsp?actived=3");
		rd.forward(request, response);
	}

}

package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.ApartmentDAO;


@WebServlet("/listapartment")
public class PublicShowListCanHo extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	
	public PublicShowListCanHo(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		int currentPage = 1;
		int sumRecord = apartmentDAO.countItem();
		int rowItemEachPage = 3;
		int sumPage = (int) Math.ceil((float)sumRecord/rowItemEachPage);
		
		request.setAttribute("sumPage", sumPage);
		
		if(request.getParameter("page") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		request.setAttribute("currentPage", currentPage);
		int offset = (currentPage -1) * rowItemEachPage;
		
		request.setAttribute("listCanHo", apartmentDAO.getItemPagition(offset, rowItemEachPage));
		
		RequestDispatcher rd = request.getRequestDispatcher("/listings-list-with-sidebar.jsp");
		rd.forward(request, response);
	}
}


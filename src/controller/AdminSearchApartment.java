package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.RegularExpression;
import model.dao.ApartmentDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
public class AdminSearchApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchApartment() {
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
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		int idCanHo = 0;
		if(request.getParameter("idCanHo") != null) {
			if(RegularExpression.checkNumber(request.getParameter("idCanHo"))) {
				idCanHo = Integer.parseInt(request.getParameter("idCanHo"));
			}
		}
		String tenCanHo = new String(request.getParameter("tenCanHo").getBytes("ISO-8859-1"),"UTF-8");
		if(idCanHo != 0 || !"".equals(tenCanHo)) {
			if(apartmentDAO.searchApartment(idCanHo, tenCanHo) != null) {
				request.setAttribute("listApartments", apartmentDAO.searchApartment(idCanHo, tenCanHo));
				RequestDispatcher rd = request.getRequestDispatcher("/admin/apartment/index.jsp?actived=3");
				rd.forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/admin/manageApartments?msg=5");
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/manageApartments");
		}
		
	}

}

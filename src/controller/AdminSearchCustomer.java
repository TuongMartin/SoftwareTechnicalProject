package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.RegularExpression;
import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
public class AdminSearchCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchCustomer() {
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
		CustomersDAO customerDAO = new CustomersDAO();
		int idKH = 0;
		if(request.getParameter("idCustomer") != null) {
			if(RegularExpression.checkNumber(request.getParameter("idCustomer"))) {
				idKH = Integer.parseInt(request.getParameter("idCustomer"));
			}
		}
		String tenKH = new String(request.getParameter("full_name").getBytes("ISO-8859-1"),"UTF-8");
		if(idKH != 0 || !"".equals(tenKH)) {
			if(customerDAO.searchCustomer(idKH, tenKH) != null) {
				request.setAttribute("listCustomers", customerDAO.searchCustomer(idKH, tenKH));
				RequestDispatcher rd = request.getRequestDispatcher("/admin/customers/index.jsp?actived=4");
				rd.forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/admin/manageCustomers?msg=5");
			}
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/manageCustomers");
		}
		
	}

}

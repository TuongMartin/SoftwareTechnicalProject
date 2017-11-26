package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
public class PublicConfirmNewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicConfirmNewCustomer() {
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
		String token = request.getParameter("token");
		String email = request.getParameter("email");
		CustomersDAO customerDAO = new CustomersDAO();
		if(customerDAO.checkConfirmAccount(token, email)) {
			if(customerDAO.confirmAccount(email) > 0) {
				response.sendRedirect(request.getContextPath() + "/public/register?msg=3");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/public/register?msg=0");
			}
		}
		else {
			response.sendRedirect(request.getContextPath() + "/public/register?msg=4");
		}
	}

}

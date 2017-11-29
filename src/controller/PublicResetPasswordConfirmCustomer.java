package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.BCrypt;
import model.bean.KhachHang;
import model.dao.CustomersDAO;


/**
 * Servlet implementation class ControllerAdminLogin
 */
//@WebServlet("/ControllerAdminLogin")
public class PublicResetPasswordConfirmCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicResetPasswordConfirmCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomersDAO customerDAO = new CustomersDAO();
		HttpSession session = request.getSession();
		String token = request.getParameter("token");
		String email = request.getParameter("email");
		KhachHang objKHReset = customerDAO.getItemCustomerByEmail(email);
		
		if(request.getParameter("submit") != null ){
			String password = request.getParameter("password");
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
			if(customerDAO.checkConfirmAccount(token, email)) {
				if(customerDAO.resetPassword(email, hashed) > 0) {
					response.sendRedirect(request.getContextPath() + "/public/login?msg=7");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/public/reset-password-confirm?msg=0");
				}
			}
			else {
				response.sendRedirect(request.getContextPath() + "/public/reset-password-confirm?msg=0");
			}
		}
		else{
			request.setAttribute("objKHReset", objKHReset);
			RequestDispatcher rd = request.getRequestDispatcher("/reset-password-confirm.jsp");
			rd.forward(request, response);
		}
	}

}

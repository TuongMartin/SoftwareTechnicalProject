package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.BCrypt;
import library.SendMail;
import model.bean.KhachHang;
import model.dao.CustomersDAO;


/**
 * Servlet implementation class ControllerAdminLogin
 */
//@WebServlet("/ControllerAdminLogin")
public class PublicResetPasswordCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicResetPasswordCustomer() {
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
		
		if(request.getParameter("submit") != null ){
			String email = request.getParameter("email");
			KhachHang objKHReset = customerDAO.getItemCustomerByEmail(email);
			if(objKHReset != null) {
				SendMail mail = new SendMail();
				String content = "<html>"
								+ "<body>" 
								+ "<h3>You have request to reset your password, please click on the link to reset your password!</h3><br>"
								+ "<a href=" + "http://localhost:8080/SoftwareTechnicalProject/public/reset-password-confirm?email=" + objKHReset.getEmail() +"&token=" + objKHReset.getToken() + ">" + objKHReset.getToken() +"</a><br>"
								+ "</body>"
								+ "</html>";
				mail.sendMail(objKHReset.getEmail(), "Reset password!", content);
				response.sendRedirect(request.getContextPath() + "/public/reset-password?msg=1");
			} else {
				response.sendRedirect(request.getContextPath() + "/public/reset-password?msg=0");
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/reset-password.jsp");
			rd.forward(request, response);
		}
	}

}

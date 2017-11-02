package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;

import library.FileNameLibrary;
import library.RandomStringGenerator;
import library.RenameFileLibrary;
import library.SendMail;
import model.bean.KhachHang;
import model.bean.NhanVien;
import model.dao.CustomersDAO;
import model.dao.SalesDAO;

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

package controller;

import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
=======

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.BCrypt;
<<<<<<< HEAD
import model.bean.Account;
import model.bean.KhachHang;
import model.dao.AccountDAO;
import model.dao.CustomersDAO;
import model.dao.SalesDAO;
=======
import model.bean.KhachHang;
import model.dao.CustomersDAO;
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380


/**
 * Servlet implementation class ControllerAdminLogin
 */
//@WebServlet("/ControllerAdminLogin")
public class PublicLoginCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicLoginCustomer() {
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
<<<<<<< HEAD
		AccountDAO accountDAO = new AccountDAO();
=======
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
		HttpSession session = request.getSession();
		
		if(request.getParameter("submit") != null ){
			String email = request.getParameter("email");
			String password = request.getParameter("password");
<<<<<<< HEAD
			boolean check = false;
			Account obj = null;
			
			//check account is the member of system ? 
			ArrayList<Account> listAccount = accountDAO.getlist();
			for (Account account : listAccount) {
				if(email.equals(account.getUsername()) && BCrypt.checkpw(password, account.getPassword())){
					obj = new Account(account.getId(), email, account.getPassword(), account.getIdrole(), account.getrole(), account.getIdNhanVien(), account.getTenNhanVien());
					check = true;
					break;
				}
			}
			if(check) {
				SalesDAO salesDAO = new SalesDAO();
				request.getSession().setAttribute("userInfo", salesDAO.getItemSale(obj.getIdNhanVien()));
				request.setAttribute("objSale", salesDAO.getItemSale(obj.getIdNhanVien()));
				RequestDispatcher rd = request.getRequestDispatcher("/admin/sales/edit.jsp");
				rd.forward(request, response);
			} else {
				//Account's Client.
				KhachHang objKH = customerDAO.login(email);
				if(objKH != null && BCrypt.checkpw(password, objKH.getMatKhau()) && objKH.getStatus() == 1){
					//đăng nhập đúng
					//TẠO SESSION
					session.setAttribute("sObjKH", objKH);
					//chuyển hướng
					response.sendRedirect(request.getContextPath() + "/public/home");
				}
				else if(objKH != null && objKH.getStatus() == 0){
					response.sendRedirect(request.getContextPath() + "/public/login?msg=5");
				}
				else{
					response.sendRedirect(request.getContextPath() + "/public/login?msg=6");
				}
=======
			KhachHang objKH = customerDAO.login(email);
			if(objKH != null && BCrypt.checkpw(password, objKH.getMatKhau()) && objKH.getStatus() == 1){
				//đăng nhập đúng
				//TẠO SESSION
				session.setAttribute("sObjKH", objKH);
				//chuyển hướng
				response.sendRedirect(request.getContextPath() + "/public/home");
			}
			else if(objKH != null && objKH.getStatus() == 0){
				response.sendRedirect(request.getContextPath() + "/public/login?msg=5");
			}
			else{
				response.sendRedirect(request.getContextPath() + "/public/login?msg=6");
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/login-register.jsp");
			rd.forward(request, response);
		}
	}

}

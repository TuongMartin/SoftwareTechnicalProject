package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.BCrypt;
import library.CheckLoginLibrary;
import model.bean.Account;
import model.bean.NhanVien;
import model.bean.Role;
import model.dao.AccountDAO;
import model.dao.RoleDAO;
import model.dao.SalesDAO;


/**
 * Servlet implementation class AdminAddAccount
 */
@WebServlet("/AdminAddAccount")
public class AdminAddAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		// TODO Auto-generated method stub
		RoleDAO model = new RoleDAO();
		AccountDAO modelAccount = new AccountDAO();
		SalesDAO modelSale = new SalesDAO();
		
		ArrayList<Role> roles = new ArrayList<Role>();
		ArrayList<NhanVien> nhanviens = new ArrayList<NhanVien>();

		roles = model.roles();
		nhanviens = modelSale.getListUser();
	
		request.setAttribute("roles", roles);
		request.setAttribute("nhanviens", nhanviens);
		
		if(request.getParameter("submit")!=null){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String hashed = BCrypt.hashpw(password, BCrypt.gensalt(10));
			int idrole = Integer.parseInt(request.getParameter("idroler"));
			int idNhanVien = Integer.parseInt(request.getParameter("idNhanVien"));
			
			Account tam = new Account(1,username,hashed,idrole,"",idNhanVien,"");
			
			if(modelAccount.checkusername(username)){
				response.sendRedirect(request.getContextPath() + "/admin/accounts?msg=4");
				return;
			}else{
				if(modelAccount.addaccount(tam)) {
					response.sendRedirect(request.getContextPath() + "/admin/accounts?msg=5");
					return;
				}else {
					response.sendRedirect(request.getContextPath() + "/admin/accounts?msg=6");
					return;
				}			
			}			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/account/AccountAdd.jsp?active=7");
			rd.forward(request, response);
		}
		
	}

}
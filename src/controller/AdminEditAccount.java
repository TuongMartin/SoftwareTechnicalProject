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
import model.bean.Role;
import model.dao.AccountDAO;
import model.dao.RoleDAO;

/**
 * Servlet implementation class AdminEditAccount
 */
@WebServlet("/AdminEditAccount")
public class AdminEditAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditAccount() {
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
		ArrayList<Role> roles = new ArrayList<Role>();

		roles = model.roles();
		int id = 0;
		if(request.getParameter("id")!=null) {
			id=Integer.parseInt(request.getParameter("id"));
		}
		
		Account ojAccount = modelAccount.getAccountById(id);
	
		request.setAttribute("roles", roles);
		request.setAttribute("ojAccount", ojAccount);
		
		if(request.getParameter("submit")!=null){
			
			int idrole = Integer.parseInt(request.getParameter("idroler"));
			
			if(request.getParameter("password")!=null) {
				
				String password = request.getParameter("password");
				String hashed = BCrypt.hashpw(password, BCrypt.gensalt(10));
				
				
				if(modelAccount.updateAccount(id, hashed, idrole)) {
					response.sendRedirect(request.getContextPath() + "/admin/updateaccount?id="+id+"&&msg=1");
					return;
				}else {
					response.sendRedirect(request.getContextPath() + "/admin/updateaccount?id="+id+"&&msg=2");
					return;
				}		
			}else {
				if(modelAccount.updateRole(id, idrole)) {
					response.sendRedirect(request.getContextPath() + "/admin/updateaccount?id="+id+"&&msg=1");
					return;
				}else {
					response.sendRedirect(request.getContextPath() + "/admin/updateaccount?id="+id+"&&msg=2");
					return;
				}		
			}
						
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/account/AccountUpdate.jsp");
			rd.forward(request, response);
		}
	}

}

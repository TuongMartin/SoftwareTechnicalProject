package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.bean.Account;
import model.dao.AccountDAO;
import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminShowAccount
 */
@WebServlet("/AdminShowAccount")
public class AdminShowAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowAccount() {
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
		int page_curent = 1;
		AccountDAO model = new AccountDAO();
		int soAccount = model.numAccount();
		int row_count = 5;
		int sum_page = (int) Math.ceil((float)soAccount/row_count);
		request.setAttribute("sum_page", sum_page);
		if(request.getParameter("p")!=null){
			page_curent = Integer.parseInt(request.getParameter("p"));
		}
		
		request.setAttribute("page_current", page_curent);
		int offset = (page_curent -1)*row_count;
		request.setAttribute("Accounts", model.getlist(offset, row_count));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/account/AccountIndex.jsp?actived=7");
		rd.forward(request, response);
	}

}
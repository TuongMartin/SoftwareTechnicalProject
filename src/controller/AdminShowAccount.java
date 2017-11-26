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
		// TODO Auto-generated method stub
		int maxitem = 20;
		AccountDAO model = new AccountDAO();
		if(request.getParameter("key")!=null||request.getParameter("Timkiem")!=null){
			String str="";
			if(request.getParameter("keysearch")!=null){
				str = new String(request.getParameter("keysearch").getBytes("ISO-8859-1"),"UTF-8");
			}else{
				if(request.getParameter("key")!=null){
					str = new String(request.getParameter("key").getBytes("ISO-8859-1"),"UTF-8");
				}
			}
			int soAccount = model.numsearch(str);
			int numberpage= (int)Math.ceil((float)soAccount/maxitem);
			int currentpage;
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			int startpage = (currentpage - 1)*maxitem;	
			ArrayList<Account> Accounts = model.getlistsearch(str, startpage, maxitem);	
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("Accounts", Accounts);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/account/AccountIndex.jsp");
			rd.forward(request, response);
					
		}else{				
			int soAccount = model.numAccount();
			int numberpage= (int)Math.ceil((float)soAccount/maxitem);
			int currentpage;
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			int startpage = (currentpage - 1)*maxitem;			
			ArrayList<Account> Accounts = model.getlist(startpage, maxitem);	
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("Accounts", Accounts);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/account/AccountIndex.jsp");
			rd.forward(request, response);
		}
	}

}

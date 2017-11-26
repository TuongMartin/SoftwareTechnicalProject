package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.bean.KhachHang;
import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminActiveCustomer
 */
//@WebServlet("/AdminActiveCustomer")
public class AdminActiveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminActiveCustomer() {
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
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		int cid = Integer.parseInt(request.getParameter("acid"));
		int status = Integer.parseInt(request.getParameter("astatus"));
		
		CustomersDAO customerDAO = new CustomersDAO();
		
		String result = "";
		String kichhoat = "";
		String image = "";
		if(status == 0){
			kichhoat = "Ngừng kích hoạt";
			image="<img width=\"30\" height=\"30\" src=\""+request.getContextPath()+"/templates/admin/img/tick-circle.gif\" alt=\"\">";
		}
		else{
			kichhoat = "Kích hoạt";
			image="<img width=\"30\" height=\"30\" src=\""+request.getContextPath()+"/templates/admin/img/minus-circle.gif\" alt=\"\">";
		}
		
		customerDAO.updateCustomerStatus(cid,status);
		KhachHang objCustomer = customerDAO.getItemCustomerById(cid);
		result = "<a href=\"javascript:void(0)\"" 
				+ " onclick=\"return setActive(" + objCustomer.getId() + "," + objCustomer.getStatus() + ")\" title=\"" 
				+ kichhoat + "\">" 
				+ image + "</a>";
		response.getWriter().println(result);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CanHo;
import model.bean.KhachHang;
import model.dao.ApartmentDAO;
import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminActiveCustomer
 */
//@WebServlet("/AdminActiveCustomer")
public class AdminActiveApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminActiveApartment() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		int aid = Integer.parseInt(request.getParameter("aaid"));
		int status = Integer.parseInt(request.getParameter("astatus"));
		
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		
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
		
		apartmentDAO.updateApartmentStatus(aid,status);
		CanHo objCanHo = apartmentDAO.getItemApartmentByIdActive(aid);
		result = "<a href=\"javascript:void(0)\"" 
				+ " onclick=\"return setActive(" + objCanHo.getId() + "," + objCanHo.getKichHoat() + ")\" title=\"" 
				+ kichhoat + "\">" 
				+ image + "</a>";
		response.getWriter().println(result);
	}

}

package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ApartmentDAO;
import model.dao.CustomersDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminDelRealEstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelRealEstate() {
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
		int rid = Integer.parseInt(request.getParameter("id"));
		RealEstateDAO realestateDAO = new RealEstateDAO();
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		if(realestateDAO.delItemRealEstate(rid)) {
			apartmentDAO.delApartmentByIDRealEstate(rid);
			response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=3");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=0");
		}
	}

}

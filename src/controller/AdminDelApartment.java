package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.dao.ApartmentDAO;
import model.dao.FeatureApartmentDAO;
import model.dao.ImageDAO;

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminDelApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelApartment() {
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
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		int aid = Integer.parseInt(request.getParameter("id"));
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		FeatureApartmentDAO feature_apartmentDAO = new FeatureApartmentDAO();
		ImageDAO imageDAO = new ImageDAO();
		if(apartmentDAO.delItemApartment(aid)) {
			imageDAO.delItemImageByIdApartment(aid);
			feature_apartmentDAO.delItemFeatureByIdApartment(aid);
			response.sendRedirect(request.getContextPath() + "/admin/manageApartments?msg=3");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/manageApartments?msg=0");
		}
	}

}

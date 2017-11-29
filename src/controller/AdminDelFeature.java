package controller;

<<<<<<< HEAD
=======
import java.io.File;
>>>>>>> master
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import model.dao.FeatureApartmentDAO;
import model.dao.FeatureDAO;
=======
import model.dao.ApartmentDAO;
import model.dao.CustomersDAO;
import model.dao.FeatureApartmentDAO;
import model.dao.FeatureDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;
>>>>>>> master

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminDelFeature extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelFeature() {
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
		int fid = Integer.parseInt(request.getParameter("id"));
		FeatureDAO featureDAO = new FeatureDAO();
		FeatureApartmentDAO feature_apartmentDAO = new FeatureApartmentDAO();
		if(featureDAO.delItemFeature(fid)) {
			feature_apartmentDAO.delFeatureApartmentByIDFeature(fid);
			response.sendRedirect(request.getContextPath() + "/admin/feature-apartment?msg=3");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/feature-apartment?msg=0");
		}
	}

}

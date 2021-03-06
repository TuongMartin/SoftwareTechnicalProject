package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ApartmentDAO;
import library.CheckLoginLibrary;
import model.dao.AreaDAO;

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminDelAreaRealEstate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelAreaRealEstate() {
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
		AreaDAO areaDAO = new AreaDAO();
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		if(areaDAO.delItemAreaRealEstate(aid)) {
			apartmentDAO.delApartmentByIDArea(aid);
			response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=3");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=0");
		}
	}

}

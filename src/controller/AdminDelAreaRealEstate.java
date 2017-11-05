package controller;

<<<<<<< HEAD
=======
import java.io.File;
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import library.CheckLoginLibrary;
import model.dao.AreaDAO;
=======
import model.dao.AreaDAO;
import model.dao.CustomersDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380

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
<<<<<<< HEAD
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
=======
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
		int aid = Integer.parseInt(request.getParameter("id"));
		AreaDAO areaDAO = new AreaDAO();
		if(areaDAO.delItemAreaRealEstate(aid)) {
			response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=3");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=0");
		}
	}

}

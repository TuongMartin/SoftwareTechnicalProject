package controller;

<<<<<<< HEAD
import java.io.IOException;
=======
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
>>>>>>> master

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import model.bean.TienIch;
import model.dao.FeatureDAO;
=======
import javax.servlet.http.Part;

import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.NhanVien;
import model.bean.TheLoaiBDS;
import model.bean.TienIch;
import model.dao.FeatureDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;
>>>>>>> master

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminAddNewFeature extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddNewFeature() {
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
		FeatureDAO featureDAO = new FeatureDAO();
		if(request.getParameter("submit") != null) {
			String tienich = new String(request.getParameter("tienich").getBytes("ISO-8859-1"),"UTF-8");
			if(featureDAO.getItemFeatureByName(tienich) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/addFeature?msg=2");
			}
			else {
				TienIch objTienIch = new TienIch(0, tienich);
				if(featureDAO.addItemFeature(objTienIch)) {
					response.sendRedirect(request.getContextPath() + "/admin/feature-apartment?msg=1");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/AdminAddNewFeature?msg=0");
				}
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/features/add.jsp?actived=6");
			rd.forward(request, response);
		}
	}

}

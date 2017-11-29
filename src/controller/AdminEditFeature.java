package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TienIch;
import model.dao.FeatureDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminEditFeature extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditFeature() {
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
		int fid = Integer.parseInt(request.getParameter("id"));
		TienIch objTienIchUpdate = featureDAO.getItemFeatureById(fid);
		if(request.getParameter("submit") != null) {
			String tienich = new String(request.getParameter("tienich").getBytes("ISO-8859-1"),"UTF-8");
			if(featureDAO.getItemFeatureByNameEdit(tienich, fid) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/editFeature?id=" + fid + "&msg=2");
			}
			else {
				TienIch objTienIch = new TienIch(fid, tienich);
				if(featureDAO.editItemFeature(objTienIch)) {
					response.sendRedirect(request.getContextPath() + "/admin/feature-apartment?msg=2");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/feature-apartment?msg=0");
				}
			}
		}
		else {
			request.setAttribute("objTienIchUpdate", objTienIchUpdate);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/features/edit.jsp?actived=6");
			rd.forward(request, response);
		}
	}

}

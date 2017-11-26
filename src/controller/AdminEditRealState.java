package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.bean.TheLoaiBDS;
import model.dao.RealEstateDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
public class AdminEditRealState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditRealState() {
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
		RealEstateDAO realestateDAO = new RealEstateDAO();
		int rid = Integer.parseInt(request.getParameter("id"));
		TheLoaiBDS objTheLoaiUpdate = realestateDAO.getItemRealEstateByid(rid);
		if(request.getParameter("submit") != null) {
			String theloai = new String(request.getParameter("realestate").getBytes("ISO-8859-1"),"UTF-8");
			if(realestateDAO.getItemRealEstatebyName(theloai) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/editRealEstate?id=" + rid + "&msg=2");
			}
			else {
				TheLoaiBDS objTheLoai = new TheLoaiBDS(rid, theloai);
				if(realestateDAO.editItemRealEstate(objTheLoai)) {
					response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=2");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=0");
				}
			}
		}
		else {
			request.setAttribute("objTheLoaiUpdate", objTheLoaiUpdate);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/realestate/edit.jsp");
			rd.forward(request, response);
		}
	}

}

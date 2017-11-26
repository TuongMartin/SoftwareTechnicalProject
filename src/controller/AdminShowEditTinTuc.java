package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import model.dao.TheLoaiTinTucDAO;
import model.dao.TinTucDAO;
import model.bean.TheLoaiTinTuc;
import model.bean.TinTuc;;


@WebServlet(urlPatterns = { "/ShowEditTT" })
public class AdminShowEditTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public AdminShowEditTinTuc(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tinTucDAO = new TinTucDAO();
		TheLoaiTinTucDAO theLoaiTinTucDAO = new TheLoaiTinTucDAO();
		
		ArrayList<TheLoaiTinTuc> listLoaiTinTuc = theLoaiTinTucDAO.getLoaiTinTuc();
		request.setAttribute("listLoaiTinTuc", listLoaiTinTuc);
		
		String id = request.getParameter("id");
		
		if(id != null)
		{
			TinTuc objTinTuc = tinTucDAO.getItemTinTuc(id);
			int idPhanLoaiTinTuc = tinTucDAO.getIdPhanLoaiTinTuc(objTinTuc.getIdTinTuc());
			
			request.setAttribute("objTinTuc", objTinTuc);
			request.setAttribute("idLoaiTinTuc", idPhanLoaiTinTuc);
		}
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/Article/edit.jsp");
		dispatcher.forward(request, response);
	}
}


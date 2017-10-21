package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.TuVanDAO;


public class NhanVienShowNhatKyTuVan{
	
	private static final long serialVersionUID = 1L;
	
	
	public NhanVienShowNhatKyTuVan(){
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/NhatKyTuVan.jsp");
		rd.forward(request, response);
	}
}


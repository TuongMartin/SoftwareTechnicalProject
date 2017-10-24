package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.TinTucDAO;
import model.bean.TinTuc;


@WebServlet(urlPatterns = { "/ShowChiTietTinTuc" })
public class ChiTietTinTucController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public ChiTietTinTucController(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idTinTuc = request.getParameter("idTinTuc");
		TinTuc objTinTuc= null;
		
		if(idTinTuc != null)
		{
			TinTucDAO tintucDAO = new TinTucDAO();
			objTinTuc = tintucDAO.getItemTinTuc(idTinTuc);
		}
		
		request.setAttribute("objTinTuc", objTinTuc);
		
		RequestDispatcher rd = request.getRequestDispatcher("blog-post.jsp");
		rd.forward(request, response);
	}
}


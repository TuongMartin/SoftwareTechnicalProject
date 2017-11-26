package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import model.bean.TinTuc;
import model.dao.TinTucDAO;


@WebServlet(urlPatterns = { "/SearchTT" })
public class SearchTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public SearchTinTuc(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tinTucDAO = new TinTucDAO();
		ArrayList<TinTuc> listSearch = null;
		String search = new String(request.getParameter("search"));
		
		if(!search.equals(""))
		{
			listSearch = tinTucDAO.searchTinTuc(search);
		}

		request.setAttribute("listTinTuc", listSearch);
		RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
		rd.forward(request, response);
	}
}


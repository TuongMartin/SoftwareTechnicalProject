package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.TinTucDAO;


@WebServlet(urlPatterns = { "/ShowTinTuc" })
public class ShowTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final int NUMBER_POPULAR_ITEM_NEED = 3;
	
	
	public ShowTinTuc(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tintuc = new TinTucDAO();
		int currentPage = 1;
		int sumRecord = tintuc.countRecordTinTuc();
		int rowItemEachPage = 3;
		int sumPage = (int) Math.ceil((float)sumRecord/rowItemEachPage);
		
		request.setAttribute("sumPage", sumPage);
		
		if(request.getParameter("page") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		request.setAttribute("currentPage", currentPage);
		int offset = (currentPage -1) * rowItemEachPage;
		
		request.setAttribute("listTinTuc", tintuc.getListTinTucEachPage(offset,rowItemEachPage));
		request.setAttribute("listPopular", tintuc.getListPopularItems(NUMBER_POPULAR_ITEM_NEED));
		
		RequestDispatcher rd = request.getRequestDispatcher("blog.jsp");
		rd.forward(request, response);
	}
}


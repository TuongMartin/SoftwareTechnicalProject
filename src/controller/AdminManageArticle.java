package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.TinTucDAO;


@WebServlet(urlPatterns = { "/AdminShowManageTinTuc" })
public class AdminManageArticle extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public AdminManageArticle(){
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
		int rowItemEachPage = 5;
		int sumPage = (int) Math.ceil((float)sumRecord/rowItemEachPage);
		
<<<<<<< HEAD
		request.setAttribute("sumPage", sumPage);
		
=======
>>>>>>> master
		if(request.getParameter("page") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
<<<<<<< HEAD
=======
		request.setAttribute("sumPage", sumPage);
>>>>>>> master
		request.setAttribute("currentPage", currentPage);
		int offset = (currentPage -1) * rowItemEachPage;
		request.setAttribute("listArticle", tintuc.getListTinTucEachPage(offset,rowItemEachPage));
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/Article/articles.jsp");
		rd.forward(request, response);
	}
}


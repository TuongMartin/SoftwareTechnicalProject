package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.TinTuc;
import model.dao.TinTucDAO;

@WebServlet(urlPatterns = { "/AdminSearchTinTuc" })
public class AdminSearchTinTuc extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
    public AdminSearchTinTuc() {
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
		String searchKey = new String(request.getParameter("search"));
		
		int currentPage = 1;
		int rowItemEachPage = 3;
		int sumRecordFinded = 0;

		if(!searchKey.equals(""))
		{
			sumRecordFinded = tinTucDAO.countTinTucFind(searchKey);
		}
		
		if(request.getParameter("page") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		int offset = (currentPage -1) * rowItemEachPage;
		int sumPage = (int) Math.ceil((float)sumRecordFinded/rowItemEachPage);
		
		if(!searchKey.equals(""))
		{
			listSearch = tinTucDAO.searchTinTuc(searchKey, offset, rowItemEachPage);
		}

		request.setAttribute("currentPage", currentPage);
		request.setAttribute("sumPage", sumPage);
		request.setAttribute("listArticle", listSearch);
		request.setAttribute("search", searchKey);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/Article/articles.jsp");
		rd.forward(request, response);
	}

}

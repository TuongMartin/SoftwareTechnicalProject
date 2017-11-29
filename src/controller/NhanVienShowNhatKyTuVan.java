package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.TuVanDAO;


@WebServlet(urlPatterns = { "/ShowNKTV" })
public class NhanVienShowNhatKyTuVan extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public NhanVienShowNhatKyTuVan(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TuVanDAO tuVan = new TuVanDAO();
		int currentPage = 1;
		int sumRecord = tuVan.countRecordNhatKyTuVan();
		int rowItemEachPage = 5;
		int sumPage = (int) Math.ceil((float)sumRecord/rowItemEachPage);
		
		request.setAttribute("sumPage", sumPage);
		
		if(request.getParameter("page") != null)
		{
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		
		request.setAttribute("currentPage", currentPage);
		int offset = (currentPage -1) * rowItemEachPage;
		request.setAttribute("listNoiDung", tuVan.getListNoiDungTuVanEachPage(offset,rowItemEachPage));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/NhatKyTuVan.jsp?actived=3");
		rd.forward(request, response);
	}
}
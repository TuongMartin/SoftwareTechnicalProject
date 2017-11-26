package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.dao.TinTucDAO;


@WebServlet(urlPatterns = { "/DelTT" })
public class AdminDelTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public AdminDelTinTuc(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tinTucDAO = new TinTucDAO();
		String messageStr = null;
		int idTinTuc = Integer.parseInt(request.getParameter("id").toString());
		
		if(tinTucDAO.checkDelItemTinTuc(idTinTuc))
		{
			messageStr = "Xóa Thành Công";
		}
		else
		{
			messageStr = "Có Lỗi Xảy Ra";
		}
		
		request.setAttribute("messageStr", messageStr);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/AdminShowManageTinTuc");
		dispatcher.forward(request, response);
	}
}


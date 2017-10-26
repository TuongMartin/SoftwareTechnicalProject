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


@WebServlet(urlPatterns = { "/addTinTuc" })
public class AdminAddTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public AdminAddTinTuc(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TheLoaiTinTucDAO theLoaiTinTucDAO = new TheLoaiTinTucDAO();
		ArrayList<TheLoaiTinTuc> listLoaiTinTuc = theLoaiTinTucDAO.getLoaiTinTuc();
		request.setAttribute("listLoaiTinTuc", listLoaiTinTuc);
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/Article/add.jsp");
		dispatcher.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TheLoaiTinTucDAO theLoaiTinTucDAO = new TheLoaiTinTucDAO();
		ArrayList<TheLoaiTinTuc> listLoaiTinTuc = theLoaiTinTucDAO.getLoaiTinTuc();
		request.setAttribute("listLoaiTinTuc", listLoaiTinTuc);
		
		TinTucDAO tinTucDAO = new TinTucDAO();
		String messageStr = null;
		
		String tieuDe = new String(request.getParameter("TieuDe").getBytes("ISO-8859-1"),"UTF-8");
		String id = new String(request.getParameter("idLoaiTinTuc").getBytes("ISO-8859-1"),"UTF-8");
		String noiDung = new String(request.getParameter("noidungtintuc").getBytes("ISO-8859-1"),"UTF-8");
		String quote = new String(request.getParameter("quote").getBytes("ISO-8859-1"),"UTF-8");
		String urlHinhAnh = new String(request.getParameter("UrlHinhAnh").getBytes("ISO-8859-1"),"UTF-8");
		
		int idLoaiTinTuc = Integer.parseInt(id);
		
		Date date = new Date();
		java.sql.Date ngayDangTinTuc = new java.sql.Date(date.getTime());
		
		if(tieuDe.length() > 200)
		{
			messageStr = "Tiêu Đề Quá Dài";
		}
		else if(idLoaiTinTuc == 0)
		{
			messageStr = "Chưa Chọn Thể Loại Tin Tức";
		}
		else if(noiDung.trim() == null || noiDung.trim().length() == 0)
		{
			messageStr = "Chưa Nhập Nội Dung";
		}
		else if(quote.trim() == null || quote.trim().length() == 0 || quote.trim().length() > 500)
		{
			messageStr = "Chưa Nhập Trích Dẫn Hoặc Trích Dẫn Quá Dài";
		}
		else
		{
			TinTuc objTinTuc = new TinTuc(0, tieuDe, noiDung, quote, id, urlHinhAnh, ngayDangTinTuc);
			
			if(tinTucDAO.checkAddTinTuc(objTinTuc, idLoaiTinTuc))
			{
				messageStr = "Thêm Thành Công";
			}
			else
			{
				messageStr = "Có Lỗi Xảy Ra";
			}
		}
		
		request.setAttribute("messageStr", messageStr);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/Article/add.jsp");
		dispatcher.forward(request, response);
	}
}


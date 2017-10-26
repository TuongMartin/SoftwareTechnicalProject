package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import model.dao.TinTucDAO;
import model.bean.TinTuc;;


@WebServlet(urlPatterns = { "/EditTT" })
public class AdminEditTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public AdminEditTinTuc(){
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
		
		String tieuDe = new String(request.getParameter("TieuDe").getBytes("ISO-8859-1"),"UTF-8");
		String id = new String(request.getParameter("idLoaiTinTuc").getBytes("ISO-8859-1"),"UTF-8");
		String noiDung = new String(request.getParameter("noidungtintuc").getBytes("ISO-8859-1"),"UTF-8");
		String quote = new String(request.getParameter("quote").getBytes("ISO-8859-1"),"UTF-8");
		String urlHinhAnh = new String(request.getParameter("UrlHinhAnh").getBytes("ISO-8859-1"),"UTF-8");
		
		int idLoaiTinTuc = Integer.parseInt(id);
		int idTinTuc = Integer.parseInt(request.getParameter("idTT").toString());
		
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
			TinTuc objTinTuc = new TinTuc(idTinTuc, tieuDe, noiDung, quote, id, urlHinhAnh, ngayDangTinTuc);
			
			if(tinTucDAO.checkEditTinTuc(objTinTuc, idLoaiTinTuc))
			{
				messageStr = "Sửa Thành Công";
			}
			else
			{
				messageStr = "Có Lỗi Xảy Ra";
			}
		}
		
		request.setAttribute("messageStr", messageStr);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/AdminShowManageTinTuc");
		dispatcher.forward(request, response);
	}
}


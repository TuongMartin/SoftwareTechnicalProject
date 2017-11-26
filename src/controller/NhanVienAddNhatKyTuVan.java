package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckStringIsNumber;
import java.io.IOException;
import java.util.Date;
import model.dao.TuVanDAO;
import model.bean.TuVan;


@WebServlet(urlPatterns = { "/addNK" })
public class NhanVienAddNhatKyTuVan extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public NhanVienAddNhatKyTuVan(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/NhanVien/AddNhatKyTuVan.jsp?actived=3");
		dispatcher.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TuVanDAO tuVan = new TuVanDAO();
		CheckStringIsNumber checkStringIsNumber = new CheckStringIsNumber();
		String messageStr = null;
		
		int idNhanVien = 2; // will be update idNhanVien = getSession(); 
		String tenKhachHang = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String sdt = new String(request.getParameter("sdt"));
		String noidung = new String(request.getParameter("noidung").getBytes("ISO-8859-1"),"UTF-8");
		Date date = new Date();
		java.sql.Date ngayTuVan = new java.sql.Date(date.getTime());
		
		if(tenKhachHang == null || tenKhachHang.length() == 0 || tenKhachHang.length() > 50)
		{
			messageStr = "Chưa Nhập Tên Khách Hàng Hoặc Tên Khách Hàng Quá Dài";
		}
		else if(sdt == null || sdt.length() == 0 || sdt.length() > 20)
		{
			messageStr = "Chưa Nhập Số Điện Thoại Hoặc Số Điện Thoại Quá Dài";
		}
		else if(!checkStringIsNumber.isNumberString(sdt))
		{
			messageStr = "Số Điện Thoại Phải Lã Chữ Số";
		}
		else if(noidung.trim() == null || noidung.trim().length() == 0 || noidung.trim().length() > 2000)
		{
			messageStr = "Chưa Nhập Nội Dung hoặc Nội Dung Quá Dài";
		}
		else
		{
			TuVan objTuVan = new TuVan(idNhanVien, tenKhachHang, sdt, noidung, ngayTuVan);
			
			if(tuVan.checkAddNhatKyTuVan(objTuVan))
			{
				messageStr = "Thêm Thành Công";
			}
			else
			{
				messageStr = "Có Lỗi Xảy Ra";
			}
		}
		
		request.setAttribute("messageStr", messageStr);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/NhanVien/AddNhatKyTuVan.jsp?actived=3");
		dispatcher.forward(request, response);
	}
}
package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import model.bean.Khachhang;


@WebServlet(urlPatterns = { "/EditLKH" })
public class NhanVienEditLoaiKhachHang extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public NhanVienEditLoaiKhachHang(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String URLForward = (String) request.getAttribute("URLForward");
		String idLoaiKhachHang = (String) request.getAttribute("idLoaiKhachHang");
		Khachhang objKhachHang = (Khachhang) request.getAttribute("objKhachHang");
		
		if(objKhachHang != null)
		{
			// will be update later
		}

		RequestDispatcher rd = request.getRequestDispatcher(URLForward);
		rd.forward(request, response);
	}
}


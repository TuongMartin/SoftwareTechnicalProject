package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.CheckLoginLibrary;
import model.bean.KhachHang;
import model.bean.LoaiKhachHang;
import model.bean.NhanVien;
import model.dao.CustomersDAO;
import model.dao.LoaiKhachHangDAO;




/**
 * Servlet implementation class Controllerkhachhang
 */
@WebServlet("/Controllerkhachhang")
public class Controllerkhachhang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllerkhachhang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		HttpSession session = request.getSession();
		
		int idNhanVien = 0;
		
		if(session.getAttribute("userInfo")!=null){
    		NhanVien objNhanVien = (NhanVien) session.getAttribute("userInfo");	
    		idNhanVien = objNhanVien.getIdNhanVien();
		}
		
		int maxitem = 5;
		
		CustomersDAO model = new CustomersDAO();
		LoaiKhachHangDAO modelloaiKH = new LoaiKhachHangDAO();
		
		ArrayList<LoaiKhachHang> loaikhachhangs= modelloaiKH.loaikhachhangs();
		
		request.setAttribute("loaikhachhangs", loaikhachhangs);
		
		if(request.getParameter("key")!=null||request.getParameter("Timkiem")!=null){
			
			String str="";
			if(request.getParameter("keysearch")!=null){
				str = new String(request.getParameter("keysearch").getBytes("ISO-8859-1"),"UTF-8");
			}else{
				if(request.getParameter("key")!=null){
					str = new String(request.getParameter("key").getBytes("ISO-8859-1"),"UTF-8");
				}
			}
			
			int sokhachhang = model.searchkhcount(idNhanVien,str);
			int numberpage= (int)Math.ceil((float)sokhachhang/maxitem);
			int currentpage;
			
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			
			int startpage = (currentpage - 1)*maxitem;	
			ArrayList<KhachHang> khachhangs = model.searchkhachhang(idNhanVien,startpage,maxitem,str);
			
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("khachhangs", khachhangs);
			
			RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/khachhang.jsp?actived=2");
			rd.forward(request, response);					
		}else{				
			int sokhachhang = model.numkhachhang(idNhanVien);
			int numberpage= (int)Math.ceil((float)sokhachhang/maxitem);
			int currentpage;
			
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			
			int startpage = (currentpage - 1)*maxitem;			
			ArrayList<KhachHang> khachhangs = model.getkhachhangs(idNhanVien,startpage,maxitem);	
			
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("currentpage", currentpage);
			request.setAttribute("khachhangs", khachhangs);
			
			RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/khachhang.jsp?actived=2");
			rd.forward(request, response);
		}
	}

}

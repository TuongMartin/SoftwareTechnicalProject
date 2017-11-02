package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhachHang;
import model.dao.CustomersDAO;




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
		CustomersDAO model = new CustomersDAO();
		int maxitem = 20;
		
		if(request.getParameter("key")!=null||request.getParameter("Timkiem")!=null){
			String str="";
			if(request.getParameter("keysearch")!=null){
				str = new String(request.getParameter("keysearch").getBytes("ISO-8859-1"),"UTF-8");
			}else{
				if(request.getParameter("key")!=null){
					str = new String(request.getParameter("key").getBytes("ISO-8859-1"),"UTF-8");
				}
			}
			int sokhachhang = model.searchkhcount(1,str);
			int numberpage= (int)Math.ceil((float)sokhachhang/maxitem);
			int currentpage;
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			int startpage = (currentpage - 1)*maxitem;	
			ArrayList<Khachhang> khachhangs = model.searchkhachhang(1,startpage,maxitem,str);	
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("khachhangs", khachhangs);
			RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/khachhang.jsp");
			rd.forward(request, response);					
		}else{				
			int sokhachhang = model.numkhachhang(1);
			int numberpage= (int)Math.ceil((float)sokhachhang/maxitem);
			int currentpage;
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			int startpage = (currentpage - 1)*maxitem;			
			ArrayList<Khachhang> khachhangs = model.getkhachhangs(1,startpage,maxitem);		
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("khachhangs", khachhangs);
			RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/khachhang.jsp");
			rd.forward(request, response);
		}
	}

}

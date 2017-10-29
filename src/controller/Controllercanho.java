package controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.canho;
import model.dao.modelcanho;

/**
 * Servlet implementation class Controllercanho
 */
@WebServlet("/Controllercanho")
public class Controllercanho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllercanho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		int maxitem = 20;
		modelcanho model = new modelcanho();
		if(request.getParameter("key")!=null||request.getParameter("Timkiem")!=null){
			String str="";
			if(request.getParameter("keysearch")!=null){
				str = new String(request.getParameter("keysearch").getBytes("ISO-8859-1"),"UTF-8");
			}else{
				if(request.getParameter("key")!=null){
					str = new String(request.getParameter("key").getBytes("ISO-8859-1"),"UTF-8");
				}
			}
			int socanho = model.numbercanhosearch(1,str);
			int numberpage= (int)Math.ceil((float)socanho/maxitem);
			int currentpage;
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			int startpage = (currentpage - 1)*maxitem;	
			ArrayList<canho> canhos = model.searchcanho(1,startpage,maxitem,str);	
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("canhos", canhos);
			RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/canho.jsp");
			rd.forward(request, response);
					
		}else{				
			int socanho = model.numbercanho(1);
			int numberpage= (int)Math.ceil((float)socanho/maxitem);
			int currentpage;
			if(request.getParameter("page")!=null){
				currentpage = Integer.parseInt(request.getParameter("page"));
				currentpage = (currentpage<=numberpage)?currentpage:1;											
			}else{
				currentpage = 1;
			}
			int startpage = (currentpage - 1)*maxitem;			
			ArrayList<canho> canhos = model.getcanhosbyidnv(1,startpage,maxitem);	
			System.out.println(canhos.size());
			request.setAttribute("numberpage", numberpage);
			request.setAttribute("canhos", canhos);
			RequestDispatcher rd = request.getRequestDispatcher("/NhanVien/canho.jsp");
			rd.forward(request, response);
		}
	}

}

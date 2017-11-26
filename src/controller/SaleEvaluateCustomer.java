package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminEvaluateSlales
 */
@WebServlet("/AdminEvaluateSlales")
public class SaleEvaluateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleEvaluateCustomer() {
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
		
		String key="";
		int page=1;
		
		if(request.getParameter("key")!=null) {
			key = request.getParameter("key");
		}
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		int idloaikh = Integer.parseInt(request.getParameter("danhgia"));
		int idkhachhang=Integer.parseInt(request.getParameter("id"));
		
		if(model.danhgiakhachhang(idkhachhang, idloaikh)) {
			response.sendRedirect(request.getContextPath() + "/thanhvien/khachhang?key="+key+"&&page="+page+"&&msg=1");
			return;
		}
		
		response.sendRedirect(request.getContextPath() + "/thanhvien/khachhang?key="+key+"&&page="+page+"&&msg=2");
		return;
	}

}

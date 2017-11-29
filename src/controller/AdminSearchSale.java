package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.RegularExpression;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
public class AdminSearchSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSearchSale() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalesDAO salesDAO = new SalesDAO();
		int idSale = 0;
		if(request.getParameter("idSale") != null) {
			if(RegularExpression.checkNumber(request.getParameter("idSale"))) {
				idSale = Integer.parseInt(request.getParameter("idSale"));
			}
		}
		String fullname = new String(request.getParameter("fullname").getBytes("ISO-8859-1"),"UTF-8");
		int idChucVu = Integer.parseInt(request.getParameter("chucvu"));
		if(salesDAO.searchSales(idSale, fullname, idChucVu) != null) {
			request.setAttribute("listSales", salesDAO.searchSales(idSale, fullname, idChucVu));
			RequestDispatcher rd = request.getRequestDispatcher("/admin/sales/index.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=5");
		}
		
	}

}

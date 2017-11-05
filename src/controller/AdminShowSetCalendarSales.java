package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.CheckLoginLibrary;
import model.dao.AgendaDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminSetCalendarSales
 */
public class AdminShowSetCalendarSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowSetCalendarSales() {
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
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		int idSale = Integer.parseInt(request.getParameter("idSale"));
		SalesDAO salesDAO = new SalesDAO();
		HttpSession session = request.getSession();
		session.setAttribute("objSales", salesDAO.getItemSale(idSale));
		
		AgendaDAO agendaDAO = new AgendaDAO();
		session.setAttribute("agendaItemSale", agendaDAO.getListAgendaSale(idSale));
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/sales/schedule.jsp");
		rd.forward(request, response);
	}

}

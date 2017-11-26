package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import library.CheckLoginLibrary;
import library.CheckRankLibrary;
import model.bean.Account;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
		try {
			int idSale = Integer.parseInt(request.getParameter("idSale"));
			HttpSession session = request.getSession();
			if(!CheckRankLibrary.isAdmin(request, response)) {
				Account objUser = (Account) session.getAttribute("objUser");
				if(objUser.getIdNhanVien() == idSale) {
					SalesDAO salesDAO = new SalesDAO();
					session.setAttribute("objSales", salesDAO.getItemSale(idSale));

					AgendaDAO agendaDAO = new AgendaDAO();
					session.setAttribute("agendaItemSale", agendaDAO.getListAgendaSale(idSale));

					RequestDispatcher rd = request.getRequestDispatcher("/admin/sales/schedule.jsp?actived=4");
					rd.forward(request, response);
				}else {
					response.sendRedirect(request.getContextPath() + "/admin/trang-chu");
				}
			}else {
				SalesDAO salesDAO = new SalesDAO();
				session.setAttribute("objSales", salesDAO.getItemSale(idSale));

				AgendaDAO agendaDAO = new AgendaDAO();
				session.setAttribute("agendaItemSale", agendaDAO.getListAgendaSale(idSale));

				RequestDispatcher rd = request.getRequestDispatcher("/admin/sales/schedule.jsp?actived=4");
				rd.forward(request, response);
			}

		} catch (NumberFormatException ne) {
			response.sendRedirect(request.getContextPath() + "/admin/trang-chu");
		}
	}

}

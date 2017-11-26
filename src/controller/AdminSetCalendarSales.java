package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Agenda;
import model.bean.ItemAgenda;
import model.dao.AgendaDAO;
import model.dao.ItemAgendaDAO;

/**
 * Servlet implementation class ScheduleServlet
 */
public class AdminSetCalendarSales extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminSetCalendarSales() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idSales = Integer.parseInt(request.getParameter("idSales"));
		String title = request.getParameter("title");
		int startTime = Integer.parseInt(request.getParameter("starttime"));
		int endTime = Integer.parseInt(request.getParameter("endtime"));
		String[] days = request.getParameterValues("day");
		
		//ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		AgendaDAO agendaDAO = new AgendaDAO();
		ItemAgendaDAO itemAgendaDAO = new ItemAgendaDAO();
		
		if (days != null) {
			for (int i = 0; i < days.length; i++) {
				String dayString = days[i];
				int day;
				if (dayString.equalsIgnoreCase("SUN"))
					day = 0;
				else if (dayString.equalsIgnoreCase("MON"))
					day = 1;
				else if (dayString.equalsIgnoreCase("TUE"))
					day = 2;
				else if (dayString.equalsIgnoreCase("WED"))
					day = 3;
				else if (dayString.equalsIgnoreCase("THU"))
					day = 4;
				else if (dayString.equalsIgnoreCase("FRI"))
					day = 5;
				else
					day = 6;
				
				Agenda objAgenda = new Agenda(0, day, idSales);
				if(!agendaDAO.addAgenda(objAgenda)) {
					response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=6");
				}
				
				for(int j = 0 ; j <(endTime - startTime) ; j++) {
					ItemAgenda objItem = new ItemAgenda(agendaDAO.getNewAgenda(), objAgenda.getDay(), idSales, 0, title, (startTime + j), (startTime + j + 1));
					if(!itemAgendaDAO.addItemAgenda(objItem)) {
						response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=7");
					}
				}
			}
		}
		request.getSession().setAttribute("agendaItemSale", agendaDAO.getListAgendaSale(idSales));
		getServletContext().getRequestDispatcher("/admin/sales/schedule.jsp").forward(request, response);
	}

}

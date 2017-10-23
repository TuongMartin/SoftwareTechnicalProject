package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.SchoolClass;
import model.bean.SchoolSchedule;
import model.dao.ScheduleDAO;

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
		int starttime = Integer.parseInt(request.getParameter("starttime"));
		int endtime = Integer.parseInt(request.getParameter("endtime"));
		String[] days = request.getParameterValues("day");
		
		ScheduleDAO scheduleDAO = new ScheduleDAO();
		
		SchoolSchedule schedule = (SchoolSchedule) request.getSession(true).getAttribute("schoolschedule");
		if (schedule == null) {
			schedule = new SchoolSchedule();
		}
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

				SchoolClass clazz = new SchoolClass(0,title, starttime, endtime, day,idSales);
				schedule.addClass(clazz);
				scheduleDAO.addItemSchedule(clazz);
			}
		}
		request.getSession().setAttribute("schoolschedule", schedule);
		getServletContext().getRequestDispatcher("/admin/sales/schedule.jsp").forward(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.dao.AgendaDAO;
import model.dao.ItemAgendaDAO;

/**
 * Servlet implementation class AdminManageSales
 */
public class AjaxActiveScheduleByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxActiveScheduleByAdmin() {
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
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		int idItemAgenda = Integer.parseInt(request.getParameter("idItemAgenda"));
		int idAgenda = Integer.parseInt(request.getParameter("idAgenda"));
		
		ItemAgendaDAO itemAgendaDAO = new ItemAgendaDAO();
		AgendaDAO agendaDAO = new AgendaDAO();
		
		itemAgendaDAO.delItemAgenda(idItemAgenda);
		
		//check list of ItemAgenda is null
		//So deleting Agenda
		if(itemAgendaDAO.getListItemAgenda(idAgenda)!=null) {
			if(itemAgendaDAO.getListItemAgenda(idAgenda).size() == 0) {
				agendaDAO.delAgenda(idAgenda);
			}
		}
		
	}

}

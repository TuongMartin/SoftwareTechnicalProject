package library;

import java.util.Date;

import model.dao.AgendaDAO;
import model.dao.ItemAgendaDAO;

public class CheckPassTheWeeks {
	public static void check() {
		Date objDate = new Date();
		if(objDate.getDay() == 6) {
			AgendaDAO agendaDAO = new AgendaDAO();
			agendaDAO.delAgenda();
			ItemAgendaDAO itemAgendaDAO = new ItemAgendaDAO();
			itemAgendaDAO.delItemAgenda();
		}
	}
}

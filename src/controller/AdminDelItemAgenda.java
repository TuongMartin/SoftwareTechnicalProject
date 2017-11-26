package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.dao.ItemAgendaDAO;

/**
 * Servlet implementation class AdminManageSales
 */
public class AdminDelItemAgenda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelItemAgenda() {
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
		int idItem = Integer.parseInt(request.getParameter("id"));
		ItemAgendaDAO itemAgendaDAO = new ItemAgendaDAO();
		if(itemAgendaDAO.delItemAgenda(idItem)) {
			response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=4");
		} else {
			response.sendRedirect(request.getContextPath() + "/admphamsan-pham?msg=0");
		}
	}

}

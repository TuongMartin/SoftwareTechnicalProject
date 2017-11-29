package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.CanHo;
import model.dao.ApartmentDAO;

@WebServlet("/SearchBDS")
public class SearchBDS extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public SearchBDS() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		ArrayList<CanHo> listSearchBDS = new ArrayList<CanHo>();
		
		System.out.println(request.getParameter("beds"));
		System.out.println(request.getParameter("khuvuc"));
		System.out.println(request.getParameter("baths"));
		System.out.println(request.getParameter("typeBDS"));

		
		String tinhHoacThanhPho = request.getParameter("khuvuc");
		String numberBeds = request.getParameter("beds");
		String numberBaths = request.getParameter("baths");
		String typeBDS = request.getParameter("typeBDS");
		
		listSearchBDS = apartmentDAO.getBDSNeedSearch(tinhHoacThanhPho, numberBeds, numberBaths, typeBDS);
		request.setAttribute("listSearchBDS", listSearchBDS);
		
		System.out.println("size: " + listSearchBDS.size());
		
		RequestDispatcher rd = request.getRequestDispatcher("/listings-list-with-sidebar.jsp");
		rd.forward(request, response);
	}

}

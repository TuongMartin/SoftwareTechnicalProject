package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.LibraryCheckCustomerPublic;
import model.bean.CanHo;
import model.bean.Image;
import model.dao.ApartmentDAO;
import model.dao.AreaDAO;
import model.dao.ImageDAO;
import model.dao.RealEstateDAO;

/**
 * Servlet implementation class PublicIndex
 */
//@WebServlet("/PublicIndex")
public class PublicIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicIndex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!LibraryCheckCustomerPublic.checkUser(request, response)){
			return;
		}
		AreaDAO areaDAO = new AreaDAO();
		RealEstateDAO realestateDAO = new RealEstateDAO();
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		ImageDAO imageDAO = new ImageDAO();
		ArrayList<CanHo> listApartmentNewly = apartmentDAO.getItemApartmentNewLy();
		ArrayList<ArrayList<Image>> listImageApartmentNewly = new ArrayList<>();
		for(CanHo objCanHo : listApartmentNewly) {
			listImageApartmentNewly.add(imageDAO.getListItemImageForApartmentNewly(objCanHo.getId()));
		}
		request.setAttribute("listImageApartmentNewly", listImageApartmentNewly);
		request.setAttribute("listApartmentNewly", listApartmentNewly);
		request.setAttribute("listRealEstate", realestateDAO.getItem());
		request.setAttribute("listAreas", areaDAO.getItemPublic());
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

}

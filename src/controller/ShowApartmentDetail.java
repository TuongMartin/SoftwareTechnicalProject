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


@WebServlet("/ApartmentDetail")
public class ShowApartmentDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ShowApartmentDetail() {
        super();
    }

    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idTinDang = request.getParameter("canho");
    	CanHo objCanHo = null;
    	ApartmentDAO apartmentDAO = new ApartmentDAO();
    	
		ArrayList<CanHo> listSimilar = new ArrayList<CanHo>();
		ArrayList<CanHo> listFeaturead = new ArrayList<CanHo>();
		ArrayList<Integer> listIDTinDangFeaturead = new ArrayList<Integer>();
		
		int giaTienMax = 0;
		int giaTienMin = 0;
		
		if(idTinDang != null)
		{
			objCanHo = apartmentDAO.getItemApartmentById(Integer.valueOf(idTinDang));
			listSimilar = apartmentDAO.getListSimilarTinDang(objCanHo.getIdtheloai(), 0, 3);
			listIDTinDangFeaturead = apartmentDAO.getListIdTinDangFeatured(0, 3);
			giaTienMax = apartmentDAO.getGiaTienMax();
			giaTienMin = apartmentDAO.getGiaTienMin();
		}
		
		if(listIDTinDangFeaturead != null)
		{
			for(int id : listIDTinDangFeaturead)
			{
				listFeaturead.add(apartmentDAO.getItemApartmentById(id));
			}
		}
		
		request.setAttribute("objCanHo", objCanHo);
		request.setAttribute("listSimilar", listSimilar);
		request.setAttribute("listFeaturead", listFeaturead);
		request.setAttribute("giaTienMax", giaTienMax);
		request.setAttribute("giaTienMin", giaTienMin);
		
		RequestDispatcher rd = request.getRequestDispatcher("/single-property-page-2.jsp");
		rd.forward(request, response);
	}

}

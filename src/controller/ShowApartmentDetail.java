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
import model.bean.Image;
import model.bean.TienIch;
import model.bean.TinTuc;
import model.dao.ApartmentDAO;
import model.dao.FeatureDAO;
import model.dao.ImageDAO;


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
    	Image objImage = null;
    	
    	ApartmentDAO apartmentDAO = new ApartmentDAO();
    	ImageDAO imageDAO = new ImageDAO();
    	FeatureDAO featureDAO = new FeatureDAO();
    	
		ArrayList<CanHo> listSimilar = new ArrayList<CanHo>();
		ArrayList<CanHo> listFeaturead = new ArrayList<CanHo>();
		ArrayList<Image> listImageOfThisApartment = new ArrayList<Image>();
		ArrayList<Image> listImageOfListSimilar = new ArrayList<Image>();
		ArrayList<Image> listImageOfListFeaturead = new ArrayList<Image>();
		ArrayList<TienIch> listTienIch = new ArrayList<TienIch>();
		ArrayList<Integer> listIDTinDangFeaturead = new ArrayList<Integer>();
		
		int giaTienMax = 0;
		int giaTienMin = 0;
		
		if(idTinDang != null)
		{
			objCanHo = apartmentDAO.getItemApartmentById(Integer.valueOf(idTinDang));
			listSimilar = apartmentDAO.getListSimilarTinDang(objCanHo.getIdtheloai(), 0, 3);
			listTienIch = featureDAO.getFeatureApartment(Integer.valueOf(idTinDang));
			
			listIDTinDangFeaturead = apartmentDAO.getListIdTinDangFeatured(0, 3);
			listImageOfThisApartment = imageDAO.getListItemImage(Integer.valueOf(idTinDang));
			
			giaTienMax = apartmentDAO.getGiaTienMax();
			giaTienMin = apartmentDAO.getGiaTienMin();
		}
		
		if(listIDTinDangFeaturead != null)
		{
			for(int id : listIDTinDangFeaturead)
			{
				listFeaturead.add(apartmentDAO.getItemApartmentById(id));
				objImage = imageDAO.getItemImage(id);
				
				if(objImage != null)
					listImageOfListFeaturead.add(objImage);
			}
		}
		
		if(listSimilar != null)
		{
			for(CanHo objSimilar : listSimilar)
			{
				objImage = imageDAO.getItemImage(objSimilar.getId());
				
				if(objImage != null)
					listImageOfListSimilar.add(objImage);
			}
		}
		
		request.setAttribute("objCanHo", objCanHo);
		request.setAttribute("listSimilar", listSimilar);
		request.setAttribute("listFeaturead", listFeaturead);
		
		request.setAttribute("listImage", listImageOfThisApartment);
		request.setAttribute("listTienIch", listTienIch);
		
		request.setAttribute("listImageOfListSimilar", listImageOfListSimilar);
		request.setAttribute("listImageOfListFeaturead", listImageOfListFeaturead);
		
		request.setAttribute("giaTienMax", giaTienMax);
		request.setAttribute("giaTienMin", giaTienMin);
		
		RequestDispatcher rd = request.getRequestDispatcher("/single-property-page-2.jsp");
		rd.forward(request, response);
	}

}

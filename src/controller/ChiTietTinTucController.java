package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

import model.dao.TinTucDAO;
import model.bean.TinTuc;


@WebServlet(urlPatterns = { "/ShowChiTietTinTuc" })
public class ChiTietTinTucController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private static final int NUMBER_NEW_ITEMS_NEED = 2;
	private static final int NUMBER_RELATED_ITEMS_NEED = 3;
	
	
	public ChiTietTinTucController(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tintucDAO = new TinTucDAO();
		TinTuc objTinTuc= null;
		String idTinTuc = request.getParameter("idTinTuc");
		
		ArrayList<TinTuc> listRelatedItems = null;
		ArrayList<TinTuc> listNewItems = tintucDAO.getListNewItems(NUMBER_NEW_ITEMS_NEED);
		
		if(idTinTuc != null)
		{
			objTinTuc = tintucDAO.getItemTinTuc(idTinTuc);
		}
		
		if(objTinTuc != null)
		{
			listRelatedItems = tintucDAO.getListRelatedItems(
					tintucDAO.getIdPhanLoaiTinTuc(objTinTuc.getIdTinTuc()), NUMBER_RELATED_ITEMS_NEED);
			
			int luotView = objTinTuc.getLuotView();
			tintucDAO.updateView(luotView + 1, objTinTuc.getIdTinTuc());
		}
		
		request.setAttribute("objTinTuc", objTinTuc);
		request.setAttribute("listRelatedItems", listRelatedItems);
		request.setAttribute("listNewItems", listNewItems);
		
		RequestDispatcher rd = request.getRequestDispatcher("blog-post.jsp");
		rd.forward(request, response);
	}
}


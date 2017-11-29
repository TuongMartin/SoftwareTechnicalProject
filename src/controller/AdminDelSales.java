package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminDelSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelSales() {
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
		int idSale = Integer.parseInt(request.getParameter("idSale"));
		SalesDAO salesDAO = new SalesDAO();
		final String path = request.getServletContext().getRealPath("files");
		String picture = salesDAO.getItemSale(idSale).getAvatar();
		if(!"".equals(picture)) {
			String urlFile = path + File.separator + picture;
			File delFile = new File(urlFile);
			delFile.delete();
		}
		if(salesDAO.delItemSale(idSale)) {
			response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=4");
		} else {
			response.sendRedirect(request.getContextPath() + "/admphamsan-pham?msg=0");
		}
	}

}

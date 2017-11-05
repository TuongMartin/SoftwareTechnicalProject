package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import library.CheckLoginLibrary;
import model.dao.CustomersDAO;
=======
import model.dao.CustomersDAO;
import model.dao.SalesDAO;
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminDelCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDelCustomer() {
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
<<<<<<< HEAD
		if(!CheckLoginLibrary.isLogin(request, response)) {
			return;
		}
=======
>>>>>>> 3af2159341ba1c25e1bca406cf3fa48e2f2b7380
		int idCustomer = Integer.parseInt(request.getParameter("id"));
		CustomersDAO customerDAO = new CustomersDAO();
		final String path = request.getServletContext().getRealPath("files");
		String picture = customerDAO.getItemCustomerById(idCustomer).getAvatar();
		if(!"".equals(picture)) {
			String urlFile = path + File.separator + picture;
			File delFile = new File(urlFile);
			delFile.delete();
		}
		if(customerDAO.delItemCustomer(idCustomer)) {
			response.sendRedirect(request.getContextPath() + "/admin/manageCustomers?msg=1");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/manageCustomers?msg=0");
		}
	}

}

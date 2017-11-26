package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.NhanVien;
import model.bean.TheLoaiBDS;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminAddNewRealState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddNewRealState() {
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
		RealEstateDAO realestateDAO = new RealEstateDAO();
		if(request.getParameter("submit") != null) {
			String theloai = new String(request.getParameter("realestate").getBytes("ISO-8859-1"),"UTF-8");
			if(realestateDAO.getItemRealEstatebyName(theloai) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/addRealEstate?msg=2");
			}
			else {
				final String path = request.getServletContext().getRealPath("files");
				final Part filePart = request.getPart("image");
				final String fileName = FileNameLibrary.getFileName(filePart);
				String image = "";
				File dirUrl = new File(path);
				if(!dirUrl.exists()){
					dirUrl.mkdir();
				}
				if(!"".equals(fileName)){
					OutputStream out = null;
					InputStream filecontent = null;
					image = RenameFileLibrary.renameFile(fileName);
					try {
						out = new FileOutputStream(new File(path + File.separator
								+ image));
						filecontent = filePart.getInputStream();
						int read = 0;
						final byte[] bytes = new byte[1024];
						while ((read = filecontent.read(bytes)) != -1) {
							out.write(bytes, 0, read);
						}
						System.out.println("Upload thành công");
					} catch (FileNotFoundException fne) {
						System.err.println("Có lỗi trong quá trình");
						fne.printStackTrace();
					} finally {
						if (out != null) {
							out.close();
						}
						if (filecontent != null) {
							filecontent.close();
						}
					}
				}else{
					image = "";
				}
				TheLoaiBDS objTheLoai = new TheLoaiBDS(0, theloai, image);
				if(realestateDAO.addItemRealEstate(objTheLoai)) {
					response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=1");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=0");
				}
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/realestate/add.jsp?actived=1");
			rd.forward(request, response);
		}
	}

}

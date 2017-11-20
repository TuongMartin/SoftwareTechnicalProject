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

import library.CheckLoginLibrary;
import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.KhuVucBDS;
import model.dao.AreaDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminAddNewAreaRealState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddNewAreaRealState() {
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
		AreaDAO areaDAO = new AreaDAO();
		if(request.getParameter("submit") != null) {
			String khuvuc = new String(request.getParameter("area").getBytes("ISO-8859-1"),"UTF-8");
			if(areaDAO.getItemAreaRealEstatebyName(khuvuc) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/addAreaRealEstate?msg=2");
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
				KhuVucBDS objKhuVuc = new KhuVucBDS(0, khuvuc, image);
				if(areaDAO.addItemAreaRealEstate(objKhuVuc)) {
					response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=1");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=0");
				}
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/area/add.jsp");
			rd.forward(request, response);
		}
	}

}

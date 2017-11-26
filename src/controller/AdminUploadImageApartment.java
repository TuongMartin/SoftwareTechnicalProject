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
import model.dao.ImageDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminUploadImageApartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUploadImageApartment() {
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
		ImageDAO imageDAO = new ImageDAO();
		int aid = Integer.parseInt(request.getParameter("id"));
		if(request.getParameter("submit") != null) {
			String hinhanh = "";
			response.setContentType("text/html;charset=UTF-8");
			final String path = request.getServletContext().getRealPath("files");
			final Part filePart = request.getPart("file");
			final String fileName = FileNameLibrary.getFileName(filePart);
			
			File dirUrl = new File(path);
			if(!dirUrl.exists()){
				dirUrl.mkdir();//tự động tạo file
			}
			if(!"".equals(fileName)){
				OutputStream out = null;
				InputStream filecontent = null;
				hinhanh = RenameFileLibrary.renameFile(fileName);
				
				try {
					out = new FileOutputStream(new File(path + File.separator
							+ hinhanh));
					filecontent = filePart.getInputStream();
					int read = 0;
					final byte[] bytes = new byte[1024];
					while ((read = filecontent.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
//					System.out.println("Upload thành công");
				} catch (FileNotFoundException fne) {
					System.err.println("Có lỗi trong quá trình xử lý");
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
				hinhanh = "";
			}
			if ("".equals(hinhanh)) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin/apartment/upload-image.jsp?actived=3&msg=2&id=" + aid);
				rd.forward(request, response);
			} else {
				if(imageDAO.uploadImageApartment(hinhanh, aid)) {
					response.sendRedirect(request.getContextPath() + "/admin/uploadImageApartment?msg=1&id=" + aid);
				}else {
					response.sendRedirect(request.getContextPath() + "/admin/uploadImageApartment?msg=0&id=" + aid);
				}
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/apartment/upload-image.jsp?actived=3");
			rd.forward(request, response);
		}
	}

}

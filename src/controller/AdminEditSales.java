package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.BCrypt;
import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.NhanVien;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class AdminEditSales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditSales() {
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
		String hoten = new String(request.getParameter("hoten").getBytes("ISO-8859-1"),"UTF-8");
		String ngaysinh = new String(request.getParameter("ngaysinh"));
		
		int cmnd = Integer.parseInt(request.getParameter("CMND"));
		String quequan = new String(request.getParameter("quequan").getBytes("ISO-8859-1"),"UTF-8");
		String diachi = new String(request.getParameter("diachi").getBytes("ISO-8859-1"),"UTF-8");
		String sdt = new String(request.getParameter("sdt"));
		String password = new String(request.getParameter("password")); 
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
		System.out.println("Password sau khi mã hóa : " + hashed);
		int idChucVu = Integer.parseInt(request.getParameter("chucvu"));
		
		String picture = "";
		SalesDAO salesDAO = new SalesDAO();
		
		response.setContentType("text/html;charset=UTF-8");
		final String path = request.getServletContext().getRealPath("files");
		final Part filePart = request.getPart("hinhanh");
		final String fileName = FileNameLibrary.getFileName(filePart);
		
		File dirUrl = new File(path);
		if(!dirUrl.exists()){
			dirUrl.mkdir();//tự động tạo file
		}
		if(request.getParameter("delete_picture") != null) {
			if(!"".equals(fileName)){
				OutputStream out = null;
				InputStream filecontent = null;
				picture = RenameFileLibrary.renameFile(fileName);
				
				String picture_old = salesDAO.getItemSale(idSale).getAvatar();
				if(!"".equals(picture_old)){
					String urlDel = path + File.separator + picture_old;
					File delFile = new File(urlDel);
					delFile.delete();
				}
				
				try {
					out = new FileOutputStream(new File(path + File.separator
							+ picture));
					filecontent = filePart.getInputStream();
					int read = 0;
					final byte[] bytes = new byte[1024];
					while ((read = filecontent.read(bytes)) != -1) {
						out.write(bytes, 0, read);
					}
					System.out.println("Upload thành công");
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
				picture = "";
			}
		}else{
			picture = salesDAO.getItemSale(idSale).getAvatar();
		}
		
		NhanVien objSale = new NhanVien(idSale, hoten, diachi, quequan, cmnd, ngaysinh, sdt, "", hashed, idChucVu, "", picture);
		if(salesDAO.editSale(objSale)) {
			response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=1");
		} else {
			response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=0");
		}
	}

}

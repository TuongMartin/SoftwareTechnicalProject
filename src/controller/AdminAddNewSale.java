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
import library.CheckLoginLibrary;
import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.Account;
import model.bean.NhanVien;
import model.dao.AccountDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminAddNewSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminAddNewSale() {
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
		SalesDAO salesDAO = new SalesDAO();
		AccountDAO accountDAO = new AccountDAO();
		int idSale = Integer.parseInt(request.getParameter("id"));
		if(salesDAO.getItemSale(idSale) != null) {
			response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=3");
		}else {
			/*String hoten = new String(request.getParameter("hoten").getBytes("ISO-8859-1"),"UTF-8");
			String ngaysinh = new String(request.getParameter("ngaysinh"));
			
			int cmnd = Integer.parseInt(request.getParameter("CMND"));
			String quequan = new String(request.getParameter("quequan").getBytes("ISO-8859-1"),"UTF-8");
			String diachi = new String(request.getParameter("diachi").getBytes("ISO-8859-1"),"UTF-8");
			String sdt = new String(request.getParameter("sdt"));
			int idChucVu = Integer.parseInt(request.getParameter("chucvu"));
			
			//add new account
			String username = new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
			String password = BCrypt.hashpw(new String(request.getParameter("password")), BCrypt.gensalt());
			int idrole = Integer.parseInt(request.getParameter("idrole"));
			Account objAccount = new Account(0, username, password, idrole, null, idSale, hoten);
			accountDAO.addaccount(objAccount);
			String picture = "";
			
			response.setContentType("text/html;charset=UTF-8");
			final String path = request.getServletContext().getRealPath("files");
			final Part filePart = request.getPart("hinhanh");
			final String fileName = FileNameLibrary.getFileName(filePart);
			
			File dirUrl = new File(path);
			if(!dirUrl.exists()){
				dirUrl.mkdir();//tự động tạo file
			}
				if(!"".equals(fileName)){
					OutputStream out = null;
					InputStream filecontent = null;
					picture = RenameFileLibrary.renameFile(fileName);
					
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
		
			NhanVien objNhanVien = new NhanVien(idSale, hoten, diachi, quequan, cmnd, ngaysinh, sdt, idChucVu, null, picture, accountDAO.getAccountNew().getId());
			if(salesDAO.addItemSale(objNhanVien)) {
				response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=2");
			} else {
				response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=0");
			}*/
		}
		
	}

}

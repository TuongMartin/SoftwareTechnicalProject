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

import library.BCrypt;
import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.KhachHang;
import model.dao.CustomersDAO;

/**
 * Servlet implementation class AdminManageSales
 */
@MultipartConfig
public class PublicEditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicEditCustomer() {
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
		CustomersDAO customerDAO = new CustomersDAO();
		int	cid = Integer.parseInt(request.getParameter("id"));
		KhachHang objCustomerUpdate = customerDAO.getItemCustomerById(cid);
		if(request.getParameter("editCustomer") != null) {
			String hoten = new String(request.getParameter("full_name").getBytes("ISO-8859-1"),"UTF-8");
			String ngaysinh = request.getParameter("birthday");
			String quequan = new String(request.getParameter("home_town").getBytes("ISO-8859-1"),"UTF-8");
			String diachi = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			String sdt = request.getParameter("phone");
			String hashed = "";
			if(!"".equals(request.getParameter("password"))) {
				String password = new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8"); 
				hashed = BCrypt.hashpw(password, BCrypt.gensalt());
			}
			else {
				hashed = objCustomerUpdate.getMatKhau();
			}
			
			String picture = "";
			final String path = request.getServletContext().getRealPath("files");
			final Part filePart = request.getPart("avatar");
			final String fileName = FileNameLibrary.getFileName(filePart);
			File dirUrl = new File(path);
			if(!dirUrl.exists()){
				dirUrl.mkdir();//tự động tạo file
			}
			
			if(!"".equals(fileName)){
				OutputStream out = null;
				InputStream filecontent = null;
				picture = RenameFileLibrary.renameFile(fileName);
				
				String picture_old = customerDAO.getItemCustomerById(cid).getAvatar();
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
				picture = customerDAO.getItemCustomerById(cid).getAvatar();
			}
			
			KhachHang objCustomer = new KhachHang(cid, hoten, diachi, quequan, "", ngaysinh, sdt, "", hashed, picture, 0, "", "");
			if(customerDAO.editCustomer(objCustomer)) {
				response.sendRedirect(request.getContextPath() + "/public/my-profile?id=" + cid + "&msg=1");
			} else {
				response.sendRedirect(request.getContextPath() + "/public/my-profile?id=" + cid + "&msg=0");
			}
		}
		else {
			request.setAttribute("objCustomerUpdate", objCustomerUpdate);
			RequestDispatcher rd = request.getRequestDispatcher("/my-profile.jsp");
			rd.forward(request, response);
		}
	}

}

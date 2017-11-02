package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;

import library.BCrypt;
import library.FileNameLibrary;
import library.RandomStringGenerator;
import library.RenameFileLibrary;
import library.SendMail;
import model.bean.KhachHang;
import model.bean.NhanVien;
import model.dao.CustomersDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class PublicRegisterNewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublicRegisterNewCustomer() {
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
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		CustomersDAO customerDAO = new CustomersDAO();
		String email = request.getParameter("email");
		if(request.getParameter("register") != null){
			if(customerDAO.getItemCustomerByEmail(email) != null) {
				response.sendRedirect(request.getContextPath() + "/public/register?msg=2");
			}else {
				String hoten = new String(request.getParameter("full_name").getBytes("ISO-8859-1"),"UTF-8");
				String ngaysinh = new String(request.getParameter("birthday"));
				String cmnd = request.getParameter("identity_card");
				String quequan = new String(request.getParameter("home_town").getBytes("ISO-8859-1"),"UTF-8");
				String diachi = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
				String sdt = request.getParameter("phone");
				String password = request.getParameter("password");
				String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
				String avatar = "";
				final String path = request.getServletContext().getRealPath("files");
				final Part filePart = request.getPart("avatar");
				final String fileName = FileNameLibrary.getFileName(filePart);
				
				File dirUrl = new File(path);
				if(!dirUrl.exists()){
					dirUrl.mkdir();
				}
				if(!"".equals(fileName)){
					OutputStream out = null;
					InputStream filecontent = null;
					avatar = RenameFileLibrary.renameFile(fileName);
					
					try {
						out = new FileOutputStream(new File(path + File.separator
								+ avatar));
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
					avatar = "";
				}
				
				RandomStringGenerator rsg = new RandomStringGenerator();
				String token = rsg.generateString();
				KhachHang objCustomer = new KhachHang(0, hoten, diachi, quequan, cmnd, ngaysinh, sdt, email, hashed, avatar, 0, token, null);
				if(customerDAO.addItemCustomer(objCustomer)) {
					SendMail mail = new SendMail();
					String content = "<html>"
									+ "<body>" 
									+ "<h3>You have successfully registered your account, please click on the link to confirm your account</h3><br>"
									+ "<a href=" + "http://localhost:8080/SoftwareTechnicalProject/public/confirm-account?email=" + objCustomer.getEmail() +"&token=" + objCustomer.getToken() + ">" + objCustomer.getToken() +"</a><br>"
									+ "</body>"
									+ "</html>";
					mail.sendMail(objCustomer.getEmail(), "Confirm account!", content);
					response.sendRedirect(request.getContextPath() + "/public/register?msg=1");
				} else {
					response.sendRedirect(request.getContextPath() + "/public/register?msg=0");
				}
			}
		}
		else{
			RequestDispatcher rd = request.getRequestDispatcher("/login-register.jsp");
			rd.forward(request, response);
		}
	}

}

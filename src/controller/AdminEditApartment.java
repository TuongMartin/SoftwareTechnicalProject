package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import library.FileNameLibrary;
import library.RenameFileLibrary;
import model.bean.CanHo;
import model.bean.NhanVien;
import model.dao.ApartmentDAO;
import model.dao.AreaDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminEditApartment extends HttpServlet {
	private final String UPLOAD_DIRECTORY = "C:/uploads";
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditApartment() {
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
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		RealEstateDAO realEstateDAO = new RealEstateDAO();
		SalesDAO saleDAO = new SalesDAO();
		AreaDAO areDAO = new AreaDAO();
		int aid = Integer.parseInt(request.getParameter("id"));
		CanHo objCanHoUpdate = apartmentDAO.getItemApartmentById(aid);
		if(request.getParameter("submit") != null) {
			String ten = new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
			String diachi = new String(request.getParameter("address").getBytes("ISO-8859-1"),"UTF-8");
			int dientich = Integer.parseInt(request.getParameter("area"));
			int giatien = Integer.parseInt(request.getParameter("price"));
			int sophong = Integer.parseInt(request.getParameter("totalRoom"));
			int phongngu = Integer.parseInt(request.getParameter("bedRoom"));
			int phongtam = Integer.parseInt(request.getParameter("bathRoom"));
			int namtuoi = Integer.parseInt(request.getParameter("buildingAge"));
			String parking = new String(request.getParameter("parking").getBytes("ISO-8859-1"),"UTF-8");
			String cooling = new String(request.getParameter("cooling").getBytes("ISO-8859-1"),"UTF-8");
			String heating = new String(request.getParameter("heating").getBytes("ISO-8859-1"),"UTF-8");
			String sewer = new String(request.getParameter("sewer").getBytes("ISO-8859-1"),"UTF-8");
			String water = new String(request.getParameter("water").getBytes("ISO-8859-1"),"UTF-8");
			int exerciseRoom = Integer.parseInt(request.getParameter("exerciseRoom"));
			int storageRoom = Integer.parseInt(request.getParameter("storageRoom"));
			int theloai = Integer.parseInt(request.getParameter("theloai"));
			int nhanvien = Integer.parseInt(request.getParameter("nhanvien"));
			int khuvuc = Integer.parseInt(request.getParameter("khuvuc"));
			String mota = new String(request.getParameter("mota").getBytes("ISO-8859-1"),"UTF-8");
			
			final String path = request.getServletContext().getRealPath("files");
			File dirUrl = new File(path);
			if(!dirUrl.exists()){
				dirUrl.mkdir();//tự động tạo file
			}
			
			if(ServletFileUpload.isMultipartContent(request)) {
				try {
//					System.out.println("1");
					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
//					System.out.println("2");
//					System.out.println(multiparts);
					for(FileItem item : multiparts) {
//						System.out.println("3");
						if(!item.isFormField()) {
							String name = new File(item.getName()).getName();
							item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
						}
//						System.out.println("4");
					}
				} catch(Exception e) {
					System.out.println("error");
					e.printStackTrace();
				}
			}
			
			CanHo objCanHo = new CanHo(aid, ten, diachi, dientich, giatien, sophong, phongngu, phongtam, mota, namtuoi, parking, cooling, heating, sewer, water, exerciseRoom, storageRoom, nhanvien, "", 0, "", theloai, "", 0, khuvuc, "");
			if(apartmentDAO.eidtItemApartment(objCanHo)) {
				response.sendRedirect(request.getContextPath() + "/admin/manageApartments?msg=2");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/admin/manageApartments?msg=0");
			}
//			response.setContentType("text/html;charset=UTF-8");
//			final String path = request.getServletContext().getRealPath("files");
//			final Part filePart = request.getPart("hinhanh");
//			final String fileName = FileNameLibrary.getFileName(filePart);
//			
//			File dirUrl = new File(path);
//			if(!dirUrl.exists()){
//				dirUrl.mkdir();//tự động tạo file
//			}
//				if(!"".equals(fileName)){
//					OutputStream out = null;
//					InputStream filecontent = null;
//					picture = RenameFileLibrary.renameFile(fileName);
//					
//					try {
//						out = new FileOutputStream(new File(path + File.separator
//								+ picture));
//						filecontent = filePart.getInputStream();
//						int read = 0;
//						final byte[] bytes = new byte[1024];
//						while ((read = filecontent.read(bytes)) != -1) {
//							out.write(bytes, 0, read);
//						}
//						System.out.println("Upload thành công");
//					} catch (FileNotFoundException fne) {
//						System.err.println("Có lỗi trong quá trình xử lý");
//						fne.printStackTrace();
//					} finally {
//						if (out != null) {
//							out.close();
//						}
//						if (filecontent != null) {
//							filecontent.close();
//						}
//					}
//				}else{
//					picture = "";
//				}
//			
//			NhanVien objNhanVien = new NhanVien(idSale, hoten, diachi, quequan, cmnd, ngaysinh, sdt, username, password, idChucVu, null, picture);
//			if(salesDAO.addItemSale(objNhanVien)) {
//				response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=2");
//			} else {
//				response.sendRedirect(request.getContextPath() + "/admin/manageSales?msg=0");
//			}
		}
		else {
			request.setAttribute("objCanHoUpdate", objCanHoUpdate);
			request.setAttribute("listKhuVuc", areDAO.getItem());
			request.setAttribute("listNhanVien", saleDAO.getListUser());
			request.setAttribute("listTheLoai", realEstateDAO.getItem());
			RequestDispatcher rd = request.getRequestDispatcher("/admin/apartment/edit.jsp");
			rd.forward(request, response);
		}
		
	}

}

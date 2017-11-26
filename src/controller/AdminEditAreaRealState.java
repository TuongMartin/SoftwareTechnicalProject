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
import model.bean.KhuVucBDS;
import model.bean.NhanVien;
import model.bean.TheLoaiBDS;
import model.dao.AreaDAO;
import model.dao.RealEstateDAO;
import model.dao.SalesDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminEditAreaRealState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditAreaRealState() {
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
		AreaDAO areaDAO = new AreaDAO();
		int aid = Integer.parseInt(request.getParameter("id"));
		KhuVucBDS objKhuVucUpdate = areaDAO.getItemAreaRealEstateById(aid);
		if(request.getParameter("submit") != null) {
			String khuvuc = new String(request.getParameter("area").getBytes("ISO-8859-1"),"UTF-8");
			if(areaDAO.getItemAreaRealEstatebyNameEdit(khuvuc, aid) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/editAreaRealEstate?id=" + aid + "&msg=2");
			}
			else {
				String image = "";
				final String path = request.getServletContext().getRealPath("files");
				final Part filePart = request.getPart("image");
				final String fileName = FileNameLibrary.getFileName(filePart);
				File dirUrl = new File(path);
				if(!dirUrl.exists()){
					dirUrl.mkdir();//tự động tạo file
				}
				
				if(!"".equals(fileName)){
					OutputStream out = null;
					InputStream filecontent = null;
					image = RenameFileLibrary.renameFile(fileName);
					
					String picture_old = areaDAO.getItemAreaRealEstateById(aid).getImage();
					if(!"".equals(picture_old)){
						String urlDel = path + File.separator + picture_old;
						File delFile = new File(urlDel);
						delFile.delete();
					}
					
					try {
						out = new FileOutputStream(new File(path + File.separator
								+ image));
						filecontent = filePart.getInputStream();
						int read = 0;
						final byte[] bytes = new byte[1024];
						while ((read = filecontent.read(bytes)) != -1) {
							out.write(bytes, 0, read);
						}
//						System.out.println("Upload thành công");
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
					image = objKhuVucUpdate.getImage();;
				}
				KhuVucBDS objKhuVuc = new KhuVucBDS(aid, khuvuc, image);
				if(areaDAO.editItemAreaRealEstate(objKhuVuc)) {
					response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=2");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/area-real-estate?msg=0");
				}
			}
		}
		else {
			request.setAttribute("objKhuVucUpdate", objKhuVucUpdate);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/area/edit.jsp?actived=2");
			rd.forward(request, response);
		}
	}

}

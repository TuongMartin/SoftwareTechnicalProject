package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import library.CheckLoginLibrary;
import model.bean.TheLoaiBDS;
import model.dao.RealEstateDAO;

/**
 * Servlet implementation class AdminAddNewSale
 */
@MultipartConfig
public class AdminEditRealState extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditRealState() {
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
		RealEstateDAO realestateDAO = new RealEstateDAO();
		int rid = Integer.parseInt(request.getParameter("id"));
		TheLoaiBDS objTheLoaiUpdate = realestateDAO.getItemRealEstateByid(rid);
		if(request.getParameter("submit") != null) {
			String theloai = new String(request.getParameter("realestate").getBytes("ISO-8859-1"),"UTF-8");
			if(realestateDAO.getItemRealEstatebyNameEdit(theloai, rid) != null) {
				response.sendRedirect(request.getContextPath() + "/admin/editRealEstate?id=" + rid + "&msg=2");
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
					
					String picture_old = realestateDAO.getItemRealEstateByid(rid).getImage();
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
					image = objTheLoaiUpdate.getImage();;
				}
				TheLoaiBDS objTheLoai = new TheLoaiBDS(rid, theloai, image);
				if(realestateDAO.editItemRealEstate(objTheLoai)) {
					response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=2");
				}
				else {
					response.sendRedirect(request.getContextPath() + "/admin/category-real-estate?msg=0");
				}
			}
		}
		else {
			request.setAttribute("objTheLoaiUpdate", objTheLoaiUpdate);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/realestate/edit.jsp?actived=1");
			rd.forward(request, response);
		}
	}

}

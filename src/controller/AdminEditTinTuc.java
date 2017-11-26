package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import library.FileNameLibrary;
import library.RenameFileLibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import model.dao.TinTucDAO;
import model.bean.TinTuc;;


@WebServlet(urlPatterns = { "/EditTT" })
@MultipartConfig
public class AdminEditTinTuc extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	
	public AdminEditTinTuc(){
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TinTucDAO tinTucDAO = new TinTucDAO();
		String messageStr = null;
		String hinhAnh = "";
		String url = "";
		
		String tieuDe = new String(request.getParameter("TieuDe").getBytes("ISO-8859-1"),"UTF-8");
		String id = new String(request.getParameter("idLoaiTinTuc").getBytes("ISO-8859-1"),"UTF-8");
		String noiDung = new String(request.getParameter("noidungtintuc").getBytes("ISO-8859-1"),"UTF-8");
		String quote = new String(request.getParameter("quote").getBytes("ISO-8859-1"),"UTF-8");

		response.setContentType("text/html;charset=UTF-8");
		String fileCreateName = "files";
		final String path = request.getServletContext().getRealPath(fileCreateName);
		final Part filePart = request.getPart("UrlHinhAnh");
		final String fileName = FileNameLibrary.getFileName(filePart);
		
		File dirUrl = new File(path);
		if(!dirUrl.exists())
		{
			dirUrl.mkdir();
		}
		
		if(!"".equals(fileName))
		{
			OutputStream out = null;
			InputStream filecontent = null;
			hinhAnh = RenameFileLibrary.renameFile(fileName);
			url = fileCreateName + "/" + hinhAnh;
				
			try
			{
				out = new FileOutputStream(new File(path + File.separator + hinhAnh));
				filecontent = filePart.getInputStream();
				int read = 0;
				final byte[] bytes = new byte[1024];
				while ((read = filecontent.read(bytes)) != -1)
				{
					out.write(bytes, 0, read);
				}
			} 
			catch (FileNotFoundException fne) 
			{
				fne.printStackTrace();
			}
			finally 
			{
				if (out != null)
				{
					out.close();
				}
				if (filecontent != null)
				{
					filecontent.close();
				}
			}
		}
		else
		{
			hinhAnh = "";
		}
		
		int idLoaiTinTuc = Integer.parseInt(id);
		int idTinTuc = Integer.parseInt(request.getParameter("idTT").toString());
		
		if(hinhAnh != "" )
		{
			TinTuc obj = tinTucDAO.getItemTinTuc(request.getParameter("idTT").toString());
			
			String nameOldUrlImage = obj.getHinhAnh();
			int i = nameOldUrlImage.lastIndexOf('/');
			nameOldUrlImage = nameOldUrlImage.substring(i + 1);
			
			String urlDel = path + File.separator + nameOldUrlImage;
			File delFile = new File(urlDel);
			delFile.delete();
		}
		
		Date date = new Date();
		java.sql.Date ngayDangTinTuc = new java.sql.Date(date.getTime());
		
		if(tieuDe.length() > 200 || tieuDe.length() == 0)
		{
			messageStr = "Tiêu Đề Không Được Phép Để Trống Hoặc Quá Dài";
		}
		else if(idLoaiTinTuc == 0)
		{
			messageStr = "Chưa Chọn Thể Loại Tin Tức";
		}
		else if(noiDung.trim() == null || noiDung.trim().length() == 0)
		{
			messageStr = "Chưa Nhập Nội Dung";
		}
		else if(quote.trim() == null || quote.trim().length() == 0 || quote.trim().length() > 500)
		{
			messageStr = "Chưa Nhập Trích Dẫn Hoặc Trích Dẫn Quá Dài";
		}
		else
		{
			TinTuc objTinTuc = new TinTuc(idTinTuc, tieuDe, noiDung, quote, id, url, ngayDangTinTuc, 0);
			
			if(tinTucDAO.checkEditTinTuc(objTinTuc, idLoaiTinTuc))
			{
				messageStr = "Sửa Thành Công";
			}
			else
			{
				messageStr = "Có Lỗi Xảy Ra";
			}
		}
		
		request.setAttribute("messageStr", messageStr);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/AdminShowManageTinTuc");
		dispatcher.forward(request, response);
	}
}


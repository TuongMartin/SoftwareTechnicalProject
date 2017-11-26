package library;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LibraryCheckCustomerPublic {
	public static boolean checkUser(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		if(session.getAttribute("sObjKHId") == null ){
			//chưa login, chuyển hướng sang trang login
			try {
				response.sendRedirect(request.getContextPath() + "/public/login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
}

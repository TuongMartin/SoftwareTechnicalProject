package library;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Account;

public class CheckRankLibrary {
	public static boolean isAdmin(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Account objUser = (Account) session.getAttribute("objUser");
		System.out.println("rank : " + objUser.getrole());
		if (!"admin".equalsIgnoreCase(objUser.getrole())) {
			return false;
		}
		return true;
	}
	
	public static boolean isSale(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		Account objUser = (Account) session.getAttribute("objUser");
		System.out.println("rank : " + objUser.getrole());
		if (!"Nhân viên".equalsIgnoreCase(objUser.getrole())) {
			return false;
		}
		return true;
	}
	
}

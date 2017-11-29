package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.LoaiKhachHang;

public class LoaiKhachHangDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public LoaiKhachHangDAO() {
		connectionLibraryMySQL= new ConnectionLibraryMySQL();
	}
	
	public ArrayList<LoaiKhachHang> loaikhachhangs() {
		ArrayList<LoaiKhachHang> lists=new ArrayList<LoaiKhachHang>();
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select * from loaikhachhang";
		try {
			st=conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				LoaiKhachHang ojkhachhang=new LoaiKhachHang(rs.getInt(1),rs.getString(2));
				lists.add(ojkhachhang);
			}
			st.close();
			conn.close();
			return lists;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import library.ConnectionLibraryMySQL;
import model.bean.KhachHang;

public class CustomersDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public CustomersDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}	
	
	public int numkhachhang(int idnhanvien){
		int numberkh=0;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select count(*) as number from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH where dangkycanho.Idnhanvien=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,idnhanvien);
			rs=ps.executeQuery();
			if(rs.next()){
				numberkh=rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberkh;
	}
	
}
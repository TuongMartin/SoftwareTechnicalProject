package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.NhanVien;
import model.bean.TuVan;


public class TuVanDAO{
	
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public TuVanDAO(){
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	
	public ArrayList<TuVan> getListTuVan(){
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT *,chucvu.TenChucVu AS chucvu FROM nhanvien INNER JOIN chucvu ON nhanvien.IdChucVu = chucvu.IdChucVu ORDER BY IdNhanVien DESC";
		ArrayList<TuVan> listTuVan = new ArrayList<>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				TuVan objTuVan = new TuVan(rs.getInt("idNK"), 
						rs.getString("idnhanvien"), 
						rs.getString("idkhachhang"), 
						rs.getString("noidung"),
						rs.getString("ngaytuvan"));
				listTuVan.add(objTuVan);
			}
			
			return listTuVan;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		} 
		finally {
			try {
				st.close();
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
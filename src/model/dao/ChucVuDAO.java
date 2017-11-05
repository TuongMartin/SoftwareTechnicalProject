package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.ChucVu;
import model.bean.NhanVien;

public class ChucVuDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ChucVuDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	public ArrayList<ChucVu> getListChucVu() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM chucvu";
		ArrayList<ChucVu> listChucVu = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ChucVu obj = new ChucVu(rs.getInt("IdChucVu"), rs.getString("TenChucVu"));
				listChucVu.add(obj);
			}
			return listChucVu;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public NhanVien getItemSale(int idNhanVien) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		NhanVien objSale = null;
		String sql = "SELECT *,chucvu.TenChucVu AS chucvu FROM nhanvien INNER JOIN chucvu ON nhanvien.IdChucVu = chucvu.IdChucVu WHERE IdNhanVien = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idNhanVien);
			rs = ps.executeQuery();
			if(rs.next()) {
				objSale = new NhanVien(rs.getInt("IdNhanVien"), rs.getString("TenNhanVien"), rs.getString("DiaChi"), rs.getString("QueQuan"), rs.getInt("CMND"), rs.getString("NgaySinh"),"", rs.getInt("IdChucVu"), rs.getString("TenChucVu"), rs.getString("avatar"),rs.getInt("idAccount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objSale;
	}
	
	
}

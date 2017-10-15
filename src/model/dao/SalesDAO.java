package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.NhanVien;

public class SalesDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public SalesDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	public ArrayList<NhanVien> getListUser() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT *,chucvu.TenChucVu AS chucvu FROM nhanvien INNER JOIN chucvu ON nhanvien.IdChucVu = chucvu.IdChucVu ORDER BY IdNhanVien DESC";
		ArrayList<NhanVien> listUser = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				NhanVien objUser = new NhanVien(rs.getInt("IdNhanVien"), rs.getString("TenNhanVien"), rs.getString("DiaChi"), rs.getString("QueQuan"), rs.getInt("CMND"), rs.getString("NgaySinh"),"", rs.getString("TenDangNhap"), "", rs.getInt("IdChucVu"), rs.getString("TenChucVu"), rs.getString("avatar"));
				listUser.add(objUser);
			}
			return listUser;
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
				objSale = new NhanVien(rs.getInt("IdNhanVien"), rs.getString("TenNhanVien"), rs.getString("DiaChi"), rs.getString("QueQuan"), rs.getInt("CMND"), rs.getString("NgaySinh"), rs.getString("SDT"), rs.getString("TenDangNhap"), "", rs.getInt("IdChucVu"), rs.getString("TenChucVu"), rs.getString("avatar"));
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
	
	public boolean editSale(NhanVien objSale) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE nhanvien SET TenNhanVien = ?,DiaChi = ?,QueQuan = ?,CMND = ?,NgaySinh = ?,SDT = ?,avatar = ? WHERE IdNhanVien = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objSale.getTenNhanVien());
			ps.setString(2, objSale.getDiaChi());
			ps.setString(3, objSale.getQueQuan());
			ps.setInt(4, objSale.getCMND());
			ps.setString(5, objSale.getNgaySinh());
			ps.setString(6, objSale.getSDT());
			ps.setString(7, objSale.getAvatar());
			ps.setInt(8, objSale.getIdNhanVien());
			ps.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean addItemSale(NhanVien objSale) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO NhanVien(IdNhanVien,TenNhanVien,DiaChi,QueQuan,CMND,NgaySinh,SDT,TenDangNhap,MatKhau,IdChucVu,avatar) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, objSale.getIdNhanVien());
			ps.setString(2, objSale.getTenNhanVien());
			ps.setString(3, objSale.getDiaChi());
			ps.setString(4, objSale.getQueQuan());
			ps.setInt(5, objSale.getCMND());
			ps.setString(6, objSale.getNgaySinh());
			ps.setString(7, objSale.getSDT());
			ps.setString(8, objSale.getTenDangNhap());
			ps.setString(9, objSale.getMatKhau());
			ps.setInt(10, objSale.getIdChucVu());
			ps.setString(11, objSale.getAvatar());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberkh;
	}
	
	public ArrayList<KhachHang> getkhachhangs(int idnhanvien,int start,int maxitem){
		ArrayList<KhachHang> khachhangs = new ArrayList<KhachHang>();
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select * from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH join loaikhachhang on khachhang.idKhachHang=loaikhachhang.IdLoaiKH where dangkycanho.Idnhanvien=? limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			ps.setInt(2, start);
			ps.setInt(3, maxitem);
			rs=ps.executeQuery();
			while(rs.next()){
				KhachHang currentkh = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"),
						rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"),
						rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"),
						rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"),
						rs.getInt("IdLoaiKH"),rs.getString("TenLoaiKH"),rs.getInt("IdTinDang"));
				khachhangs.add(currentkh);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachhangs;
	}
	
	public int searchkhcount(int idnhanvien,String key){
		int number=0;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select count(*) as number from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH where dangkycanho.IdNhanVien=? and khachhang.tenKhachHang LIKE '%"+key+"%'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			rs=ps.executeQuery();
			if(rs.next()){
				number = rs.getInt("number");
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	public ArrayList<KhachHang> searchkhachhang(int idnhanvien,int start,int maxitem,String key){
		ArrayList<KhachHang> khachhangs = new ArrayList<KhachHang>();
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select * from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH join loaikhachhang on khachhang.idKhachHang=loaikhachhang.IdLoaiKH where dangkycanho.Idnhanvien=? and khachhang.tenKhachHang like '%"+key+"%' limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			ps.setInt(2, start);
			ps.setInt(3, maxitem);
			rs=ps.executeQuery();
			while(rs.next()){
				KhachHang currentkh = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"),
						rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"),
						rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"),
						rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"),
						rs.getInt("IdLoaiKH"),rs.getString("TenLoaiKH"),rs.getInt("IdTinDang"));
				khachhangs.add(currentkh);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachhangs;
	}
	
	public boolean danhgiakhachhang(int id,int idloaikh) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "update khachhang set IdLoaiKH=? where idKhachHang=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idloaikh);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
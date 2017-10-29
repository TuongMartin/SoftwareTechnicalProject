package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

import model.bean.canho;
import library.ConnectionLibraryMySQL;

public class modelcanho {
	private Connection conn;
	private ConnectionLibraryMySQL connDB;
	//private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	private String table;
	public modelcanho(){
		connDB = new ConnectionLibraryMySQL();
		this.table = "tindang";
	}
	
	public int numbercanho(int idnhanvien){
		int number=0;
		conn = connDB.getConnectMySQL();
		String sql = "select count(*) as number from tindang where IdNhanVien=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idnhanvien);
			rs=pst.executeQuery();
			if(rs.next()){
				number = rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	
	public ArrayList<canho> getcanhosbyidnv(int idnhanvien,int start,int maxitem){
		ArrayList<canho> canhos = new ArrayList<canho>(); 
		conn = connDB.getConnectMySQL();
		String sql ="SELECT * FROM tindang INNER JOIN nhanvien on tindang.IdNhanVien=nhanvien.IdNhanVien JOIN trangthaitindang on tindang.IdTrangThai = trangthaitindang.IdTrangThaiTinDang JOIN loaitindang on tindang.IdLoaiTD=loaitindang.IdLoaiTinDang where tindang.IdNhanVien=? LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idnhanvien);
			pst.setInt(2,start);
			pst.setInt(3, maxitem);
			rs=pst.executeQuery();
			while(rs.next()){
				canho currentcanho = new canho(rs.getInt("IdTinDang"),rs.getString("TieuDe"),rs.getString("DiaChiTD"),
						rs.getInt("IdLoaiTD"),rs.getString("TenLoaiTinDang"),rs.getString("BanDo"),rs.getString("MaTienIch"),rs.getDouble("Gia"),
						rs.getInt("DienTich"),rs.getString("HuongNha"),rs.getString("HuongBanCong"),rs.getInt("SoPhongNgu"),
						rs.getInt("SoToilet"),rs.getString("NoiThat"),rs.getInt("MatTien"),rs.getInt("SoTang"),
						rs.getDate("NgayDang"),rs.getDate("NgayHetHan"),rs.getInt("IdNhanVien"),
						rs.getString("TenNhanVien"),rs.getInt("IdTrangThai"),rs.getString("TrangThaiTinDang"));
				canhos.add(currentcanho);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canhos;
	}
	public ArrayList<canho> searchcanho(int idnhanvien,int start,int maxitem,String key){
		ArrayList<canho> canhos = new ArrayList<canho>();
		conn = connDB.getConnectMySQL();
		String sql = "SELECT * FROM "+ table +" as tindang INNER JOIN nhanvien on tindang.IdNhanVien=nhanvien.IdNhanVien "
				+ "JOIN trangthaitindang on tindang.IdTrangThai = trangthaitindang.IdTrangThaiTinDang "
				+ "JOIN loaitindang on tindang.IdLoaiTD=loaitindang.IdLoaiTinDang where tindang.IdNhanVien=? and tindang.TieuDe like '%"+key+"%' limit ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idnhanvien);
			pst.setInt(2, start);
			pst.setInt(3, maxitem);
			rs=pst.executeQuery();
			while(rs.next()){
				canho currentcanho = new canho(rs.getInt("IdTinDang"),rs.getString("TieuDe"),rs.getString("DiaChiTD"),
						rs.getInt("IdLoaiTD"),rs.getString("TenLoaiTinDang"),rs.getString("BanDo"),rs.getString("MaTienIch"),rs.getDouble("Gia"),
						rs.getInt("DienTich"),rs.getString("HuongNha"),rs.getString("HuongBanCong"),rs.getInt("SoPhongNgu"),
						rs.getInt("SoToilet"),rs.getString("NoiThat"),rs.getInt("MatTien"),rs.getInt("SoTang"),
						rs.getDate("NgayDang"),rs.getDate("NgayHetHan"),rs.getInt("IdNhanVien"),
						rs.getString("TenNhanVien"),rs.getInt("IdTrangThai"),rs.getString("TrangThaiTinDang"));
				canhos.add(currentcanho);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canhos;
	}
	
	public int numbercanhosearch(int idnhanvien,String key){
		int number=0;
		conn = connDB.getConnectMySQL();
		String sql = "select count(*) as number from "+table+" where TieuDe LIKE '%"+key+"%' and IdNhanVien=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idnhanvien);
			rs=pst.executeQuery();
			if(rs.next()){
				number = rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.CanHo;

public class ApartmentDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public ApartmentDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	public int numbercanho(int idnhanvien){
		int number=0;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select count(*) as number from tindang where idNhanVien=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			rs=ps.executeQuery();
			if(rs.next()){
				number = rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	public ArrayList<CanHo> getcanhosbyidnv(int idnhanvien,int start,int maxitem){
		ArrayList<CanHo> canhos = new ArrayList<CanHo>(); 
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM tindang INNER JOIN nhanvien on tindang.idNhanVien=nhanvien.IdNhanVien JOIN loaitindang on tindang.idTheLoai=loaitindang.idTheLoai where tindang.idNhanVien=? LIMIT ?, ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			ps.setInt(2,start);
			ps.setInt(3, maxitem);
			rs=ps.executeQuery();
			while(rs.next()){
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("n.idNhanVien"), rs.getString("tenNV"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("l.idTheLoai"), rs.getString("tenTL"), rs.getInt("kichHoat"), rs.getInt("k.idKhuVuc"), rs.getString("tenKV"));
				canhos.add(objCanHo);
			}
			return canhos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<CanHo> searchcanho(int idnhanvien,int start,int maxitem,String key){
		ArrayList<CanHo> canhos = new ArrayList<CanHo>();
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * from tindang INNER JOIN nhanvien on tindang.idNhanVien=nhanvien.IdNhanVien JOIN loaitindang on tindang.idTheLoai=loaitindang.idTheLoai where tindang.idNhanVien=? and tindang.tenCanHo like '%"+key+"%' limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			ps.setInt(2, start);
			ps.setInt(3, maxitem);
			rs=ps.executeQuery();
			while(rs.next()){
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("n.idNhanVien"), rs.getString("tenNV"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("l.idTheLoai"), rs.getString("tenTL"), rs.getInt("kichHoat"), rs.getInt("k.idKhuVuc"), rs.getString("tenKV"));
				canhos.add(objCanHo);
			}
			return canhos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public int numbercanhosearch(int idnhanvien,String key){
		int number=0;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select count(*) as number from tindang where tenCanHo LIKE '%"+key+"%' and IdNhanVien=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			rs=ps.executeQuery();
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

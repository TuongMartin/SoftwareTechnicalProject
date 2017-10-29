package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

import model.bean.Khachhang;
import library.ConnectionLibraryMySQL;

public class Modelkhachhang {
	private Connection conn;
	private ConnectionLibraryMySQL connDB;
	//private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	public Modelkhachhang(){
		connDB = new ConnectionLibraryMySQL();
	}
	
	public ArrayList<Khachhang> getkhachhangs(int idnhanvien,int start,int maxitem){
		ArrayList<Khachhang> khachhangs = new ArrayList<Khachhang>(); 
		conn = connDB.getConnectMySQL();
		String sql = "select * from khachhang inner join dangkycanho on khachhang.IdKH=dangkycanho.IdKH join loaikhachhang on khachhang.IdLoaiKH=loaikhachhang.IdLoaiKH where dangkycanho.Idnhanvien=? limit ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,idnhanvien);
			pst.setInt(2,start);
			pst.setInt(3,maxitem);
			rs=pst.executeQuery();
			while(rs.next()){
				Khachhang currentkh = new Khachhang(rs.getInt("IdKH"),rs.getString("TenKH"),
						rs.getString("DiaChiKH"),rs.getString("SDTKH"),rs.getString("EmailKH"),
						rs.getInt("IdLoaiKH"),rs.getString("TenLoaiKH"),rs.getInt("IdTinDang"));
				khachhangs.add(currentkh);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachhangs;
	}
	
	public int numkhachhang(int idnhanvien){
		int numberkh=0;
		conn = connDB.getConnectMySQL();
		String sql = "select count(*) as number from khachhang inner join dangkycanho on khachhang.IdKH=dangkycanho.IdKH where dangkycanho.Idnhanvien=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,idnhanvien);
			rs=pst.executeQuery();
			if(rs.next()){
				numberkh=rs.getInt("number");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberkh;
	}
	public ArrayList<Khachhang> searchkhachhang(int idnhanvien,int start,int maxitem,String key){
		ArrayList<Khachhang> khachhangs = new ArrayList<Khachhang>();
		conn = connDB.getConnectMySQL();
		String sql = "select * from khachhang inner join dangkycanho on khachhang.IdKH=dangkycanho.IdKH join loaikhachhang on khachhang.IdLoaiKH=loaikhachhang.IdLoaiKH where dangkycanho.Idnhanvien=? and khachhang.TenKH like '%"+key+"%' limit ?,?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idnhanvien);
			pst.setInt(2, start);
			pst.setInt(3, maxitem);
			rs=pst.executeQuery();
			while(rs.next()){
				Khachhang currentkh = new Khachhang(rs.getInt("IdKH"),rs.getString("TenKH"),
					rs.getString("DiaChiKH"),rs.getString("SDTKH"),rs.getString("EmailKH"),
					rs.getInt("IdLoaiKH"),rs.getString("TenLoaiKH"),rs.getInt("IdTinDang"));
				khachhangs.add(currentkh);				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachhangs;
	}
	
	public int searchkhcount(int idnhanvien,String key){
		int number=0;
		conn = connDB.getConnectMySQL();
		String sql = "select count(*) as number from khachhang inner join dangkycanho on khachhang.IdKH=dangkycanho.IdKH where dangkycanho.IdNhanVien=? and khachhang.TenKH LIKE '%"+key+"%'";
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

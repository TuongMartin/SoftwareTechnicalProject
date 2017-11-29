package model.dao;

import java.sql.Array;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< HEAD
=======

import java.util.Date;
>>>>>>> master

import library.ConnectionLibraryMySQL;
import model.bean.CanHo;
import model.bean.KhuVucBDS;
<<<<<<< HEAD


=======
import model.bean.NhanVien;
import model.bean.TheLoaiBDS;
import model.bean.TinTuc;
>>>>>>> master
public class ApartmentDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public ApartmentDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
    this.table = "tindang";
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
			ps.close();
			conn.close();
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
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("idNhanVien"), rs.getString("TenNhanVien"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getInt("kichHoat"), rs.getInt("idKhuVuc"), "");
				canhos.add(objCanHo);
			}
			ps.close();
			conn.close();
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
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("idNhanVien"), rs.getString("TenNhanVien"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getInt("kichHoat"), rs.getInt("idKhuVuc"), "");				
				canhos.add(objCanHo);
			}
			ps.close();
			conn.close();
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
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
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
			ps.close();
			conn.close();
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
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("idNhanVien"), rs.getString("TenNhanVien"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getInt("kichHoat"), rs.getInt("idKhuVuc"), "");
				canhos.add(objCanHo);
			}
			ps.close();
			conn.close();
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
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("idNhanVien"), rs.getString("TenNhanVien"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getInt("kichHoat"), rs.getInt("idKhuVuc"), "");				
				canhos.add(objCanHo);
			}
			ps.close();
			conn.close();
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
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	public int countItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countApartment FROM " + table;
		int countApartment = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				countApartment = rs.getInt("countApartment");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return countApartment;
	}
	
	public ArrayList<CanHo> getItemPagition(int offset, int row_count) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT *,n.TenNhanVien as tenNV,l.tenTheLoai as tenTL,k.tenKhuVuc as tenKV FROM " + table + " as c INNER JOIN nhanvien as n ON n.IdNhanVien = c.idNhanVien INNER JOIN loaitindang as l ON l.idTheLoai = c.idTheLoai INNER JOIN khuvuc as k ON k.idKhuVuc = c.idKhuVuc LIMIT ?,?";
		ArrayList<CanHo> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, row_count);
			rs = ps.executeQuery();
			
			while(rs.next()){
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("n.idNhanVien"), rs.getString("tenNV"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("l.idTheLoai"), rs.getString("tenTL"), rs.getInt("kichHoat"), rs.getInt("k.idKhuVuc"), rs.getString("tenKV"));
				list.add(objCanHo);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Object getItemAreaRealEstatebyName(String khuvuc) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		KhuVucBDS objKhuVuc = null;
		String sql = "SELECT * FROM " + table  + " WHERE tenKhuVuc = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, khuvuc);
			rs = ps.executeQuery();
			if(rs.next()) {
				objKhuVuc = new KhuVucBDS(rs.getInt("idKhuVuc"), rs.getString("tenKhuVuc"), rs.getString("image"));
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
		return objKhuVuc;
	}

	public boolean addItemApartment(CanHo objCanHo) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO " + table + "(tenCanHo,diaChi,dienTich,giaTien,totalRooms,bedRooms,bathRooms,moTa,buildingAge,parking,cooling,heating,sewer,water,exerciseRoom,storageRoom,idNhanVien,ngayDang,idTheLoai,idKhuVuc) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objCanHo.getTen());
			ps.setString(2,	objCanHo.getDiachi());
			ps.setInt(3, objCanHo.getDientich());
			ps.setInt(4, objCanHo.getGiatien());
			ps.setInt(5, objCanHo.getSophong());
			ps.setInt(6, objCanHo.getSophongngu());
			ps.setInt(7, objCanHo.getSophongtam());
			ps.setString(8, objCanHo.getMota());
			ps.setInt(9, objCanHo.getTuoi());
			ps.setString(10, objCanHo.getParking());
			ps.setString(11, objCanHo.getCooling());
			ps.setString(12, objCanHo.getHeating());
			ps.setString(13, objCanHo.getSewer());
			ps.setString(14, objCanHo.getWater());
			ps.setInt(15, objCanHo.getPhongtap());
			ps.setInt(16, objCanHo.getNhakho());
			ps.setInt(17, objCanHo.getIdnhanvien());
			ps.setString(18, objCanHo.getNgaydang());
			ps.setInt(19, objCanHo.getIdtheloai());
			ps.setInt(20, objCanHo.getIdkhuvuc());
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
	
	public void updateApartmentStatus(int aid, int astatus) {
		int status = astatus == 1 ? 0 : 1;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE tindang SET kichHoat = ? WHERE idTinDang = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, aid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public CanHo getItemApartmentByIdActive(int aid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		CanHo objCanHo = null;
		String sql = "SELECT * FROM " + table + " WHERE idTinDang = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			if(rs.next()) {
				objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getInt("kichHoat"));
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
		return objCanHo;
	}
	
	public CanHo getItemApartmentById(int aid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		CanHo objCanHo = null;
		String sql = "SELECT *,n.TenNhanVien as tenNV,l.tenTheLoai as tenTL,k.tenKhuVuc as tenKV FROM " + table + " as c INNER JOIN nhanvien as n ON n.IdNhanVien = c.idNhanVien INNER JOIN loaitindang as l ON l.idTheLoai = c.idTheLoai INNER JOIN khuvuc as k ON k.idKhuVuc = c.idKhuVuc WHERE idTinDang = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			if(rs.next()) {
				objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("n.idNhanVien"), rs.getString("tenNV"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("l.idTheLoai"), rs.getString("tenTL"), rs.getInt("kichHoat"), rs.getInt("k.idKhuVuc"), rs.getString("tenKV"));
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
		return objCanHo;
	}

	public boolean eidtItemApartment(CanHo objCanHo) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE " + table + " SET tenCanHo = ?, diaChi = ?, dienTich = ?, giaTien = ?, totalRooms = ?, bedRooms = ?, bathRooms = ?, moTa = ?, buildingAge = ?, parking = ?, cooling = ?, heating = ?, sewer = ?, water = ?, exerciseRoom = ?, storageRoom = ?, idNhanVien = ?, trangThai = ?, idTheLoai = ?, idKhuVuc = ? WHERE idTinDang = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objCanHo.getTen());
			ps.setString(2, objCanHo.getDiachi());
			ps.setInt(3, objCanHo.getDientich());
			ps.setInt(4, objCanHo.getGiatien());
			ps.setInt(5, objCanHo.getSophong());
			ps.setInt(6, objCanHo.getSophongngu());
			ps.setInt(7, objCanHo.getSophongtam());
			ps.setString(8, objCanHo.getMota());
			ps.setInt(9, objCanHo.getTuoi());
			ps.setString(10, objCanHo.getParking());
			ps.setString(11, objCanHo.getCooling());
			ps.setString(12, objCanHo.getHeating());
			ps.setString(13, objCanHo.getSewer());
			ps.setString(14, objCanHo.getWater());
			ps.setInt(15, objCanHo.getPhongtap());
			ps.setInt(16, objCanHo.getNhakho());
			ps.setInt(17, objCanHo.getIdnhanvien());
			ps.setInt(18, objCanHo.getTrangthai());
			ps.setInt(19, objCanHo.getIdtheloai());
			ps.setInt(20, objCanHo.getIdkhuvuc());
			ps.setInt(21, objCanHo.getId());
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

	public boolean delItemApartment(int aid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " where idTinDang = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
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

	public void delApartmentByIDRealEstate(int rid) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " WHERE idTheLoai = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
<<<<<<< HEAD
=======

>>>>>>> master
	}

	public CanHo getItemApartmentLatest() {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table + " ORDER BY idTinDang DESC LIMIT 1";
		CanHo objCanHo = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getInt("kichHoat"));
			}
			return objCanHo;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void delApartmentByIDArea(int aid) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " WHERE idKhuVuc = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
<<<<<<< HEAD
=======

>>>>>>> master
	public ArrayList<CanHo> searchApartment(int idCanHo, String tenCanHo) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<CanHo> list = new ArrayList<>();
		String sql = "";
		if(tenCanHo.trim().equals("")) {
			sql = "SELECT *,n.TenNhanVien as tenNV,l.tenTheLoai as tenTL,k.tenKhuVuc as tenKV FROM " + table + " as c INNER JOIN nhanvien as n ON n.IdNhanVien = c.idNhanVien INNER JOIN loaitindang as l ON l.idTheLoai = c.idTheLoai INNER JOIN khuvuc as k ON k.idKhuVuc = c.idKhuVuc WHERE idTinDang = ?";
		}else if(idCanHo == 0) {
			sql = "SELECT *,n.TenNhanVien as tenNV,l.tenTheLoai as tenTL,k.tenKhuVuc as tenKV FROM " + table + " as c INNER JOIN nhanvien as n ON n.IdNhanVien = c.idNhanVien INNER JOIN loaitindang as l ON l.idTheLoai = c.idTheLoai INNER JOIN khuvuc as k ON k.idKhuVuc = c.idKhuVuc WHERE tenCanHo LIKE '%"+ tenCanHo +"%' ORDER BY idTinDang DESC";
		}else {
			sql = "SELECT *,n.TenNhanVien as tenNV,l.tenTheLoai as tenTL,k.tenKhuVuc as tenKV FROM " + table + " as c INNER JOIN nhanvien as n ON n.IdNhanVien = c.idNhanVien INNER JOIN loaitindang as l ON l.idTheLoai = c.idTheLoai INNER JOIN khuvuc as k ON k.idKhuVuc = c.idKhuVuc WHERE tenCanHo LIKE '%"+ tenCanHo +"%' AND idTinDang = ? ORDER BY IdTinDang DESC";
		}
		try {
			ps = conn.prepareStatement(sql);
			if(idCanHo != 0){
				ps.setInt(1, idCanHo);
			}
			rs = ps.executeQuery();
			
			while(rs.next()){
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("n.idNhanVien"), rs.getString("tenNV"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("l.idTheLoai"), rs.getString("tenTL"), rs.getInt("kichHoat"), rs.getInt("k.idKhuVuc"), rs.getString("tenKV"));
				list.add(objCanHo);
			}
			if(list.size() > 0) {
				return list;
			}else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
<<<<<<< HEAD
=======

>>>>>>> master
	public ArrayList<CanHo> getItemApartmentNewLy() {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT *,n.TenNhanVien as tenNV,l.tenTheLoai as tenTL,k.tenKhuVuc as tenKV FROM " + table + " as c INNER JOIN nhanvien as n ON n.IdNhanVien = c.idNhanVien INNER JOIN loaitindang as l ON l.idTheLoai = c.idTheLoai INNER JOIN khuvuc as k ON k.idKhuVuc = c.idKhuVuc WHERE kichHoat = 1 ORDER BY c.idTinDang DESC LIMIT 3";
		ArrayList<CanHo> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				CanHo objCanHo = new CanHo(rs.getInt("idTinDang"), rs.getString("tenCanHo"), rs.getString("diaChi"), rs.getInt("dienTich"), rs.getInt("giaTien"), rs.getInt("totalRooms"), rs.getInt("bedRooms"), rs.getInt("bathRooms"), rs.getString("moTa"), rs.getInt("buildingAge"), rs.getString("parking"), rs.getString("cooling"), rs.getString("heating"), rs.getString("sewer"), rs.getString("water"), rs.getInt("exerciseRoom"), rs.getInt("storageRoom"), rs.getInt("n.idNhanVien"), rs.getString("tenNV"), rs.getInt("trangThai"), rs.getString("ngayDang"), rs.getInt("l.idTheLoai"), rs.getString("tenTL"), rs.getInt("kichHoat"), rs.getInt("k.idKhuVuc"), rs.getString("tenKV"));
				list.add(objCanHo);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}

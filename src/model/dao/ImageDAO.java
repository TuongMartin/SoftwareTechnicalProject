package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.CanHo;
import model.bean.Image;

public class ImageDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement st;
	private String table;
	
	public ImageDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
		this.table = "hinhanh";
	}
	
	public boolean addItemImage(String hinhanh) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO " + table + "(hinhanh,idCanHo) VALUES(?,?)";
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		CanHo objCanHo = apartmentDAO.getItemApartmentLatest();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hinhanh);
			ps.setInt(2, objCanHo.getId());
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
	
	public boolean updateItemImage(String hinhanh, int id) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		int iid = 0;
		String sql = "UPDATE " + table + " SET hinhAnh = ? WHERE idCanHo = ? AND idHinhAnh = ? ";
		String sql2 = "SELECT idHinhAnh as id FROM " + table + " WHERE idCanHo = ? ORDER BY idHinhAnh ASC LIMIT 1";
		try {
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				iid = rs.getInt("id"); 
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, hinhanh);
			ps.setInt(2, id);
			ps.setInt(3, iid);
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
	
	public boolean uploadImageApartment(String hinhanh, int aid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO " + table + "(hinhanh,idCanHo) VALUES(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, hinhanh);
			ps.setInt(2, aid);
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
	
	public Image getItemImage(int idCanHo) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		Image obj = null;
		String sql = "SELECT * FROM " + table + " WHERE idCanHo = ? LIMIT 1";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCanHo);
			rs = ps.executeQuery();
			if(rs.next()) {
				obj = new Image(rs.getInt("idHinhAnh"), rs.getString("hinhAnh"), rs.getInt("idCanHo"));
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
		return obj;
	}
	
	public ArrayList<Image> getListItemImageForApartmentNewly(int idCanHo) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<Image> list = new ArrayList<>();
		String sql = "SELECT * FROM " + table + " WHERE idCanHo = ? LIMIT 2";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCanHo);
			rs = ps.executeQuery();
			while(rs.next()) {
				Image obj = new Image(rs.getInt("idHinhAnh"), rs.getString("hinhAnh"), rs.getInt("idCanHo"));
				list.add(obj);
			}
			return list;
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
		return null;
	}
	
	public ArrayList<Image> getListItemImage(int idCanHo) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<Image> list = new ArrayList<>();
		String sql = "SELECT * FROM " + table + " WHERE idCanHo = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCanHo);
			rs = ps.executeQuery();
			if(rs.next()) {
				Image obj = new Image(rs.getInt("idHinhAnh"), rs.getString("hinhAnh"), rs.getInt("idCanHo"));
				list.add(obj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return list;
	}
	
	public void delItemImageByIdApartment(int aid) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " WHERE idCanHo = ?";
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

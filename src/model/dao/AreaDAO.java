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
import model.bean.KhuVucBDS;
import model.bean.NhanVien;
import model.bean.TheLoaiBDS;

public class AreaDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public AreaDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
		this.table = "khuvuc";
	}
	
	public int countItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countArea FROM " + table;
		int countArea = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				countArea = rs.getInt("countArea");
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
		return countArea;
	}
	
	public ArrayList<KhuVucBDS> getItemPagition(int offset, int row_count) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table + " LIMIT ?,?";
		ArrayList<KhuVucBDS> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, row_count);
			rs = ps.executeQuery();
			
			while(rs.next()){
				KhuVucBDS objKhuVuc = new KhuVucBDS(rs.getInt("idKhuVuc"), rs.getString("tenKhuVuc"), rs.getString("image"));
				list.add(objKhuVuc);
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

	public boolean addItemAreaRealEstate(KhuVucBDS objKhuVuc) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO " + table + "(tenKhuVuc,image) VALUES(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objKhuVuc.getTen());
			ps.setString(2, objKhuVuc.getImage());
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

	public KhuVucBDS getItemAreaRealEstateById(int aid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		KhuVucBDS objKhuVuc = null;
		String sql = "SELECT * FROM " + table + " WHERE idKhuVuc = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
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

	public boolean editItemAreaRealEstate(KhuVucBDS objKhuVuc) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE " + table + " SET tenKhuVuc = ?, image = ? WHERE idKhuVuc = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objKhuVuc.getTen());
			ps.setString(2, objKhuVuc.getImage());
			ps.setInt(3, objKhuVuc.getId());
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

	public boolean delItemAreaRealEstate(int aid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " where idKhuVuc = ?";
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

	public ArrayList<KhuVucBDS> getItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table;
		ArrayList<KhuVucBDS> listKhuVuc = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				KhuVucBDS objKhuVuc = new KhuVucBDS(rs.getInt("idKhuVuc"), rs.getString("tenKhuVuc"), rs.getString("image"));
				listKhuVuc.add(objKhuVuc);
			}
			return listKhuVuc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

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
import model.bean.NhanVien;
import model.bean.TheLoaiBDS;

public class RealEstateDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public RealEstateDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
		this.table = "loaitindang";
	}
	
	public int countItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countRealEstate FROM " + table;
		int countRealEstate = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				countRealEstate = rs.getInt("countRealEstate");
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
		return countRealEstate;
	}
	
	public ArrayList<TheLoaiBDS> getItemPagition(int offset, int row_count) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table + " LIMIT ?,?";
		ArrayList<TheLoaiBDS> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, row_count);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TheLoaiBDS objTheLoai = new TheLoaiBDS(rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getString("image"));
				list.add(objTheLoai);
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

	public Object getItemRealEstatebyName(String theloai) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		TheLoaiBDS objTheLoai = null;
		String sql = "SELECT * FROM " + table  + " WHERE tenTheLoai = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, theloai);
			rs = ps.executeQuery();
			if(rs.next()) {
				objTheLoai = new TheLoaiBDS(rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getString("image"));
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
		return objTheLoai;
	}
	
	public Object getItemRealEstatebyNameEdit(String theloai, int id) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		TheLoaiBDS objTheLoai = null;
		String sql = "SELECT * FROM " + table  + " WHERE tenTheLoai = ? AND idTheLoai NOT IN (?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, theloai);
			ps.setInt(2, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				objTheLoai = new TheLoaiBDS(rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getString("image"));
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
		return objTheLoai;
	}

	public boolean addItemRealEstate(TheLoaiBDS objTheLoai) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO " + table + "(tenTheLoai,image) VALUES(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objTheLoai.getTen());
			ps.setString(2, objTheLoai.getImage());
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

	public TheLoaiBDS getItemRealEstateByid(int rid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		TheLoaiBDS objTheLoai = null;
		String sql = "SELECT * FROM " + table + " WHERE idTheLoai = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
			rs = ps.executeQuery();
			if(rs.next()) {
				objTheLoai = new TheLoaiBDS(rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getString("image"));
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
		return objTheLoai;
	}

	public boolean editItemRealEstate(TheLoaiBDS objTheLoai) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE " + table + " SET tenTheLoai = ?, image = ? WHERE idTheLoai = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objTheLoai.getTen());
			ps.setString(2, objTheLoai.getImage());
			ps.setInt(3, objTheLoai.getId());
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

	public boolean delItemRealEstate(int rid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " where idTheLoai = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, rid);
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
	
	public ArrayList<TheLoaiBDS> getItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table;
		ArrayList<TheLoaiBDS> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TheLoaiBDS objTheLoai = new TheLoaiBDS(rs.getInt("idTheLoai"), rs.getString("tenTheLoai"), rs.getString("image"));
				list.add(objTheLoai);
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
}

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
import model.bean.TienIch;

public class FeatureDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public FeatureDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
		this.table = "tienich";
	}
	
	public int countItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countFeature FROM " + table;
		int countFeature = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				countFeature = rs.getInt("countFeature");
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
		return countFeature;
	}
	
	public ArrayList<TienIch> getItemPagition(int offset, int row_count) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table + " LIMIT ?,?";
		ArrayList<TienIch> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, row_count);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TienIch objTienIch = new TienIch(rs.getInt("idTienIch"), rs.getString("tenTienIch"));
				list.add(objTienIch);
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

	public Object getItemFeatureByName(String tienich) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		TienIch objTienIch = null;
		String sql = "SELECT * FROM " + table  + " WHERE tenTienIch = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tienich);
			rs = ps.executeQuery();
			if(rs.next()) {
				objTienIch = new TienIch(rs.getInt("idTienIch"), rs.getString("tenTienIch"));
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
		return objTienIch;
	}
	
	public Object getItemFeatureByNameEdit(String tienich, int id) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		TienIch objTienIch = null;
		String sql = "SELECT * FROM " + table  + " WHERE tenTienIch = ? AND idTienIch NOT IN (?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tienich);
			ps.setInt(2, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				objTienIch = new TienIch(rs.getInt("idTienIch"), rs.getString("tenTienIch"));
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
		return objTienIch;
	}

	public boolean addItemFeature(TienIch objTienIch) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO " + table + "(tenTienIch) VALUES(?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objTienIch.getTenTienIch());
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

	public TienIch getItemFeatureById(int fid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		TienIch objTienIch = null;
		String sql = "SELECT * FROM " + table + " WHERE idTienIch = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
			rs = ps.executeQuery();
			if(rs.next()) {
				objTienIch = new TienIch(rs.getInt("idTienIch"), rs.getString("tenTienIch"));
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
		return objTienIch;
	}

	public boolean editItemFeature(TienIch objTienIch) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE " + table + " SET tenTienIch = ? WHERE idTienIch = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objTienIch.getTenTienIch());
			ps.setInt(2, objTienIch.getIdTienIch());
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

	public boolean delItemFeature(int rid) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " where idTienIch = ?";
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
	
	public ArrayList<TienIch> getItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table;
		ArrayList<TienIch> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				TienIch objTienIch = new TienIch(rs.getInt("idTienIch"), rs.getString("tenTienIch"));
				list.add(objTienIch);
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

	public ArrayList<TienIch> getFeatureApartment(int aid) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM tienich INNER JOIN tienich_canho ON tienich_canho.idTienIch = tienich.idTienIch WHERE tienich_canho.idTinDang = ?";
		ArrayList<TienIch> listTienIch = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, aid);
			rs = ps.executeQuery();
			while(rs.next()) {
				TienIch objTienIch = new TienIch(rs.getInt("idTienIch"), rs.getString("tenTienIch"));
				listTienIch.add(objTienIch);
			}
			return listTienIch;
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
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.ItemAgenda;

public class ItemAgendaDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Statement st;
	
	public ItemAgendaDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	public boolean addItemAgenda(ItemAgenda obj) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO itemagenda(startTime,endTime,title,idAgenda) VALUES(?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getStartTime());
			ps.setInt(2, obj.getEndTime());
			ps.setString(3, obj.getTitle());
			ps.setInt(4, obj.getIdAgenda());
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
	
	public boolean delItemAgenda(int idItemAgenda) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM itemagenda where idItemAgenda = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idItemAgenda);
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
	
	public ItemAgenda getItemAgenda(int idItemAgenda) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ItemAgenda obj = null;
		String sql = "SELECT * FROM itemagenda WHERE idItemAgenda = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idItemAgenda);
			rs = ps.executeQuery();
			if(rs.next()) {
				obj = new ItemAgenda(rs.getInt("idAgenda"), 0 , 0, rs.getInt("idItemAgenda"), rs.getString("title"), rs.getInt("startTime"), rs.getInt("endTime"));
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
	
	public boolean delItemAgenda() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM itemagenda";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
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
	
	public ArrayList<ItemAgenda> getListItemAgenda(int idAgenda) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<ItemAgenda> list = new ArrayList<>();
		String sql = "SELECT * FROM itemagenda WHERE idAgenda = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idAgenda);
			rs = ps.executeQuery();
			if(rs.next()) {
				ItemAgenda obj = new ItemAgenda(rs.getInt("idAgenda"), 0 , 0, rs.getInt("idItemAgenda"), rs.getString("title"), rs.getInt("startTime"), rs.getInt("endTime"));
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
}

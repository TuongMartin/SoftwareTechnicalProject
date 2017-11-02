package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.Agenda;
import model.bean.ItemAgenda;

public class AgendaDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public AgendaDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	public ArrayList<ItemAgenda> getListAgendaSale(int idSales) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT a.idAgenda,a.day,a.idSales,i.idItemAgenda,i.startTime,i.endTime,i.title  FROM agenda as a INNER JOIN itemagenda as i ON a.idAgenda = i.idAgenda WHERE a.idSales = " + idSales;
		ArrayList<ItemAgenda> list = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				ItemAgenda obj = new ItemAgenda(rs.getInt("idAgenda"), rs.getInt("day"), rs.getInt("idSales"), rs.getInt("idItemAgenda"), rs.getString("title"), rs.getInt("startTime"), rs.getInt("endTime"));
				list.add(obj);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean addAgenda(Agenda obj) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO agenda(day,idSales) VALUES(?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, obj.getDay());
			ps.setInt(2, obj.getIdSale());
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
	
	public int getNewAgenda() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT *  FROM agenda ORDER BY idAgenda DESC LIMIT 0,1";
		int idNewAgenda = 0;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			   idNewAgenda = rs.getInt("idAgenda");
			}
			return idNewAgenda;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean delAgenda() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM agenda";
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
	
	public boolean delAgenda(int idAgenda) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM agenda where idAgenda = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idAgenda);
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

}

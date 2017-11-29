package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import library.ConnectionLibraryMySQL;
import model.bean.CanHo;

public class FeatureApartmentDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public FeatureApartmentDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
		this.table = "tienich_canho";
	}

	public void addFeatureApartment(String[] tienich) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		int idTienIch = 0;
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		CanHo objCanHo = apartmentDAO.getItemApartmentLatest();
		for(int i = 0; i< tienich.length; i++) {
			idTienIch = Integer.parseInt(tienich[i]);
			String sql = "INSERT INTO " + table + "(idTienIch,idTinDang) VALUES(?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, idTienIch);
				ps.setInt(2, objCanHo.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delItemFeatureByIdApartment(int aid) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " WHERE idTinDang = ?";
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

	public void editFeatureApartmentByIdApartment(int aid, String[] new_tienich) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		FeatureApartmentDAO feature_apartmentDAO = new FeatureApartmentDAO();
		feature_apartmentDAO.delItemFeatureByIdApartment(aid);
		ApartmentDAO apartmentDAO = new ApartmentDAO();
		CanHo objCanHo = apartmentDAO.getItemApartmentById(aid);
		int idTienIch = 0;
		for(int i = 0; i< new_tienich.length; i++) {
			idTienIch = Integer.parseInt(new_tienich[i]);
			String sql = "INSERT INTO " + table + "(idTienIch,idTinDang) VALUES(?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, idTienIch);
				ps.setInt(2, objCanHo.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delFeatureApartmentByIDFeature(int fid) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM " + table + " WHERE idTienIch = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fid);
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

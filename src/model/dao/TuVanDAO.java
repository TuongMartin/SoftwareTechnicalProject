package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.TuVan;


public class TuVanDAO{
	
	private static final String QUERY_NHAT_KY_TU_VAN = "select * from nhatkytuvan";
	private static final String INSERT_NHAT_KY_TU_VAN = "insert into nhatkytuvan values(?, ?, ?, ?, ?)";
	private static final String ID_NK = "IdNK";
	private static final String ID_NHAN_VIEN = "idnhanvien";
	private static final String ID_KHACH_HANG = "idKhachHang";
	private static final String NOI_DUNG = "noidung";
	private static final String NGAY_TU_VAN = "ngaytuvan";
	
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public TuVanDAO(){
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	
	public ArrayList<TuVan> getListTuVan(){
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TuVan> listTuVan = new ArrayList<>();
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(QUERY_NHAT_KY_TU_VAN);
			
			while(rs.next()) {
				TuVan objTuVan = new TuVan(rs.getInt(ID_NK), 
						rs.getInt(ID_NHAN_VIEN), 
						rs.getInt(ID_KHACH_HANG), 
						rs.getString(NOI_DUNG),
						rs.getString(NGAY_TU_VAN));
				listTuVan.add(objTuVan);
			}
		
			return listTuVan;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return null;
		} 
		finally 
		{
			try 
			{
				st.close();
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public boolean addNhatKyTuVan(TuVan objTuVan){
		conn = connectionLibraryMySQL.getConnectMySQL();
		try 
		{
			ps = conn.prepareStatement(INSERT_NHAT_KY_TU_VAN);
			ps.setInt(1, objTuVan.getIdNK());
			ps.setInt(2, objTuVan.getIdNhanVien());
			ps.setInt(3, objTuVan.getIdKhachHang());
			ps.setString(4, objTuVan.getNoiDungTuVan());
			ps.setString(5, objTuVan.getNgayTuVan());
			ps.executeUpdate();
			return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return false;
		} 
		finally 
		{
			try 
			{
				ps.close();
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
}
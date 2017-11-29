package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.TheLoaiTinTuc;

public class TheLoaiTinTucDAO {
	
	private static final String SELECT_ALL_LOAI_TIN_TUC = "select * from phanloaitintuc";
	private static final String SELECT_BY_TEN_LOAI_TIN_TUC = "select * from phanloaitintuc where loaitintuc = ";
	private static final String LOAI_TIN_TUC = "loaitintuc";
	private static final String ID_LOAI_TIN_TUC = "idphanloaitintuc";
	
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	
	
	public TheLoaiTinTucDAO(){
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	
	public ArrayList<TheLoaiTinTuc> getLoaiTinTuc(){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TheLoaiTinTuc> listLoaiTinTuc = new ArrayList<TheLoaiTinTuc>();
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL_LOAI_TIN_TUC);
			
			while(rs.next()) {
				TheLoaiTinTuc obj = new TheLoaiTinTuc(
						rs.getInt(ID_LOAI_TIN_TUC), 
						rs.getString(LOAI_TIN_TUC));
				
				listLoaiTinTuc.add(obj);
			}
		
			return listLoaiTinTuc;
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
	
	
	public int getIdLoaiTinTuc(String loaiTinTuc){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		int idLoaiTinTuc = 0;
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_BY_TEN_LOAI_TIN_TUC + loaiTinTuc);
			
			while(rs.next()) {
				idLoaiTinTuc = rs.getInt(ID_LOAI_TIN_TUC);
			}
		
			return idLoaiTinTuc;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return idLoaiTinTuc;
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
}

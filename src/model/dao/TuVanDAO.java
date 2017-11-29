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
	
	private static final String SELECT_NHAT_KY_TU_VAN = "select * from nhatkytuvan";
	private static final String INSERT_NHAT_KY_TU_VAN = "insert into nhatkytuvan(idnhanvien, tenkhachhangcantuvan, sdt, noidung, ngaytuvan) values(?, ?, ?, ?, ?)";
	private static final String COUNT_RECORD_NHAT_KY_TU_VAN = "select count(*) as countRecord from nhatkytuvan";
	private static final String SELECT_LIST_NOI_DUNG_EACH_PAGE = "select * from nhatkytuvan limit ?, ?";
	
	private static final String ID_NHAN_VIEN = "idnhanvien";
	private static final String TEN_KHACH_HANG = "tenkhachhangcantuvan";
	private static final String SDT = "SDT";
	private static final String NOI_DUNG = "noidung";
	private static final String NGAY_TU_VAN = "NgayTuVan";
	
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
			rs = st.executeQuery(SELECT_NHAT_KY_TU_VAN);
			
			while(rs.next()) {
				TuVan objTuVan = new TuVan(rs.getInt(ID_NHAN_VIEN), 
						rs.getString(TEN_KHACH_HANG),
						rs.getString(SDT),
						rs.getString(NOI_DUNG),
						rs.getDate(NGAY_TU_VAN));
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
	
	
	public ArrayList<TuVan> getListNoiDungTuVanEachPage(int offset, int numberItemEachPage){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TuVan> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(SELECT_LIST_NOI_DUNG_EACH_PAGE);
			ps.setInt(1, offset);
			ps.setInt(2, numberItemEachPage);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TuVan objTuVan = new TuVan(rs.getInt(ID_NHAN_VIEN), 
						rs.getString(TEN_KHACH_HANG), 
						rs.getString(SDT), 
						rs.getString(NOI_DUNG), 
						rs.getDate(NGAY_TU_VAN));
				list.add(objTuVan);
			}
			
			return list;
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
				ps.close();
				conn.close();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public int countRecordNhatKyTuVan(){
		conn = connectionLibraryMySQL.getConnectMySQL();
		int count = 0;
		
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(COUNT_RECORD_NHAT_KY_TU_VAN);
			while(rs.next())
			{
				count = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}
	
	
	public boolean checkAddNhatKyTuVan(TuVan objTuVan){
		conn = connectionLibraryMySQL.getConnectMySQL();
		try 
		{
			ps = conn.prepareStatement(INSERT_NHAT_KY_TU_VAN);
			ps.setInt(1, objTuVan.getIdNhanVien());
			ps.setString(2, objTuVan.getTenKhachHang());
			ps.setString(3, objTuVan.getSDT());
			ps.setString(4, objTuVan.getNoiDungTuVan());
			ps.setDate(5, objTuVan.getNgayTuVan());
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
package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.javafx.geom.transform.GeneralTransform3D;

import library.ConnectionLibraryMySQL;
import model.bean.NhanVien;
import model.bean.TinTuc;
import model.bean.TuVan;

public class TinTucDAO {
	
	private static final String SELECT_ALL_RECORD_TABLE_TIN_TUC = "select * from tintuc";
	private static final String SELECT_LIST_TIN_TUC_EACH_PAGE = "select * from tintuc limit ?, ?";
	private static final String COUNT_RECORD_TIN_TUC = "select count(*) as countTinTuc from tintuc";
	
	private static final String TIEU_DE = "tieude";
	private static final String NOI_DUNG = "noidung";
	private static final String QUOTE = "quote";
	private static final String HINH_ANH = "hinhanh";
	private static final String NGAY_DANG_TIN = "ngaydangtin";
	
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public TinTucDAO(){
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
	}
	
	
	public ArrayList<TinTuc> getListTuVan(){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> listTinTuc = new ArrayList<>();
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ALL_RECORD_TABLE_TIN_TUC);
			
			while(rs.next()) {
				TinTuc objTinTuc = new TinTuc(rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG),
						rs.getString(QUOTE),
						rs.getString(HINH_ANH),
						rs.getDate(NGAY_DANG_TIN));
				listTinTuc.add(objTinTuc);
			}
		
			return listTinTuc;
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
	
	
	public ArrayList<TinTuc> getListNoiDungTuVanEachPage(int offset, int numberItemEachPage){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(SELECT_LIST_TIN_TUC_EACH_PAGE);
			ps.setInt(1, offset);
			ps.setInt(2, numberItemEachPage);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TinTuc objTinTuc = new TinTuc(rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE), 
						rs.getString(HINH_ANH), 
						rs.getDate(NGAY_DANG_TIN));
				list.add(objTinTuc);
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

	
	public int countRecordTinTuc(){
		conn = connectionLibraryMySQL.getConnectMySQL();
		int count = 0;
		
		try
		{
			st = conn.createStatement();
			rs = st.executeQuery(COUNT_RECORD_TIN_TUC);
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
}

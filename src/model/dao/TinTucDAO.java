package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.TinTuc;


public class TinTucDAO {
	
	private static final String SELECT_ALL_RECORD_TABLE_TIN_TUC = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc ";
	private static final String SELECT_LIST_TIN_TUC_EACH_PAGE = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc  limit ?, ?";
	private static final String COUNT_RECORD_TIN_TUC = "SELECT count(*) as countTinTuc from tintuc";
	private static final String SEARCH_TIN_TUC = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc  where tieude like ";
	private static final String SELECT_RECORD_BY_ID = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc  where idtintuc = ";
	private static final String INSERT_TIN_TUC = "INSERT INTO tintuc(tieude, noidung, quote, idphanloaitintuc, hinhanh, ngaydangtin) VALUES(?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_TIN_TUC = "UPDATE tintuc SET tieude = ?, noidung = ?, quote = ?, idphanloaitintuc = ?, hinhanh = ?, ngaydangtin = ? WHERE idtintuc = ?";
	private static final String SELECT_ID_LOAI_TIN_TUC = "select idphanloaitintuc from tintuc where idtintuc = ";
	private static final String DEL_TIN_TUC = "DELETE FROM tintuc where idtintuc = ?";
	
	private static final String ID_TIN_TUC = "idtintuc";
	private static final String TIEU_DE = "tieude";
	private static final String NOI_DUNG = "noidung";
	private static final String QUOTE = "quote";
	private static final String LOAI_TT = "loaitintuc";
	private static final String ID_LOAI_TT = "idphanloaitintuc";
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
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG),
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
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
	
	
	public ArrayList<TinTuc> getListTinTucEachPage(int offset, int numberItemEachPage){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(SELECT_LIST_TIN_TUC_EACH_PAGE);
			ps.setInt(1, offset);
			ps.setInt(2, numberItemEachPage);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
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
	
	
	public ArrayList<TinTuc> searchTinTuc(String tieude) {
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SEARCH_TIN_TUC + "%" + tieude + "%");
			
			while(rs.next())
			{
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
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
				st.close();
				conn.close();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public TinTuc getItemTinTuc(String idTinTuc){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		TinTuc objTinTuc = null;

		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_RECORD_BY_ID + idTinTuc);
			
			while(rs.next())
			{
				objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
						rs.getString(HINH_ANH),
						rs.getDate(NGAY_DANG_TIN));
			}
			
			return objTinTuc;
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
	
	
	public boolean checkAddTinTuc(TinTuc objTinTuc, int idLoaiTinTuc){
		conn = connectionLibraryMySQL.getConnectMySQL();
		
		try 
		{
			ps = conn.prepareStatement(INSERT_TIN_TUC);
			ps.setString(1, objTinTuc.getTieuDe());
			ps.setString(2, objTinTuc.getNoiDung());
			ps.setString(3, objTinTuc.getQuote());
			ps.setInt(4, idLoaiTinTuc);
			ps.setString(5, objTinTuc.getHinhAnh());
			ps.setDate(6, objTinTuc.getNgayDangTin());
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
	
	
	public boolean checkEditTinTuc(TinTuc objTinTuc, int idLoaiTinTuc){
		conn = connectionLibraryMySQL.getConnectMySQL();
		
		try {
			ps = conn.prepareStatement(UPDATE_TIN_TUC);
			ps.setString(1, objTinTuc.getTieuDe());
			ps.setString(2, objTinTuc.getNoiDung());
			ps.setString(3, objTinTuc.getQuote());
			ps.setInt(4, idLoaiTinTuc);
			ps.setString(5, objTinTuc.getHinhAnh());
			ps.setDate(6, objTinTuc.getNgayDangTin());
			ps.setInt(7, objTinTuc.getIdTinTuc());
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
	
	
	public int getIdPhanLoaiTinTuc(int idTinTuc){
		conn = connectionLibraryMySQL.getConnectMySQL();
		int idPhanLoaiTinTuc = 0;

		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_ID_LOAI_TIN_TUC + idTinTuc);
			
			while(rs.next())
			{
				idPhanLoaiTinTuc = rs.getInt(ID_LOAI_TT);
			}
			
			return idPhanLoaiTinTuc;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			return idPhanLoaiTinTuc;
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
	
	
	public boolean checkDelItemTinTuc(int idTinTuc) {
		
		conn = connectionLibraryMySQL.getConnectMySQL();
	
		try 
		{
			ps = conn.prepareStatement(DEL_TIN_TUC);
			ps.setInt(1, idTinTuc);
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

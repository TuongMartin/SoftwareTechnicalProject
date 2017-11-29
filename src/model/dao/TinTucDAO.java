package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import library.ConnectionLibraryMySQL;
import model.bean.TinTuc;


public class TinTucDAO {
	
	private static final String SELECT_ALL_RECORD_TABLE_TIN_TUC = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc ";
	private static final String SELECT_LIST_TIN_TUC_EACH_PAGE = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc  limit ?, ?";
	private static final String COUNT_RECORD_TIN_TUC = "SELECT count(*) as countTinTuc from tintuc";
	private static final String SEARCH_TIN_TUC = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc  where tieude like ";
	private static final String COUNT_RECORD_SEARCH_TIN_TUC = "SELECT COUNT(*) AS countTinTucSearch FROM tintuc WHERE tieude LIKE ";
	private static final String SELECT_RECORD_BY_ID = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc  where idtintuc = ";
	private static final String INSERT_TIN_TUC = "INSERT INTO tintuc(tieude, noidung, quote, idphanloaitintuc, hinhanh, ngaydangtin, luotview) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_TIN_TUC = "UPDATE tintuc SET tieude = ?, noidung = ?, quote = ?, idphanloaitintuc = ?, hinhanh = ?, ngaydangtin = ? WHERE idtintuc = ?";
	private static final String SELECT_ID_LOAI_TIN_TUC = "select idphanloaitintuc from tintuc where idtintuc = ";
	private static final String DEL_TIN_TUC = "DELETE FROM tintuc where idtintuc = ?";
	private static final String SELECT_LIST_RELATED_ARTICLE = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc where tintuc.idphanloaitintuc = ";
	private static final String SELECT_LIST_NEW_ARTICLE = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc ORDER BY tintuc.idtintuc DESC limit 0, ?";
	private static final String UPDATE_VIEW = "UPDATE tintuc SET luotview = ? WHERE idtintuc = ?";
	private static final String SELECT_LIST_POPULAR_ARTICLE = "SELECT tintuc.idtintuc, tintuc.tieude, tintuc.noidung, tintuc.quote, phanloaitintuc.loaitintuc, tintuc.hinhanh, tintuc.ngaydangtin, tintuc.luotview FROM tintuc JOIN phanloaitintuc ON tintuc.idphanloaitintuc = phanloaitintuc.idphanloaitintuc ORDER BY tintuc.luotview DESC limit 0, ?";
	
	private static final String ID_TIN_TUC = "idtintuc";
	private static final String TIEU_DE = "tieude";
	private static final String NOI_DUNG = "noidung";
	private static final String QUOTE = "quote";
	private static final String LOAI_TT = "loaitintuc";
	private static final String ID_LOAI_TT = "idphanloaitintuc";
	private static final String HINH_ANH = "hinhanh";
	private static final String NGAY_DANG_TIN = "ngaydangtin";
	private static final String LUOT_VIEW = "luotview";
	
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
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
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
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
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
	
	public Integer countTinTucFind(String tieude) {
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		int count = 0;
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(COUNT_RECORD_SEARCH_TIN_TUC + " '%" + tieude + "%'");
			
			while(rs.next())
			{
				count = rs.getInt(1);
			}
			
			return count;
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
	
	public ArrayList<TinTuc> searchTinTuc(String tieude, int offset, int rowItemEachPage) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SEARCH_TIN_TUC + " '%" + tieude + "%' LIMIT " + offset + "," + rowItemEachPage);
			
			while(rs.next())
			{
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
						rs.getString(HINH_ANH),
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
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
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
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
			ps.setInt(7, objTinTuc.getLuotView());
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
	
	
	public ArrayList<TinTuc> getListRelatedItems(int idLoaiTinTuc, int numberItemNeed){
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try 
		{
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_LIST_RELATED_ARTICLE + idLoaiTinTuc);
			
			while(rs.next())
			{
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
						rs.getString(HINH_ANH),
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
				list.add(objTinTuc);
			}
			
			int iNewNumber = 0; 
			int iPrevious = -1;
			Random rd = new Random();
			ArrayList<TinTuc> listReturn = new ArrayList<TinTuc>();
			
			for(int i = 0; i < numberItemNeed; i++)
			{
				iNewNumber = rd.nextInt(list.size()); 
	            if (iNewNumber != iPrevious){ 
	                i++; 
	                iPrevious = iNewNumber; 
	                listReturn.add(list.get(iNewNumber));
	            } 
			}
			
			return listReturn;
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
	
	
	public ArrayList<TinTuc> getListNewItems(int numberItemNeed){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(SELECT_LIST_NEW_ARTICLE);
			ps.setInt(1, numberItemNeed);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
						rs.getString(HINH_ANH), 
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
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
	
	
	public void updateView(int luotView, int idTinTuc){
		conn = connectionLibraryMySQL.getConnectMySQL();
		
		try {
			ps = conn.prepareStatement(UPDATE_VIEW);
			ps.setInt(1, luotView);
			ps.setInt(2, idTinTuc);
			ps.executeUpdate();
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
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
	
	
	public ArrayList<TinTuc> getListPopularItems(int numberItemNeed){
		
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<TinTuc> list = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(SELECT_LIST_POPULAR_ARTICLE);
			ps.setInt(1, numberItemNeed);
			rs = ps.executeQuery();
			
			while(rs.next()){
				TinTuc objTinTuc = new TinTuc(
						rs.getInt(ID_TIN_TUC),
						rs.getString(TIEU_DE), 
						rs.getString(NOI_DUNG), 
						rs.getString(QUOTE),
						rs.getString(LOAI_TT),
						rs.getString(HINH_ANH), 
						rs.getDate(NGAY_DANG_TIN),
						rs.getInt(LUOT_VIEW));
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
}

package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;

import library.BCrypt;
import library.ConnectionLibraryMySQL;
import model.bean.CanHo;
import model.bean.KhachHang;
import model.bean.NhanVien;

public class CustomersDAO {
	private ConnectionLibraryMySQL connectionLibraryMySQL;
	private Connection conn;
	private Statement st;
	private PreparedStatement ps;
	private ResultSet rs;
	private String table;
	
	public CustomersDAO() {
		this.connectionLibraryMySQL = new ConnectionLibraryMySQL();
    this.table = "khachhang";
	}	
	
	public int numkhachhang(int idnhanvien){
		int numberkh=0;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select count(*) as number from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH where dangkycanho.Idnhanvien=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,idnhanvien);
			rs=ps.executeQuery();
			if(rs.next()){
				numberkh=rs.getInt("number");
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberkh;
	}
	
	public ArrayList<KhachHang> getkhachhangs(int idnhanvien,int start,int maxitem){
		ArrayList<KhachHang> khachhangs = new ArrayList<KhachHang>();
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select * from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH join loaikhachhang on khachhang.idKhachHang=loaikhachhang.IdLoaiKH where dangkycanho.Idnhanvien=? limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			ps.setInt(2, start);
			ps.setInt(3, maxitem);
			rs=ps.executeQuery();
			while(rs.next()){
				KhachHang currentkh = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"),
						rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"),
						rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"),
						rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"),
						rs.getInt("IdLoaiKH"),rs.getString("TenLoaiKH"),rs.getInt("IdTinDang"));
				khachhangs.add(currentkh);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachhangs;
	}
	
	public int searchkhcount(int idnhanvien,String key){
		int number=0;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select count(*) as number from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH where dangkycanho.IdNhanVien=? and khachhang.tenKhachHang LIKE '%"+key+"%'";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			rs=ps.executeQuery();
			if(rs.next()){
				number = rs.getInt("number");
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}
	
	public ArrayList<KhachHang> searchkhachhang(int idnhanvien,int start,int maxitem,String key){
		ArrayList<KhachHang> khachhangs = new ArrayList<KhachHang>();
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "select * from khachhang inner join dangkycanho on khachhang.idKhachHang=dangkycanho.IdKH join loaikhachhang on khachhang.idKhachHang=loaikhachhang.IdLoaiKH where dangkycanho.Idnhanvien=? and khachhang.tenKhachHang like '%"+key+"%' limit ?,?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idnhanvien);
			ps.setInt(2, start);
			ps.setInt(3, maxitem);
			rs=ps.executeQuery();
			while(rs.next()){
				KhachHang currentkh = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"),
						rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"),
						rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"),
						rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"),
						rs.getInt("IdLoaiKH"),rs.getString("TenLoaiKH"),rs.getInt("IdTinDang"));
				khachhangs.add(currentkh);
			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return khachhangs;
	}
	
	public boolean danhgiakhachhang(int id,int idloaikh) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "update khachhang set IdLoaiKH=? where idKhachHang=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idloaikh);
			ps.setInt(2, id);
			ps.executeUpdate();
			ps.close();
			conn.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public KhachHang getItemCustomerByEmail(String email) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		KhachHang objCustomer = null;
		String sql = "SELECT * FROM khachhang WHERE email = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				objCustomer = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"), rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"), rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"));
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
		return objCustomer;
	}
	
	public KhachHang getItemCustomerById(int id) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		KhachHang objCustomer = null;
		String sql = "SELECT * FROM khachhang WHERE idKhachHang = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				objCustomer = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"), rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"), rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"));
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
		return objCustomer;
	}
	
	public void updateCustomerStatus(int cid, int cstatus) {
		int status = cstatus == 1 ? 0 : 1;
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE khachhang SET status = ? WHERE idKhachHang = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, cid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public boolean addItemCustomer(KhachHang objCustomer) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "INSERT INTO khachhang(tenKhachHang,diaChi,queQuan,CMND,ngaySinh,soDienThoai,email,matKhau,avatar,token) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objCustomer.getTenKhachHang());
			ps.setString(2, objCustomer.getDiaChi());
			ps.setString(3, objCustomer.getQueQuan());
			ps.setString(4, objCustomer.getCMND());
			ps.setString(5, objCustomer.getNgaySinh());
			ps.setString(6, objCustomer.getSoDienThoai());
			ps.setString(7, objCustomer.getEmail());
			ps.setString(8, objCustomer.getMatKhau());
			ps.setString(9, objCustomer.getAvatar());
			ps.setString(10, objCustomer.getToken());
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
	
	public boolean checkConfirmAccount(String token, String email) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		KhachHang objCustomer = null;
		String sql = "SELECT * FROM khachhang WHERE email = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				objCustomer = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"), rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"), rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"));
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
		return objCustomer != null && objCustomer.getToken().equals(token);
	}
	
	public int confirmAccount(String email) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		int result = 0;
		String sql = "UPDATE khachhang SET confirm_at = ? WHERE email = ?";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		String ngayconfirm = sdf.format(date);
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(2, email);
			ps.setString(1, ngayconfirm);
			ps.executeUpdate();
			result = 1;
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
		return result;
	}
	
	public int countItem() {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT COUNT(*) AS countCustomer FROM khachhang";
		int countCustomer = 0;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			if(rs.next()){
				countCustomer = rs.getInt("countCustomer");
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
		return countCustomer;
	}
	
	public ArrayList<KhachHang> getItemPagition(int offset, int row_count) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM khachhang LIMIT ?,?";
		ArrayList<KhachHang> list = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, offset);
			ps.setInt(2, row_count);
			rs = ps.executeQuery();
			
			while(rs.next()){
				KhachHang objKhachHang = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("CMND"), rs.getString("ngaySinh"), rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"), rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"));
				list.add(objKhachHang);
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

	public boolean editCustomer(KhachHang objKH) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE khachhang SET tenKhachHang = ?,diaChi = ?,queQuan = ?,ngaySinh = ?,soDienThoai = ?,matKhau = ?,avatar = ? WHERE idKhachHang = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, objKH.getTenKhachHang());
			ps.setString(2, objKH.getDiaChi());
			ps.setString(3, objKH.getQueQuan());
			ps.setString(4, objKH.getNgaySinh());
			ps.setString(5, objKH.getSoDienThoai());
			ps.setString(6, objKH.getMatKhau());
			ps.setString(7, objKH.getAvatar());
			ps.setInt(8, objKH.getId());
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
	
	public boolean delItemCustomer(int idCustomer) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "DELETE FROM khachhang where idKhachHang = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idCustomer);
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

	public KhachHang login(String email) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "SELECT * FROM " + table + " WHERE email = ?";
		KhachHang objKH = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				objKH = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("CMND"), rs.getString("ngaySinh"), rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"), rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"));
			}
			return objKH;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int resetPassword(String email, String password) {
		// TODO Auto-generated method stub
		conn = connectionLibraryMySQL.getConnectMySQL();
		String sql = "UPDATE " + table + " SET matKhau = ? WHERE email = ?";
		int result = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, email);
			ps.executeUpdate();
			result = 1;
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
		return result;
	}
	
	public ArrayList<KhachHang> searchCustomer(int idKH, String tenKH) {
		conn = connectionLibraryMySQL.getConnectMySQL();
		ArrayList<KhachHang> list = new ArrayList<>();
		String sql = "";
		if(tenKH.trim().equals("")) {
			sql = "SELECT * FROM " + table + " WHERE idKhachHang = ?";
		}else if(idKH == 0) {
			sql = "SELECT * FROM " + table + " WHERE tenKhachHang LIKE '%"+ tenKH +"%' ORDER BY idKhachHang DESC";
		}else {
			sql = "SELECT * FROM " + table + " WHERE idKhachHang = ? AND tenKhachHang LIKE '%"+ tenKH +"%' ORDER BY idKhachHang DESC";
		}
		try {
			ps = conn.prepareStatement(sql);
			if(idKH != 0){
				ps.setInt(1, idKH);
			}
			rs = ps.executeQuery();
			
			while(rs.next()){
				KhachHang objKH = new KhachHang(rs.getInt("idKhachHang"), rs.getString("tenKhachHang"), rs.getString("diaChi"), rs.getString("queQuan"), rs.getString("cMND"), rs.getString("ngaySinh"), rs.getString("soDienThoai"), rs.getString("email"), rs.getString("matKhau"), rs.getString("avatar"), rs.getInt("status"), rs.getString("token"), rs.getString("confirm_at"));
				list.add(objKH);
			}
			if(list.size() > 0) {
				return list;
			}else {
				return null;
			}
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
}


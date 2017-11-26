package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.Account;

public class AccountDAO {
	private Connection conn;
	private ConnectionLibraryMySQL connDB;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement pst;
	
	public AccountDAO(){
		connDB = new ConnectionLibraryMySQL();
	}
	
	public int numAccount(){
		int number = 0;
		conn = connDB.getConnectMySQL();
		String sql="select count(*) as number from account";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				number = rs.getInt("number");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return number;
	}
	
	public ArrayList<Account> getlist(int offset, int row_count){
		conn = connDB.getConnectMySQL();
		ArrayList<Account> accounts= new ArrayList<Account>();
		String sql = "select * from account left join nhanvien on account.IdNhanVien=nhanvien.IdNhanVien join role on account.idrole=role.idrole limit ?,?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, row_count);
			rs = pst.executeQuery();
			while(rs.next()){
				Account current = new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("idrole"),rs.getString("role"),rs.getInt("IdNhanVien"),rs.getString("TenNhanVien"));
				accounts.add(current);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return accounts;
	}
	
	public int numsearch(String str){
		int number = 0;
		conn = connDB.getConnectMySQL();
		String sql="select count(*) as number from account where username like '%"+str+"%'";
		try{
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				number = rs.getInt("number");
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return number;
	}
	
	public Account getAccountById(int idaccount){
		Account current=null;
		conn = connDB.getConnectMySQL();
		String sql = "select * from account inner join role on account.idrole=role.idrole where account.id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idaccount);
			rs = pst.executeQuery();
			if(rs.next()){
				current = new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("idrole"),rs.getString("role"),rs.getInt("IdNhanVien"),"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return current;
	}
	

	public Account getAccountByIdSale(int idNhanVien){
		Account current=null;
		conn = connDB.getConnectMySQL();
		String sql = "select * from account inner join role on account.idrole=role.idrole where account.IdNhanVien=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idNhanVien);
			rs = pst.executeQuery();
			if(rs.next()){
				current = new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("idrole"),rs.getString("role"),rs.getInt("IdNhanVien"),"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return current;
	}

	public boolean addaccount(Account account){
		conn = connDB.getConnectMySQL();
		String sql = "insert into account (username,password,idrole) values (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, account.getUsername());
			pst.setString(2, account.getPassword());
			pst.setInt(3, account.getId());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean checkusername(String username){
		conn = connDB.getConnectMySQL();
		String sql="select * from account where username=?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if(rs.next()){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}		
		return false;
	}
	
	public boolean deleteAccount(int id){
		conn = connDB.getConnectMySQL();
		String sql = "delete from account where id=?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	public boolean updateAccount(int id,String password,int idrole) {
		conn = connDB.getConnectMySQL();
		String sql = "UPDATE account SET password=?, idrole=? WHERE id=?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, idrole);
			pst.setInt(3, id);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	

	public boolean updateAccount(int idSale ,String password) {
		conn = connDB.getConnectMySQL();
		String sql = "UPDATE account SET password=? WHERE idNhanVien=?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setInt(2, idSale);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public boolean updateRole(int id,int idrole) {
		conn = connDB.getConnectMySQL();
		String sql = "UPDATE account SET idrole=? WHERE id=?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idrole);
			pst.setInt(2, id);
			pst.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}		
		return true;
	}

	public ArrayList<Account> getlist(){
		conn = connDB.getConnectMySQL();
		ArrayList<Account> listAccounts= new ArrayList<Account>();
		String sql = "select * from account left join nhanvien on account.IdNhanVien=nhanvien.IdNhanVien join role on account.idrole=role.idrole";
		try{
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				Account current = new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("idrole"),rs.getString("role"),rs.getInt("IdNhanVien"),rs.getString("TenNhanVien"));
				listAccounts.add(current);
			}
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return listAccounts;
	}
	
	public Account getAccountNew(){
		Account obj = null;
		conn = connDB.getConnectMySQL();
		String sql = "select * from account ORDER BY id DESC LIMIT 1 ";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				obj = new Account(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getInt("idrole"),"",rs.getInt("IdNhanVien"),"");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}

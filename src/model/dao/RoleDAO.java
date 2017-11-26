package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import library.ConnectionLibraryMySQL;
import model.bean.Role;

public class RoleDAO {
	private Connection conn;
	private ConnectionLibraryMySQL connDB;
	private Statement st;
	private ResultSet rs;
	
	public RoleDAO(){
		connDB = new ConnectionLibraryMySQL();
	}
	
	public ArrayList<Role> roles(){
		conn = connDB.getConnectMySQL();
		ArrayList<Role> roles = new ArrayList<Role>();
		String sql = "select * from role";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()){
				Role current = new Role(rs.getInt("idrole"),rs.getString("role"));
				roles.add(current);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}
}

package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionLibraryMySQL {
	private Connection conn;
	private String url;
	private String user;
	private String pass;
	private String db;
	
	public ConnectionLibraryMySQL() {
		this.db = "batdongsan";
		this.url = "jdbc:mysql://localhost:3306/"+db+"?useUnicode=true&characterEncoding=UTF-8";
		this.user = "root";
		this.pass = ""; //PXKrrx21939
	}
	
	public Connection getConnectMySQL(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); //nạp driver
			conn = DriverManager.getConnection(url,user,pass); //connect to cosodulieu
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void main(String[] args) {
		ConnectionLibraryMySQL conn = new ConnectionLibraryMySQL();
		System.out.println(conn.getConnectMySQL());
	}
}

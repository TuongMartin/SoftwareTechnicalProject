package model.bean;

public class Account {
	private int id;
	private String username;
	private String password;
	private int idrole;
	private String role;
	private int IdNhanVien;
	private String TenNhanVien;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getIdrole() {
		return idrole;
	}
	public void setIdrole(int idrole) {
		this.idrole = idrole;
	}
	
	public int getIdNhanVien() {
		return IdNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		IdNhanVien = idNhanVien;
	}
	
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	
	public Account(int id,String username,String password,int idrole,String role,int IdNhanVien,String TenNhanVien){
		this.id = id;
		this.username = username;
		this.password = password;
		this.idrole = idrole;
		this.role = role;
		this.IdNhanVien = IdNhanVien;
		this.TenNhanVien = TenNhanVien;
	}
	public String getrole() {
		return role;
	}
	public void setrole(String role) {
		this.role = role;
	}
}

package model.bean;

public class Account {
	private int id;
	private String username;
	private String password;
	private int idroler;
	private String quyenhan;
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
	
	public int getIdroler() {
		return idroler;
	}
	public void setIdroler(int idroler) {
		this.idroler = idroler;
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
	
	public Account(int id,String username,String password,int idroler,String quyenhan,int IdNhanVien,String TenNhanVien){
		this.id = id;
		this.username = username;
		this.password = password;
		this.idroler = idroler;
		this.quyenhan = quyenhan;
		this.IdNhanVien = IdNhanVien;
		this.TenNhanVien = TenNhanVien;
	}
	public String getQuyenhan() {
		return quyenhan;
	}
	public void setQuyenhan(String quyenhan) {
		this.quyenhan = quyenhan;
	}
}

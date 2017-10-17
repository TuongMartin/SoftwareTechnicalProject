package model.bean;

public class NhanVien {
	private int idNhanVien;
	private String tenNhanVien;
	private String diaChi;
	private String queQuan;
	private int CMND;
	private String ngaySinh;
	private String SDT;
	private String tenDangNhap;
	private String matKhau;
	private int idChucVu;
	private String tenChucVu;
	private String avatar;
	
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getQueQuan() {
		return queQuan;
	}
	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}
	public int getCMND() {
		return CMND;
	}
	public void setCMND(int cMND) {
		CMND = cMND;
	}
	
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getIdChucVu() {
		return idChucVu;
	}
	public void setIdChucVu(int idChucVu) {
		this.idChucVu = idChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public NhanVien() {}
	public NhanVien(int idNhanVien, String tenNhanVien, String diaChi, String queQuan, int cMND, String ngaySinh,
			String sDT, String tenDangNhap, String matKhau, int idChucVu, String tenChucVu, String avatar) {
		this.idNhanVien = idNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.diaChi = diaChi;
		this.queQuan = queQuan;
		CMND = cMND;
		this.ngaySinh = ngaySinh;
		SDT = sDT;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.idChucVu = idChucVu;
		this.tenChucVu = tenChucVu;
		this.avatar = avatar;
	}
	
	
}

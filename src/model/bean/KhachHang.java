package model.bean;

import java.util.Date;

public class KhachHang {
	private int id;
	private String tenKhachHang;
	private String diaChi;
	private String queQuan;
	private String CMND;
	private String ngaySinh;
	private String soDienThoai;
	private String email;
	private String matKhau;
	private String avatar;
	private int status;
	private String token;
	private String comfirm_at;
	private int IdLoaiKH;
	private String TenLoaiKH;
	private int IdTinDang;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComfirm_at() {
		return comfirm_at;
	}
	public void setComfirm_at(String comfirm_at) {
		this.comfirm_at = comfirm_at;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
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
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getIdLoaiKH() {
		return IdLoaiKH;
	}
	public void setIdLoaiKH(int idLoaiKH) {
		IdLoaiKH = idLoaiKH;
	}
	public String getTenLoaiKH() {
		return TenLoaiKH;
	}
	public void setTenLoaiKH(String tenLoaiKH) {
		TenLoaiKH = tenLoaiKH;
	}
	public KhachHang(int id, String tenKhachHang, String diaChi,
			String queQuan, String cMND, String ngaySinh, String soDienThoai,
			String email, String matKhau, String avatar, int status,
			String token, String comfirm_at,int IdLoaiKH,String TenLoaiKH,int IdTinDang) {
	public KhachHang(int id, String tenKhachHang, String diaChi,
			String queQuan, String cMND, String ngaySinh, String soDienThoai,
			String email, String matKhau, String avatar, int status,
			String token, String comfirm_at) {
		super();
		this.id = id;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.queQuan = queQuan;
		CMND = cMND;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.matKhau = matKhau;
		this.avatar = avatar;
		this.status = status;
		this.token = token;
		this.comfirm_at = comfirm_at;
		this.IdLoaiKH = IdLoaiKH;
		this.TenLoaiKH = TenLoaiKH;
		this.IdTinDang = IdTinDang;
	}
	public int getIdTinDang() {
		return IdTinDang;
	}
	public void setIdTinDang(int idTinDang) {
		IdTinDang = idTinDang;
	}
	
}

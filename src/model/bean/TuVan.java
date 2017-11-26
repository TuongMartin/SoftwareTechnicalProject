package model.bean;

import java.sql.Date;

public class TuVan{
	 
	private int idNhanVien;
	private String tenKhachHang;
	private String SDT;
	private String noiDungTuVan;
	private Date ngayTuVan;
	
	
	public TuVan(int idNhanVien, String tenKhachHang, String SDT, String noiDungTuVan, Date ngayTuVan){
		
		this.idNhanVien = idNhanVien;
		this.tenKhachHang = tenKhachHang;
		this.SDT = SDT;
		this.noiDungTuVan = noiDungTuVan;
		this.ngayTuVan = ngayTuVan;
	}
	
	
	public void setIdNhanVien(int idNhanVien){
		this.idNhanVien = idNhanVien;
	}
	
	
	public void setTenKhachHang(String tenKhachHang){
		this.tenKhachHang = tenKhachHang;
	}
	
	
	public void setSDT(String SDT){
		this.SDT = SDT;
	}
	
	
	public void setNoiDungTuVan(String noiDungTuVan){
		this.noiDungTuVan = noiDungTuVan;
	}
	
	
	public void setNgayTuVan(Date ngayTuVan){
		this.ngayTuVan = ngayTuVan;
	}
	
	
	public int getIdNhanVien(){
		return idNhanVien;
	}
	
	
	public String getTenKhachHang(){
		return tenKhachHang;
	}
	
	
	public String getSDT(){
		return SDT;
	}
	
	
	public String getNoiDungTuVan(){
		return noiDungTuVan;
	}
	
	
	public Date getNgayTuVan(){
		return ngayTuVan;
	}
}
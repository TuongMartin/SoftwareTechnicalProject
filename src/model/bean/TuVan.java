package model.bean;

import java.sql.Date;

public class TuVan{
	 
	private int stt;
	private int idNhanVien;
	private int idKhachHang;
	private String noiDungTuVan;
	private Date ngayTuVan;
	
	
	public TuVan(int stt, int idNhanVien, int idKhachHang, String noiDungTuVan, Date ngayTuVan){
		
		this.stt = stt;
		this.idNhanVien = idNhanVien;
		this.idKhachHang = idKhachHang;
		this.noiDungTuVan = noiDungTuVan;
		this.ngayTuVan = ngayTuVan;
	}
	
	
	public void setIdNK(int stt){
		this.stt = stt;
	}
	
	
	public void setIdNhanVien(int idNhanVien){
		this.idNhanVien = idNhanVien;
	}
	
	
	public void setIdKhachHang(int idKhachHang){
		this.idKhachHang = idKhachHang;
	}
	
	
	public void setNoiDungTuVan(String noiDungTuVan){
		this.noiDungTuVan = noiDungTuVan;
	}
	
	
	public void setNgayTuVan(Date ngayTuVan){
		this.ngayTuVan = ngayTuVan;
	}
	
	
	public int getIdNK(){
		return stt;
	}
	
	
	public int getIdNhanVien(){
		return idNhanVien;
	}
	
	
	public int getIdKhachHang(){
		return idKhachHang;
	}
	
	
	public String getNoiDungTuVan(){
		return noiDungTuVan;
	}
	
	
	public Date getNgayTuVan(){
		return ngayTuVan;
	}
}
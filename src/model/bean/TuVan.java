package model.bean;

public class TuVan{
	
	private int stt;
	private String tenKhachHang;
	private String noiDungTuVan;
	private String ngayTuVan;
	
	
	public TuVan(int stt, String tenKhachHang, String noiDungTuVan, String ngayTuVan){
		
		this.stt = stt;
		this.tenKhachHang = tenKhachHang;
		this.noiDungTuVan = noiDungTuVan;
		this.ngayTuVan = ngayTuVan;
	}
	
	
	public void setSTT(int stt){
		this.stt = stt;
	}
	
	
	public void setTenKhachHang(String tenKhachHang){
		this.tenKhachHang = tenKhachHang;
	}
	
	
	public void setNoiDungTuVan(String noiDungTuVan){
		this.noiDungTuVan = noiDungTuVan;
	}
	
	
	public void setNgayTuVan(String ngayTuVan){
		this.ngayTuVan = ngayTuVan;
	}
	
	
	public int getSTT(){
		return stt;
	}
	
	
	public String getTenKhachHang(){
		return tenKhachHang;
	}
	
	
	public String getNoiDungTuVan(){
		return noiDungTuVan;
	}
	
	
	public String getNgayTuVan(){
		return ngayTuVan;
	}
}
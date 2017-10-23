package model.bean;

import java.sql.Date;

public class TinTuc {
	
	private String tieuDe;
	private String noiDung;
	private String quote;
	private String hinhAnh;
	private Date ngayDangTin;
	
	public TinTuc(String tieuDe, String noiDung, String quote, String hinhAnh, Date ngayDangTin){
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.quote = quote;
		this.hinhAnh = hinhAnh;
		this.ngayDangTin = ngayDangTin;
	}
	
	
	public void setTieuDe(String tieuDe){
		this.tieuDe = tieuDe;
	}
	
	
	public void setNoiDung(String noiDung){
		this.noiDung = noiDung;
	}
	
	
	public void setHinhAnh(String hinhAnh){
		this.hinhAnh = hinhAnh;
	}
	
	
	public void setQuote(String quote){
		this.quote = quote;
	}
	
	
	public void setNgayDangTin(Date ngayDangTin){
		this.ngayDangTin = ngayDangTin;
	}
	
	
	public String getTieuDe(){
		return this.tieuDe;
	}
	
	
	public String getNoiDung(){
		return this.noiDung;
	}
	
	
	public String getQuote(){
		return this.quote;
	}
	
	
	public String getHinhAnh(){
		return this.hinhAnh;
	}

	
	public Date getNgayDangTin(){
		return this.ngayDangTin;
	}
}

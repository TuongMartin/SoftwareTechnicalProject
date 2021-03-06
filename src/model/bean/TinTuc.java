package model.bean;

import java.sql.Date;

public class TinTuc {
	
	private int idTinTuc;
	private String tieuDe;
	private String noiDung;
	private String quote;
	private String loaiTinTuc;
	private String hinhAnh;
	private Date ngayDangTin;
	private int luotView;
	
	public TinTuc(int idTinTuc, String tieuDe, String noiDung, String quote, String loaiTinTuc , String hinhAnh, Date ngayDangTin, int luotView){
		this.idTinTuc = idTinTuc;
		this.tieuDe = tieuDe;
		this.noiDung = noiDung;
		this.quote = quote;
		this.loaiTinTuc = loaiTinTuc;
		this.hinhAnh = hinhAnh;
		this.ngayDangTin = ngayDangTin;
		this.luotView = luotView;
	}
	
	
	public void setIdTinTuc(int idTinTuc){
		this.idTinTuc = idTinTuc;
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
	
	
	public void setLoaiTinTuc(String loaiTinTuc){
		this.loaiTinTuc = loaiTinTuc;
	}
	
	
	public void setNgayDangTin(Date ngayDangTin){
		this.ngayDangTin = ngayDangTin;
	}
	
	
	public void setLuotView(int luotView){
		this.luotView = luotView;
	}
	
	
	public int getIdTinTuc(){
		return this.idTinTuc;
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
	
	
	public String getLoaiTinTuc(){
		return this.loaiTinTuc;
	}
	
	
	public String getHinhAnh(){
		return this.hinhAnh;
	}

	
	public Date getNgayDangTin(){
		return this.ngayDangTin;
	}
	
	
	public int getLuotView(){
		return this.luotView;
	}
}

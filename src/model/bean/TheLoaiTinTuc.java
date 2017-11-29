package model.bean;

public class TheLoaiTinTuc {
	
	private int idPhanLoaiTinTuc;
	private String loaiTinTuc;
	
	
	public TheLoaiTinTuc(int idPhanLoaiTinTuc, String loaiTinTuc){
		this.idPhanLoaiTinTuc = idPhanLoaiTinTuc;
		this.loaiTinTuc = loaiTinTuc;
	}
	
	
	public void setIdPhanLoaiTinTuc(int idPhanLoaiTinTuc){
		this.idPhanLoaiTinTuc = idPhanLoaiTinTuc;
	}
	
	
	public void setLoaiTinTuc(String loaiTinTuc){
		this.loaiTinTuc = loaiTinTuc;
	}
	
	
	public int getIdPhanLoaiTinTuc(){
		return this.idPhanLoaiTinTuc;
	}
	
	
	public String getLoaiTinTuc(){
		return this.loaiTinTuc;
	}
}

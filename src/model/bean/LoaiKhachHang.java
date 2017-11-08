package model.bean;

public class LoaiKhachHang {
	private int IdLoaiKH;
	private String TenLoaiKH;
	
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
	
	public LoaiKhachHang(int IdLoaiKH,String TenLoaiKH) {
		this.IdLoaiKH=IdLoaiKH;
		this.TenLoaiKH=TenLoaiKH;
	}
	
}

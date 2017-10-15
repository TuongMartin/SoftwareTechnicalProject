package model.bean;

public class ChucVu {
	private int idChucVu;
	private String tenChucVu;
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
	public ChucVu() {}
	public ChucVu(int idChucVu, String tenChucVu) {
		this.idChucVu = idChucVu;
		this.tenChucVu = tenChucVu;
	}
	
	
}

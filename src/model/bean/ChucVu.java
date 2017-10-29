package model.bean;

public class Chucvu {
	private int IdChucVu;
	private String TenChucVu;
	
	public Chucvu(int IdChucVu,String TenChucVu){
		this.IdChucVu = IdChucVu;
		this.TenChucVu = TenChucVu;
	}

	public int getIdChucVu() {
		return IdChucVu;
	}

	public void setIdChucVu(int idChucVu) {
		IdChucVu = idChucVu;
	}

	public String getTenChucVu() {
		return TenChucVu;
	}

	public void setTenChucVu(String tenChucVu) {
		TenChucVu = tenChucVu;
	}
	
}

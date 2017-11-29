package model.bean;

public class TienIch {
	private int idTienIch;
	private String tenTienIch;
	public int getIdTienIch() {
		return idTienIch;
	}
	public void setIdTienIch(int idTienIch) {
		this.idTienIch = idTienIch;
	}
	public String getTenTienIch() {
		return tenTienIch;
	}
	public void setTenTienIch(String tenTienIch) {
		this.tenTienIch = tenTienIch;
	}
	public TienIch(int idTienIch, String tenTienIch) {
		super();
		this.idTienIch = idTienIch;
		this.tenTienIch = tenTienIch;
	}
	
}

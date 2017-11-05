package model.bean;

public class TheLoaiBDS {
	private int id;
	private String ten;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public TheLoaiBDS(int id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	
}

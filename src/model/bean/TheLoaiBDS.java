package model.bean;

public class TheLoaiBDS {
	private int id;
	private String ten;
	private String image;
	public int getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public TheLoaiBDS(int id, String ten, String image) {
		super();
		this.id = id;
		this.ten = ten;
		this.image = image;
	}
	
}

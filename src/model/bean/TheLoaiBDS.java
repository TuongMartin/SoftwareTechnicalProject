package model.bean;

public class TheLoaiBDS {
	private int id;
	private String ten;
<<<<<<< HEAD
	public int getId() {
		return id;
	}
=======
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
>>>>>>> master
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
<<<<<<< HEAD
	public TheLoaiBDS(int id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	
}
=======
	public TheLoaiBDS(int id, String ten, String image) {
		super();
		this.id = id;
		this.ten = ten;
		this.image = image;
	}
	
}
>>>>>>> master

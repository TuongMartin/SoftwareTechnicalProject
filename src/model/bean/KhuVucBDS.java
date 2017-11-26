package model.bean;

public class KhuVucBDS {
	private int id;
	private String ten;
	private String image;
	private int countBDS;
	
	public String getImage() {
		return image;
	}
	public int getCountBDS() {
		return countBDS;
	}
	public void setCountBDS(int countBDS) {
		this.countBDS = countBDS;
	}
	public void setImage(String image) {
		this.image = image;
	}
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
	public KhuVucBDS(int id, String ten, String image) {
		super();
		this.id = id;
		this.ten = ten;
		this.image = image;
	}
	public KhuVucBDS(int id, String ten, String image, int countBDS) {
		super();
		this.id = id;
		this.ten = ten;
		this.image = image;
		this.countBDS = countBDS;
	}
	
}

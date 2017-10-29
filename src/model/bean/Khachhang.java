package model.bean;

public class Khachhang {
	private int IdKH;
	private String TenKH;
	private String DiaChiKH;
	private String SDTKH;
	private String EmailKH;
	private int IdLoaiKH;
	private String TenLoaiKH;
	private int IdTinDang;
	public Khachhang(int IdKH,String TenKH,String DiaChiKH,String SDTKH,String EmailKH,int IdLoaiKH,String TenLoaiKH,int IdTinDang){
		this.IdKH = IdKH;
		this.TenKH = TenKH;
		this.DiaChiKH = DiaChiKH;
		this.SDTKH = SDTKH;
		this.EmailKH = EmailKH;
		this.IdLoaiKH = IdLoaiKH;
		this.TenLoaiKH = TenLoaiKH;
		this.IdTinDang = IdTinDang;
	}
	public int getIdKH() {
		return IdKH;
	}
	public void setIdKH(int idKH) {
		IdKH = idKH;
	}
	public String getDiaChiKH() {
		return DiaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		DiaChiKH = diaChiKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getSDTKH() {
		return SDTKH;
	}
	public void setSDTKH(String sDTKH) {
		SDTKH = sDTKH;
	}
	public String getEmailKH() {
		return EmailKH;
	}
	public void setEmailKH(String emailKH) {
		EmailKH = emailKH;
	}
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
	public int getIdTinDang() {
		return IdTinDang;
	}
	public void setIdTinDang(int idTinDang) {
		IdTinDang = idTinDang;
	}
}

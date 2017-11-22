package model.bean;

public class CanHo {
	private int id;
	private String ten;
	private String diachi;
	private int dientich;
	private int giatien;
	private int sophong;
	private int sophongngu;
	private int sophongtam;
	private String mota;
	private int tuoi;
	private String parking;
	private String cooling;
	private String heating;
	private String sewer;
	private String water;
	private int phongtap;
	private int nhakho;
	private int idnhanvien;
	private String tennhanvien;
	private int trangthai;
	private String ngaydang;
	private int idtheloai;
	private String tentheloai;
	private int kichHoat;
	private int idkhuvuc;
	private String tenkhuvuc;
	
	public int getIdkhuvuc() {
		return idkhuvuc;
	}
	public void setIdkhuvuc(int idkhuvuc) {
		this.idkhuvuc = idkhuvuc;
	}
	public String getTenkhuvuc() {
		return tenkhuvuc;
	}
	public void setTenkhuvuc(String tenkhuvuc) {
		this.tenkhuvuc = tenkhuvuc;
	}
	public int getKichHoat() {
		return kichHoat;
	}
	public void setKichHoat(int kichHoat) {
		this.kichHoat = kichHoat;
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getDientich() {
		return dientich;
	}
	public void setDientich(int dientich) {
		this.dientich = dientich;
	}
	public int getGiatien() {
		return giatien;
	}
	public void setGiatien(int giatien) {
		this.giatien = giatien;
	}
	public int getSophong() {
		return sophong;
	}
	public void setSophong(int sophong) {
		this.sophong = sophong;
	}
	public String getTennhanvien() {
		return tennhanvien;
	}
	public void setTennhanvien(String tennhanvien) {
		this.tennhanvien = tennhanvien;
	}
	public String getTentheloai() {
		return tentheloai;
	}
	public void setTentheloai(String tentheloai) {
		this.tentheloai = tentheloai;
	}
	public int getSophongngu() {
		return sophongngu;
	}
	public void setSophongngu(int sophongngu) {
		this.sophongngu = sophongngu;
	}
	public int getSophongtam() {
		return sophongtam;
	}
	public void setSophongtam(int sophongtam) {
		this.sophongtam = sophongtam;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getCooling() {
		return cooling;
	}
	public void setCooling(String cooling) {
		this.cooling = cooling;
	}
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	public String getSewer() {
		return sewer;
	}
	public void setSewer(String sewer) {
		this.sewer = sewer;
	}
	public String getWater() {
		return water;
	}
	public void setWater(String water) {
		this.water = water;
	}
	public int getPhongtap() {
		return phongtap;
	}
	public void setPhongtap(int phongtap) {
		this.phongtap = phongtap;
	}
	public int getNhakho() {
		return nhakho;
	}
	public void setNhakho(int nhakho) {
		this.nhakho = nhakho;
	}
	public int getIdnhanvien() {
		return idnhanvien;
	}
	public void setIdnhanvien(int idnhanvien) {
		this.idnhanvien = idnhanvien;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public String getNgaydang() {
		return ngaydang;
	}
	public void setNgaydang(String ngaydang) {
		this.ngaydang = ngaydang;
	}
	public int getIdtheloai() {
		return idtheloai;
	}
	public void setIdtheloai(int idtheloai) {
		this.idtheloai = idtheloai;
	}
	public CanHo(int id, String ten, String diachi, int dientich, int giatien,
			int sophong, int sophongngu, int sophongtam, String mota, int tuoi,
			String parking, String cooling, String heating, String sewer,
			String water, int phongtap, int nhakho, int idnhanvien,
			String tennhanvien, int trangthai, String ngaydang, int idtheloai,
			String tentheloai, int kichHoat, int idkhuvuc, String tenkhuvuc) {
		super();
		this.id = id;
		this.ten = ten;
		this.diachi = diachi;
		this.dientich = dientich;
		this.giatien = giatien;
		this.sophong = sophong;
		this.sophongngu = sophongngu;
		this.sophongtam = sophongtam;
		this.mota = mota;
		this.tuoi = tuoi;
		this.parking = parking;
		this.cooling = cooling;
		this.heating = heating;
		this.sewer = sewer;
		this.water = water;
		this.phongtap = phongtap;
		this.nhakho = nhakho;
		this.idnhanvien = idnhanvien;
		this.tennhanvien = tennhanvien;
		this.trangthai = trangthai;
		this.ngaydang = ngaydang;
		this.idtheloai = idtheloai;
		this.tentheloai = tentheloai;
		this.kichHoat = kichHoat;
		this.idkhuvuc = idkhuvuc;
		this.tenkhuvuc = tenkhuvuc;
	}
	public CanHo(int kichHoat) {
		super();
		this.kichHoat = kichHoat;
	}
}

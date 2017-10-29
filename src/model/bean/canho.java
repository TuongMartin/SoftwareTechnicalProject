package model.bean;

import java.sql.Date;

public class canho {
	private int IdTinDang;
	private String TieuDe;
	private String DiaChiTD;
	private int IdLoaiTD;
	private String TenLoaiTinDang;
	private String BanDo;
	private String MaTienIch;
	private double Gia;
	private int DienTich; 
	private String HuongNha;
	private String HuongBanCong;
	private int SoPhongNgu;
	private int SoToilet;
	private String NoiThat;
	private int MatTien;
	private int SoTang;
	private Date NgayDang;
	private Date NgayHetHan;
	private int IdNhanVien;
	private String TenNhanVien;
	private int IdTrangThai;
	private String TrangThaiTinDang;
	public canho(int IdTinDang,String TieuDe,String DiaChiTD,int IdLoaiTD,String TenLoaiTinDang,String BanDo,String MaTienIch,double Gia,int DienTich,
			String HuongNha,String HuongBanCong,int SoPhongNgu,int SoToilet,String NoiThat,int MatTien,int SoTang,Date NgayDang,
			Date NgayHetHan,int IdNhanVien,String TenNhanVien,int IdTrangThai,String TrangThaiTinDang){
		this.IdTinDang = IdTinDang;
		this.TieuDe = TieuDe;
		this.DiaChiTD = DiaChiTD;
		this.IdLoaiTD = IdLoaiTD;
		this.TenLoaiTinDang = TenLoaiTinDang;
		this.BanDo = BanDo;
		this.MaTienIch = MaTienIch;
		this.Gia = Gia;
		this.DienTich = DienTich;
		this.HuongNha = HuongNha;
		this.HuongBanCong = HuongBanCong;
		this.SoPhongNgu = SoPhongNgu;
		this.SoToilet = SoToilet;
		this.NoiThat = NoiThat;
		this.MatTien = MatTien;
		this.SoTang = SoTang;
		this.NgayDang = NgayDang;
		this.NgayHetHan = NgayHetHan;
		this.IdNhanVien = IdNhanVien;
		this.TenNhanVien = TenNhanVien;
		this.IdTrangThai = IdTrangThai;
		this.TrangThaiTinDang = TrangThaiTinDang;
	}
	public int getIdTinDang() {
		return IdTinDang;
	}
	public void setIdTinDang(int idTinDang) {
		IdTinDang = idTinDang;
	}
	public String getTieuDe() {
		return TieuDe;
	}
	public void setTieuDe(String tieuDe) {
		TieuDe = tieuDe;
	}
	public String getDiaChiTD() {
		return DiaChiTD;
	}
	public void setDiaChiTD(String diaChiTD) {
		DiaChiTD = diaChiTD;
	}
	public int getIdLoaiTD() {
		return IdLoaiTD;
	}
	public void setIdLoaiTD(int idLoaiTD) {
		IdLoaiTD = idLoaiTD;
	}
	public String getBanDo() {
		return BanDo;
	}
	public void setBanDo(String banDo) {
		BanDo = banDo;
	}
	public double getGia() {
		return Gia;
	}
	public void setGia(double gia) {
		Gia = gia;
	}
	public String getMaTienIch() {
		return MaTienIch;
	}
	public void setMaTienIch(String maTienIch) {
		MaTienIch = maTienIch;
	}
	public int getDienTich() {
		return DienTich;
	}
	public void setDienTich(int dienTich) {
		DienTich = dienTich;
	}
	public String getHuongNha() {
		return HuongNha;
	}
	public void setHuongNha(String huongNha) {
		HuongNha = huongNha;
	}
	public int getSoPhongNgu() {
		return SoPhongNgu;
	}
	public void setSoPhongNgu(int soPhongNgu) {
		SoPhongNgu = soPhongNgu;
	}
	public String getHuongBanCong() {
		return HuongBanCong;
	}
	public void setHuongBanCong(String huongBanCong) {
		HuongBanCong = huongBanCong;
	}
	public int getSoToilet() {
		return SoToilet;
	}
	public void setSoToilet(int soToilet) {
		SoToilet = soToilet;
	}
	public String getNoiThat() {
		return NoiThat;
	}
	public void setNoiThat(String noiThat) {
		NoiThat = noiThat;
	}
	public int getMatTien() {
		return MatTien;
	}
	public void setMatTien(int matTien) {
		MatTien = matTien;
	}
	public int getSoTang() {
		return SoTang;
	}
	public void setSoTang(int soTang) {
		SoTang = soTang;
	}
	public Date getNgayDang() {
		return NgayDang;
	}
	public void setNgayDang(Date ngayDang) {
		NgayDang = ngayDang;
	}
	public Date getNgayHetHan() {
		return NgayHetHan;
	}
	public void setNgayHetHan(Date ngayHetHan) {
		NgayHetHan = ngayHetHan;
	}
	public int getIdNhanVien() {
		return IdNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		IdNhanVien = idNhanVien;
	}
	public int getIdTrangThai() {
		return IdTrangThai;
	}
	public void setIdTrangThai(int idTrangThai) {
		IdTrangThai = idTrangThai;
	}
	public String getTenNhanVien() {
		return TenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}
	public String getTrangThaiTinDang() {
		return TrangThaiTinDang;
	}
	public void setTrangThaiTinDang(String trangThaiTinDang) {
		TrangThaiTinDang = trangThaiTinDang;
	}
	public String getTenLoaiTinDang() {
		return TenLoaiTinDang;
	}
	public void setTenLoaiTinDang(String tenLoaiTinDang) {
		TenLoaiTinDang = tenLoaiTinDang;
	}
}

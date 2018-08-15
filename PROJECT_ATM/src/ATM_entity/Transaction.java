package ATM_entity;

public class Transaction {
	private	String MaKH ,TenKH,DiaChi,Sothe_ATM,STk_NH,SoTien;
	private int soLan,Quan,Phuong ;
	private int tongTien;
	
	
	public Transaction(String maKH, String tenKH, int quan, int phuong, String diaChi, String sothe_ATM,
			String sTk_NH, int soLan, int tongTien, String soTien) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		Quan = quan;
		Phuong = phuong;
		DiaChi = diaChi;
		Sothe_ATM = sothe_ATM;
		STk_NH = sTk_NH;
		
		this.soLan = soLan;
		this.tongTien = tongTien;
		SoTien = soTien;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMaKH() {
		return MaKH;
	}
	public void setMaKH(String maKH) {
		MaKH = maKH;
	}
	public String getTenKH() {
		return TenKH;
	}
	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSothe_ATM() {
		return Sothe_ATM;
	}
	public void setSothe_ATM(String sothe_ATM) {
		Sothe_ATM = sothe_ATM;
	}
	public String getSTk_NH() {
		return STk_NH;
	}
	public void setSTk_NH(String sTk_NH) {
		STk_NH = sTk_NH;
	}
	public String getSoTien() {
		return SoTien;
	}
	public void setSoTien(String soTien) {
		SoTien = soTien;
	}
	public int getSoLan() {
		return soLan;
	}
	public void setSoLan(int soLan) {
		this.soLan = soLan;
	}
	public int getQuan() {
		return Quan;
	}
	public void setQuan(int quan) {
		Quan = quan;
	}
	public int getPhuong() {
		return Phuong;
	}
	public void setPhuong(int phuong) {
		Phuong = phuong;
	}
	public int getTongTien() {
		return tongTien;
	}
	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}
}

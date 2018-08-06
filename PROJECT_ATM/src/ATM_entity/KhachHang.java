package ATM_entity;



public class KhachHang {
	private String MaKH ;
	private String TenKH ;
	private String maPin ;
	private int Quan ;
	private int Phuong ;
	private String DiaCHi ;
	private String SDT ;
	private String Email ;
	private String Sothe_ATM ;
	private String STk_NH ;
	private String SoTien ;
	
	public KhachHang() {
	}
	
	
	public KhachHang(String MaKH,String TenKH,String maPin,int Quan,int Phuong,String DiaCHi,String SDT,String Email,String Sothe_ATM,String STk_NH
	,String SoTien) {
		this.MaKH = MaKH;
		this.TenKH= TenKH;
		this.maPin = maPin;
		this.Quan = Quan;
		this.Phuong = Phuong;
		this.DiaCHi = DiaCHi;
		this.SDT = SDT;
		this.Email = Email;
		this.Sothe_ATM = Sothe_ATM;
		this.STk_NH = STk_NH;
		this.SoTien = SoTien;
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


	public String getmaPin() {
		return maPin;
	}


	public void setmaPin(String maPin) {
		this.maPin = maPin;
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


	public String getDiaCHi() {
		return DiaCHi;
	}


	public void setDiaCHi(String diaCHi) {
		DiaCHi = diaCHi;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
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
	
	
}

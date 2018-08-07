package ATM_entity;

public class ATM {
private String Ma_atm;
private int Quan ;
private int Phuong ;
private String vitri;
private String tongTien;
public ATM(String ma_atm, int quan, int phuong, String vitri, String tongTien) {
	super();
	Ma_atm = ma_atm;
	Quan = quan;
	Phuong = phuong;
	this.vitri = vitri;
	this.tongTien = tongTien;
}
public String getMa_atm() {
	return Ma_atm;
}
public void setMa_atm(String ma_atm) {
	Ma_atm = ma_atm;
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
public String getVitri() {
	return vitri;
}
public void setVitri(String vitri) {
	this.vitri = vitri;
}
public String getTongTien() {
	return tongTien;
}
public void setTongTien(String tongTien) {
	this.tongTien = tongTien;
}


}




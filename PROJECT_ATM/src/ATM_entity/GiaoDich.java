package ATM_entity;

public class GiaoDich {
	protected String maGD ,soThe,maATM,thoiGian,soTien;


public GiaoDich(String maGD, String soThe, String maATM, String thoiGian, String soTien) {
	super();
	this.maGD = maGD;
	this.soThe = soThe;
	this.maATM = maATM;
	this.thoiGian = thoiGian;
	this.soTien = soTien;
}
public String getMaGD() {
	return maGD;
}

public void setMaGD(String maGD) {
	this.maGD = maGD;
}

public String getSoThe() {
	return soThe;
}

public void setSoThe(String soThe) {
	this.soThe = soThe;
}

public String getMaATM() {
	return maATM;
}

public void setMaATM(String maATM) {
	this.maATM = maATM;
}

public String getThoiGian() {
	return thoiGian;
}

public void setThoiGian(String thoiGian) {
	this.thoiGian = thoiGian;
}

public String getSoTien() {
	return soTien;
}

public void setSoTien(String soTien) {
	this.soTien = soTien;
}


}

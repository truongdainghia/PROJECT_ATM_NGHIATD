package atm_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import ATM_entity.Transaction;

public class DatabaseReport_KH {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");
	static ArrayList<Transaction> arKH = new ArrayList<Transaction>();
	public static ArrayList<Transaction> getRePort(int quan,int phuong) {
		try {
		String sql = "SELECT kh.MaKH,kh.TenKH,kh.Quan,kh.Phuong,kh.DiaChi,kh.Sothe_ATM,kh.STk_NH,Count(ts.SoTien),Sum(ts.SoTien),kh.SoTien"+
				" FROM customer kh"+" INNER JOIN tb_transaction ts ON kh.Sothe_ATM = ts.Sothe_ATM where Quan="+quan+" and  Phuong="+phuong 
						+ " GROUP BY kh.MaKH ORDER BY kh.MaKH";

//		String sql = "SELECT kh.MaKH,kh.TenKH,kh.Quan,kh.Phuong,kh.DiaChi,kh.Sothe_ATM,kh.STk_NH,Count(ts.SoTien),Sum(ts.SoTien),kh.SoTien"+
//				" FROM customer kh"+" INNER JOIN tb_transaction ts ON kh.Sothe_ATM = ts.Sothe_ATM where Quan="+quan+" and Phuong="+phuong
//						+ " GROUP BY kh.TenKH ORDER BY kh.MaKH";
		Statement statement = (Statement) conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			String maKH = rs.getString("MaKH");
			String tenKH = rs.getString("TenKH");
			int Quan = rs.getInt("Quan");
			int Phuong = rs.getInt("Phuong");
			String DiaChi = rs.getString("DiaChi");
			String Sothe_ATM = rs.getString("Sothe_ATM");
			String STk_NH = rs.getString("STk_NH");
			
			String soLan = rs.getString("Count(ts.SoTien)");
			int soLanRut = Integer.parseInt(soLan);
			String tongTien1 = rs.getString("Sum(ts.SoTien)");
			int tongTien = Integer.parseInt(tongTien1);
			String SoTien = rs.getString("kh.SoTien");
			if (soLanRut > 0 && tongTien > 0) {
				arKH.add(new Transaction(maKH, tenKH,Quan, Phuong,DiaChi, Sothe_ATM, STk_NH, soLanRut,
						tongTien, SoTien));
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arKH;
		
	}
}

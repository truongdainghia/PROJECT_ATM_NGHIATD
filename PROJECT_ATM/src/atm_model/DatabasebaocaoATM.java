package atm_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import ATM_entity.ATM;
import ATM_entity.ChooseItem;
import ATM_entity.GiaoDich;

public class DatabasebaocaoATM {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");

	// get duong pho
	public static  ArrayList<ChooseItem> getDuongPho(int id) {
		 ArrayList<ChooseItem> arrDiaChi = new ArrayList<ChooseItem>();
		 try {
			 String sql = "select ViTri, id from tb_atm where Phuong = '"+id+"' GROUP BY ViTri";
			 System.out.println(sql);
				Statement stm = (Statement) conn.createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while (rs.next()) {
					ChooseItem item = new ChooseItem();
					item.setName(rs.getString(1));
					item.setId(rs.getInt(2));
					arrDiaChi.add(item);
		 }}
		  catch(Exception e) {
				e.printStackTrace(	);
			 
		 }
		 return arrDiaChi;
		}
	public static ArrayList<String> getMaMay(String duong) {
		ArrayList<String> arrDuongPho = new ArrayList<String>();
		try {
			String sql = "select Ma_atm from tb_atm where ViTri = '" + duong + "'";
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {

				String item = rs.getString(1);

				arrDuongPho.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrDuongPho;

	}
	
	public static ArrayList<ATM> selectATM(String code_atm,String viTri,int id_phuong) {
		ArrayList<ATM> arrListATM = new ArrayList<>();
		try {
			String sql = "select * from tb_atm where ViTri ='"+ viTri +"' AND Phuong="+id_phuong+" ";
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String Ma_atm = rs.getString("Ma_atm");
				int Quan = rs.getInt("Quan");
				int Phuong = rs.getInt("Phuong");
				String vitri = rs.getString("ViTri");
				String tongtien = rs.getString("Tongtien");
				arrListATM.add(new ATM(Ma_atm,Quan,Phuong,vitri,tongtien));

				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrListATM;
		
	}
	
	public static ArrayList<GiaoDich> selectRutTienATM(String ma) {
		ArrayList<GiaoDich> arrListATM = new ArrayList<>();
		try {
			String sql = "select * from tb_transaction where Ma_atm ='"+ma+"'  ";
			Statement stm = (Statement) conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maGD = rs.getString("Ma_GD");
				String sothe = rs.getString("Sothe_ATM");
				String maATm = rs.getString("Ma_atm");
				String thoigian = rs.getString("ThoiGian");
				String soTien = rs.getString("SoTien");
				String MaKH = rs.getString("MaKH");
				arrListATM.add(new GiaoDich(maGD,sothe,maATm,thoigian,soTien,MaKH));

				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return arrListATM;
		
	}
}

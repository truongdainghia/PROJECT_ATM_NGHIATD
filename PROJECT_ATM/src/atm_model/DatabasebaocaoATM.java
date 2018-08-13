package atm_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import ATM_entity.ATM;
import ATM_entity.ChooseItem;

public class DatabasebaocaoATM {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");

	// get duong pho
	public static  ArrayList<ChooseItem> getDuongPho(int id) {
		 ArrayList<ChooseItem> arrDiaChi = new ArrayList<ChooseItem>();
		 try {
			 String sql = "select ViTri, id from tb_atm where Phuong = '"+id+"'";
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
	
}

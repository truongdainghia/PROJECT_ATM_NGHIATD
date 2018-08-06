package atm_model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import ATM_entity.ChooseItem;

public class DatabaseDiaChi {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");
	public static  ArrayList<ChooseItem> getQuan() {
	 ArrayList<ChooseItem> arrDiaChi = new ArrayList<ChooseItem>();
	 try {
		 String sql = "select Ten, id from tb_district where id >= 1 AND id<=8";
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
	public static  ArrayList<ChooseItem> getPhuong(int id) {
		 ArrayList<ChooseItem> arrDiaChi = new ArrayList<ChooseItem>();
		 try {
			 String sql = "select name, id from tb_ward where Ma_quan = '"+id+"'";
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
	public static String getNameQuan(int id) {
		String Quan = "";
		try {
			Statement stm = (Statement) conn.createStatement();
			String sql = "SELECT * from tb_district WHERE id = " + id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Quan = rs.getString("Ten");
			}
		} catch (Exception e) {
			e.printStackTrace(	);
		}
		return Quan;
	}
	public static String getNamePhuong(int id) {
		String Phuong = "";
		try {
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * from tb_ward WHERE id = " + id;
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Phuong = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace(	);
		}
		return Phuong;
	}

}

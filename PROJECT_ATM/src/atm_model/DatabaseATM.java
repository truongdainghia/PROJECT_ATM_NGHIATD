package atm_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import ATM_entity.ATM;
import ATM_entity.ChooseItem;
import ATM_entity.KhachHang;

@SuppressWarnings("unused")
public class DatabaseATM {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");
	static ArrayList<ATM> arrATM = new ArrayList<ATM>();
	public static ArrayList<ATM> selectATM(){
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from tb_atm");
			while (rs.next()) {
				String maATM = rs.getString("Ma_atm");
			
				int Quan = rs.getInt("Quan");
				int Phuong = rs.getInt("Phuong");
				String viTri = rs.getString("ViTri");
				String tongtien = rs.getString("Tongtien");
				
				arrATM.add(new ATM(maATM, Quan, Phuong,viTri,tongtien));
		}
		}
	 catch(Exception e) {
			e.printStackTrace(	);
	}
		return arrATM;
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
		public static void add(ATM atm) {
			try {
				
			String queryString="insert into tb_atm(Ma_atm,Quan,Phuong,ViTri,Tongtien) values(?,?,?,?,?)";
			PreparedStatement statement=conn.prepareStatement(queryString);
			statement.setString(1, atm.getMa_atm());
			statement.setInt(2, atm.getQuan());
			statement.setInt(3, atm.getPhuong());
			statement.setString(4, atm.getVitri());
			statement.setString(5, atm.getTongTien());
			
		
			
			
			
			
			int x=statement.executeUpdate();
			if(x>0)
			{
			System.out.println("Lưu OK");
			}
			}
			catch(Exception ex)
			{
			ex.printStackTrace();
			}
		}
		public static  void  edit(ATM atm){
			try {
				String queryString = "UPDATE tb_atm SET Quan=?, Phuong=?, ViTri=?, Tongtien=?   WHERE  Ma_atm=?";
				PreparedStatement statement = conn.prepareStatement(queryString);
				
				
				statement.setInt(1, atm.getQuan());
				statement.setInt(2, atm.getPhuong());
				statement.setString(3, atm.getVitri());
				statement.setString(4, atm.getTongTien());
				statement.setString(5, atm.getMa_atm());
			
			
				int x = statement.executeUpdate();
				if (x > 0) {
					System.err.println(" Sửa thành công  .");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		public static  void deleteATM(String id) {
			try {
				String queryString = "delete from tb_atm where Ma_atm=?";
				PreparedStatement statement = conn.prepareStatement(queryString);

			statement.setString(1, id);

				int x = statement.executeUpdate();
				if (x > 0) {
					System.out.println("Delete OK");
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
}

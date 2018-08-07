package atm_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import ATM_entity.KhachHang;


public class DatabaseKhachHang {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");
	static ArrayList<KhachHang> arKH = new ArrayList<KhachHang>();
	public static ArrayList<KhachHang> selectKhachHang(){
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer");
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String tenKH = rs.getString("TenKH");
				String MaPin = rs.getString("MaPin");
				int Quan = rs.getInt("Quan");
				int Phuong = rs.getInt("Phuong");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				String Email = rs.getString("Email");
				String Sothe_ATM = rs.getString("Sothe_ATM");
				String STk_NH = rs.getString("STk_NH");
				String SoTien = rs.getString("SoTien");
				arKH.add(new KhachHang(maKH, tenKH, MaPin, Quan, Phuong, DiaChi, SDT, Email, Sothe_ATM, STk_NH,
						SoTien));
		}
		}
	 catch(Exception e) {
			e.printStackTrace(	);
	}
		return arKH;
}
	public static void add(KhachHang Kh) {
		try {
			
		String queryString="insert into customer(MaKH,TenKH,MaPin,Quan,	Phuong,DiaChi,SDT,Email,Sothe_ATM,STk_NH,SoTien) values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement=conn.prepareStatement(queryString);
		statement.setString(1, Kh.getMaKH());
		statement.setString(2, Kh.getTenKH());
		statement.setString(3, Kh.getmaPin());
		statement.setInt(4, Kh.getQuan());
		statement.setInt(5, Kh.getPhuong());
		statement.setString(6, Kh.getDiaCHi());
		statement.setString(7, Kh.getSDT());
		statement.setString(8, Kh.getEmail());
		statement.setString(9, Kh.getSothe_ATM());
		statement.setString(10, Kh.getSTk_NH());
		statement.setString(11, Kh.getSoTien());
		
		
		
		
		
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
	public static ArrayList<KhachHang> getKHbyId(int code){
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer where id ="+code);
			while (rs.next()) {
				String maKH = rs.getString("MaKH");
				String tenKH = rs.getString("TenKH");
				String MaPin = rs.getString("MaPin");
				int Quan = rs.getInt("Quan");
				int Phuong = rs.getInt("Phuong");
				String DiaChi = rs.getString("DiaChi");
				String SDT = rs.getString("SDT");
				String Email = rs.getString("Email");
				String Sothe_ATM = rs.getString("Sothe_ATM");
				String STk_NH = rs.getString("STk_NH");
				String SoTien = rs.getString("SoTien");
				arKH.add(new KhachHang(maKH, tenKH, MaPin, Quan, Phuong, DiaChi, SDT, Email, Sothe_ATM, STk_NH,
						SoTien));
		}
		}
	 catch(Exception e) {
			e.printStackTrace(	);
	}
		return arKH;
}
	
	public static  void  updateKhachHang(KhachHang sv){
		try {
			String queryString = "UPDATE customer SET  TenKH=?, MaPin=?, Quan=?, Phuong=?, DiaChi=?, SDT=?, Email=?,Sothe_ATM=?, STk_NH=?,SoTien=?  WHERE  MaKH=?";
			PreparedStatement statement = conn.prepareStatement(queryString);
			
			
			statement.setString(1, sv.getTenKH());
			statement.setString(2, sv.getmaPin());
			statement.setInt(3, sv.getQuan());
			statement.setInt(4, sv.getPhuong());
			statement.setString(5, sv.getDiaCHi());
			statement.setString(6, sv.getSDT());
			statement.setString(7, sv.getEmail());
			statement.setString(8, sv.getSothe_ATM());
			statement.setString(9, sv.getSTk_NH());
			statement.setString(10, sv.getSoTien());
			statement.setString(11, sv.getMaKH());
		
			int x = statement.executeUpdate();
			if (x > 0) {
				System.err.println(" Sửa thành công rồi chúng mày ơi .");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static  void deleteKH(String maKH) {
		try {
			String queryString = "delete from customer where MaKH=?";
			PreparedStatement statement = conn.prepareStatement(queryString);

		statement.setString(1, maKH);

			int x = statement.executeUpdate();
			if (x > 0) {
				System.out.println("Delete OK");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

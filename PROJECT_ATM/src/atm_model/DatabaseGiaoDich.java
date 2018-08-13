package atm_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

import ATM_entity.KhachHang;

public class DatabaseGiaoDich {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111", "123456");
	static ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();
	public static ArrayList<KhachHang> getKhachHang(String SOTHE){
		 ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();
		try {
			Statement statement = (Statement) conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from customer where Sothe_ATM='"+SOTHE+"'");
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
				arrKH.add(new KhachHang(maKH, tenKH, MaPin, Quan, Phuong, DiaChi, SDT, Email, Sothe_ATM, STk_NH,
						SoTien));
		}
		}
	 catch(Exception e) {
			e.printStackTrace(	);
	}
		return arrKH;
}
	// lấy dữ liệu tiền trong máy atm từ database
	public int tongTienATM(String maATM) {
		int tongtienATM = 0;
		try {
		String sql = "SELECT TongTien from tb_atm where Ma_atm = '" + maATM + "'";
		Statement statement = (Statement) conn.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {

			String tongTien = rs.getString("tongTien");
			tongtienATM = Integer.parseInt(tongTien);
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return tongtienATM;
	}
	// cập nhật số tiền kh sau khi rút
	public void setTienKH(String soThe ,String tienKHmoi) {
		try {

			String sql = "UPDATE customer  SET SoTien='" + tienKHmoi + "' WHERE Sothe_ATM='" + soThe + "'  ";
			Statement statement = (Statement) conn.createStatement();

			@SuppressWarnings("unused")
			int x = statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void setTienATM(String maATM ,String tongTienATM) {
		try {

			String sql = "UPDATE tb_atm SET Tongtien='" + tongTienATM + "' WHERE Ma_atm='" + maATM + "'  ";
			Statement statement = (Statement) conn.createStatement();

			@SuppressWarnings("unused")
			int x = statement.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void addGD(String a,String b,String c,String d) {
		try {
			String sql = "INSERT INTO tb_transaction(Ma_GD, Sothe_ATM, Ma_atm, SoTien) VALUES " + "('" + a + "','"
					+ b + "','" + c + "','" + d + "')";
			Statement statement = (Statement) conn.createStatement();
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Giao dịch thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void editMK(String maThe, String mkMoi){
		try {

			String sql = "UPDATE customer SET MaPin='" + mkMoi + "' WHERE Sothe_ATM='" + maThe + "'  ";
			Statement statement = (Statement) conn.createStatement();

			@SuppressWarnings("unused")
			int x = statement.executeUpdate(sql);
			if (x > 0) {
				JOptionPane.showMessageDialog(null, "Đổi mã PIN thành công");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	}
	


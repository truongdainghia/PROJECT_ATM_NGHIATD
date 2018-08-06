package atm_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class User_Admin_Model {
	final static Connection conn = ConnectDB.getConnect("localhost", "atm_db", "nghia111",
			"123456");

	public static boolean checkLogin(String userName, String pass) {
		try {
			String sql = "select * from user where user_name = ? and password = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, userName);
			stm.setString(2, pass);
			ResultSet result = stm.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static boolean checkLoginKH(String SoThe, String MaPin) {
		try {
			String sql = "select * from khachhang_id where sothe_atm = ? and code_pin = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, SoThe);
			stm.setString(2, MaPin);
			ResultSet result = stm.executeQuery();
			if (!result.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}



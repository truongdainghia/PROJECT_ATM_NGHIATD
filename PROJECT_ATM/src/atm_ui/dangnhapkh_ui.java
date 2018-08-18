package atm_ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ATM_entity.KhachHang;
import atm_model.DatabaseKhachHang;
import atm_model.User_Admin_Model;

@SuppressWarnings({ "unused", "serial" })
public class dangnhapkh_ui extends JFrame {
	JButton enter = new JButton("ENTER");
	JButton clear = new JButton("CLEAR");
	JButton canCel = new JButton("CANCEL");
	JTextField txt_sothe, txtPin, htLoi;
	
	ActionListener enterClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			String SoThe = txt_sothe.getText();
			String MaPin = txtPin.getText();
			if (SoThe.isEmpty() || MaPin.isEmpty()) {
				htLoi.setText("SỐ THẺ HOẶC MÃ PIN KHÔNG ĐƯỢC ĐỂ TRỐNG !!");
			} else if (login()) {
				dispose();
				layout_ruttien();
			} else {
				htLoi.setText("SỐ THẺ HOẶC MÃ PIN KHÔNG CHÍNH XÁC");
			}

		}
	};

	ActionListener clearClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener canCelClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Login_ui login = new Login_ui("Máy ATM");
			login.showWindow();
			CloseFrame();
		}
	};
	MouseListener tblUserClick = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseClicked(MouseEvent e) {

		}
	};

	public void addEvents() {
		enter.addActionListener(enterClick);
		clear.addActionListener(clearClick);
		canCel.addActionListener(canCelClick);

		// tbl.addMouseListener(tblUserClick);
	}

	public dangnhapkh_ui(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(470, 220);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getRootPane().setDefaultButton(enter);
		enter.requestFocus();
	}

	public void addControls() {
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));

		// tạo id khách hàng đăng nhập'
		JPanel soThe_atm = new JPanel();
		// soThe_atm.setBorder(BorderFactory.createEmptyBorder(250, 10, 10, 10));
		JLabel lblsothe = new JLabel("NHẬP SỐ THẺ");

		lblsothe.setPreferredSize(new Dimension(80, 10));
		lblsothe.setForeground(Color.blue);
		txt_sothe = new JTextField(20);
		// soThe_atm.setBounds(60, 400, 220, 30);

		soThe_atm.add(lblsothe);

		soThe_atm.add(txt_sothe);

		// tạo pannel hiển thị lỗi
		JPanel pnLoi = new JPanel();
		pnLoi.setBackground(Color.CYAN);
		htLoi = new JTextField(30);
		htLoi.setBackground(Color.CYAN);
		htLoi.setForeground(Color.RED);
		htLoi.setHorizontalAlignment(JLabel.CENTER);
		htLoi.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.LIGHT_GRAY));
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 16);

		htLoi.setFont(font);
		// htLoi.setEditable(false);
		pnLoi.add(htLoi);

		// tạo mã pin khách hàng đăng nhập'
		JPanel pnPin = new JPanel();
		pnPin.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		JLabel lblPin = new JLabel("NHẬP MÃ PIN");
		lblPin.setForeground(Color.blue);
		txtPin = new JPasswordField(20);
		pnPin.add(lblPin);
		pnPin.add(txtPin);

		JPanel pnActions = new JPanel();
		pnActions.add(enter);
		pnActions.add(clear);
		pnActions.add(canCel);
		enter.setForeground(Color.BLUE);
		clear.setForeground(Color.GREEN);
		canCel.setForeground(Color.RED);

		pnMain.add(soThe_atm);
		pnMain.add(pnPin);
		pnMain.add(pnActions);
		pnMain.add(pnLoi);
		con.add(pnMain);
	}

	public boolean login() {

		if (User_Admin_Model.checkLoginKH(txt_sothe.getText(), txtPin.getText())) {
			return true;
		} else {
			return false;
		}

	}
	public void layout_ruttien() {
		layout_ruttien rt = new layout_ruttien("title");
		String soThe = txt_sothe.getText();
		rt.showWindow();
		rt.thongTinKH(soThe);
	}
	public void CloseFrame() {
		super.dispose();
	}
}

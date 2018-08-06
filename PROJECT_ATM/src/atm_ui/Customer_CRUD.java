package atm_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ATM_entity.ChooseItem;
import ATM_entity.KhachHang;
import atm_model.DatabaseDiaChi;
import atm_model.DatabaseKhachHang;


public class Customer_CRUD extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton add , update;
	JButton edit = new JButton("SỬA");
	JButton delete = new JButton("XÓA");
	JButton reset = new JButton("RESET");
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txtMa, txtTen, txtPhuong, txtDiaChi, txtEmail, txtSothe, txtSTK_NH, txtPhone, txtSoDu, txtMaPin;
	JComboBox setPhuong, setquan;
	DefaultTableModel dm ;
	private static int stt = 0;
	JTable tbl;
	private ArrayList<ChooseItem> arrPhuong = new ArrayList<>();
	private ArrayList<ChooseItem> arrPhuong1 = new ArrayList<>();
	private static ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();
	private DatabaseKhachHang connectKH = new DatabaseKhachHang();
	
	
	void duLieu() {

		arrKH = connectKH.selectKhachHang();
		
		dm.setRowCount(0);
		for (KhachHang kh : arrKH) {

			String[] row = { kh.getMaKH(), kh.getTenKH(), kh.getDiaCHi() + "," + kh.getPhuong() + "," + kh.getQuan(),
					kh.getEmail(), kh.getSDT(),kh.getSTk_NH() };
			dm.addRow(row);
		}
		
	}

	ActionListener chucnangkhaccl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Admin_Manager login1 = new Admin_Manager("HỆ THỐNG ADMIN");
			login1.showWindow();
			CloseFrame();
		}
	};

	ActionListener thoatcl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Admin login = new Admin("HỆ THỐNG ĐĂNG NHẬP ADMIN");
			login.showWindow();
			CloseFrame();
		}
	};
	ActionListener addClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			//arrKH = connectKH.selectKhachHang();
			int ktTontaiMaKH = 0;
			int ktTontaiSoThe = 0;
			int ktTontaiSoTK_NH = 0;
			
			
			String maKh= txtMa.getText();
			
			String tenKh= txtTen.getText();
			String maPin= txtMaPin.getText();
			ChooseItem check_district = (ChooseItem) setquan.getSelectedItem();
			int id_quan = check_district.getId();
			
			ChooseItem check_ward = (ChooseItem) setPhuong.getSelectedItem();
			int id_phuong = check_ward.getId();
			
			String diaChi= txtDiaChi.getText();
			String sdt= txtPhone.getText();
			String eMail= txtEmail.getText();
			String sothe= txtSothe.getText();
			String soTK_NH= txtSoDu.getText();
			String sodu= txtSTK_NH.getText();
			int checkSizeMa = maKh.length();
			int checkSizeSothe = sothe.length();
			int checkSizeSTK_NH = soTK_NH.length();
			int checksodu = 0;
			
			int checkSoThe = 0;
			int checkSoTK_NH = 0;
			int CheckSotien = 0;
			if(!sodu.isEmpty()) {
				checksodu =	Integer.parseInt(sodu);
			}
			// kiểm tra có tồn tại mã , số thẻ, số tk k
			for (int i =0;i<arrKH.size();i++) {
				if(maKh.equals(arrKH.get(i).getMaKH())) {
					ktTontaiMaKH = 1;
				}
				if(sothe.equals(arrKH.get(i).getSothe_ATM())) {
					ktTontaiSoThe = 1;
				}
				if(soTK_NH.equals(arrKH.get(i).getSTk_NH())) {
					ktTontaiSoTK_NH = 1;
				}
			}
			// kiểm tra k được nhập chữ cho thẻ
			try {
				
				Double soTheATM = Double.parseDouble(sothe);
			}catch (Exception ex){
				checkSoThe = 1;
			}
			// kiểm tra k được nhập chữ cho số tk
			try {
						
							Double soTKATM = Double.parseDouble(sodu);
			}catch (Exception ex){
							checkSoTK_NH = 1;
			}
						// kiểm tra k được nhập chữ cho số tk
			try {
							
							Double sotien = Double.parseDouble(soTK_NH);
			}catch (Exception ex){
							CheckSotien = 1;
						}		
			
				try {
					if (maKh.isEmpty() || tenKh.isEmpty() || maPin.isEmpty() || diaChi.isEmpty()
							|| sdt.isEmpty() || eMail.isEmpty() || sothe.isEmpty() || soTK_NH.isEmpty()
							|| sodu.isEmpty()) {
						String msg = "Vui lòng nhập đầy đủ thông tin";
						JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
				}
					else if(checkSizeMa!=4){
						String msg = " Mã Khách Hàng phải 4 kí tự!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(!(Pattern.matches("^\\+?[0-9. ()-]{10,12}$",sdt ))){
						String msg = " Số điện thoại không đúng!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(checkSizeSothe!=12){
						String msg = " Số thẻ phải là 12 số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else if(checkSoThe>0){
						String msg = " Số thẻ không được nhập kí tự!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(checkSizeSTK_NH!=14){
						String msg = " Số tài khoản phải là 14 số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(checkSoTK_NH>0){
						String msg = " Số tài khoản không được nhập kí tự,phải là số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(CheckSotien>0){
						String msg = " Số tiền không được nhập kí tự,phải là số!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if(checksodu< 50000){
						String msg = " Số tiền không phải trên 50.000vnđ!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (!(Pattern.matches("^[a-zA-Z0-9]+[@]{1}+[a-zA-Z0-9]+[.]{1}+[a-zA-Z0-9]+$", eMail))) {
						String msg = " Địa chỉ emai ko hợp lệ!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (ktTontaiMaKH>0) {
						String msg = " Mã khách hàng đã tồn tại!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (ktTontaiSoThe>0) {
						String msg = " số thẻ đã tồn tại!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else if (ktTontaiSoTK_NH>0) {
						String msg = " số tài khoản ngân hàng đã tồn tại!!";
						JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						
						DatabaseKhachHang.add(new KhachHang(maKh,tenKh,maPin,id_quan,id_phuong,diaChi,sdt,eMail,sothe,soTK_NH,sodu));
						
					}
					
			}catch (Exception ex) {
				
			}
			
			
		}
	};
	ActionListener editClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener deleteClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener resetClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			txtMa.setText("");
			txtTen.setText("");
			txtDiaChi.setText("");
			txtPhone.setText("");
			txtEmail.setText("");
			txtSothe.setText("");
			txtSTK_NH.setText("");
			txtSoDu.setText("");
			txtMaPin.setText("");

//			txtSoThe.setEditable(true);
//			txtMaKH.setEditable(true);
//			txtTK.setEditable(true);
			add.setEnabled(true);
			edit.setEnabled(false);
			delete.setEnabled(false);
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

	// làm click vào 1 hàng nào đó
		ListSelectionListener ChooseRow  = new ListSelectionListener() {
		

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int i =tbl.getSelectedRow();
			if(i>=0 && !e.getValueIsAdjusting()) {
				String ma = tbl.getValueAt(1, 0).toString();
//				setTextToInput(ma);
				add.setEnabled(false);
				for (int j=0;j< arrKH.size();j++) {
					if(ma.equals(arrKH.get(i).getMaKH())) {
						stt = i;
					}
				}
			}
		}

//		private void setTextToInput(String i) {
//			// TODO Auto-generated method stub
//			for (KhachHang kh : arrKH) {
//				if(i.equals(kh.getMaKH())) {
//					txtMa.setText(kh.getMaKH());
//					txtTen.setText(kh.getTenKH());
//					txtMaPin.setText(kh.getmaPin());
//					txtDiaChi.setText(kh.getDiaCHi());
//					txtPhone.setText(kh.getSDT());
//					txtEmail.setText(kh.getEmail());
//					txtSothe.setText(kh.getSothe_ATM());
//					txtSoDu.setText(kh.getSTk_NH());
//					txtSTK_NH.setText(kh.getSoTien());
//					
//					//các trường không được sửa 
//					
//					txtMa.setEditable(false);
//					txtSothe.setEditable(false);
//					txtSoDu.setEditable(false);
//					add.setFocusable(false);
//					edit.setEnabled(true);
//					delete.setEnabled(true);
//					
//					//quận 
//					int quan = kh.getQuan();
//					for (int j=0;j<setquan.getItemCount();j++) {
//						if(quan.equals(setquan.getItemAt(j).toString())) {
//							setquan.setSelectedIndex(j);
//						}
//					}
//					
//					// phường
//					for (int j=0;j<setPhuong.getItemCount();j++) {
//						if(quan.equals(setPhuong.getItemAt(j).toString())) {
//							setPhuong.setSelectedIndex(j);
//						}
//					}
//				}
//			}
//		}
	};
	// làm danh sách cho phường
	public void selectPhuong() {
		arrPhuong.clear();
		int itemCount = setPhuong.getItemCount();
		for(int i =0;i<itemCount;i++) {
			setPhuong.removeItemAt(0);
		}
		ChooseItem itemD = (ChooseItem) setquan.getSelectedItem();
		int id  = itemD.getId();
		arrPhuong = DatabaseDiaChi.getPhuong(id);
		for (ChooseItem o : arrPhuong) {
			setPhuong.addItem(o);
		}
	}
	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectPhuong();
		}
	};
	
	public void addEvents() {
		
		chucnangkhac.addActionListener(chucnangkhaccl);
		thoat.addActionListener(thoatcl);
		add.addActionListener(addClick);
		edit.addActionListener(editClick);
		delete.addActionListener(deleteClick);
		reset.addActionListener(resetClick);
		//tbl.addMouseListener(tblUserClick);
		setquan.addActionListener(chonPhuong);
		tbl.getSelectionModel().addListSelectionListener(ChooseRow);

		// tbl.addMouseListener(tblUserClick);
	}

	public Customer_CRUD(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(920, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {

		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnNorth=new JPanel();
		pnNorth.setBackground(Color.blue);
		//JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		//right.setForeground(Color.red);
		//pnNorth.add(right);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		

		// phân footer
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.BLUE);
		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
		pnSouth.setPreferredSize(new Dimension(200, 150));
		
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần trái màn hình
		JPanel pnWest = new JPanel();
		pnWest.setPreferredSize(new Dimension(200, 50));
		pnWest.setBackground(Color.white);
		// west con
		JPanel pnWestcon = new JPanel();
		// pnWestcon.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		pnWestcon.setPreferredSize(new Dimension(200, 200));
		pnWestcon.setBackground(Color.green);
		JLabel kc1 = new JLabel("                                                      ");
		JLabel kc2 = new JLabel("                                                      ");
		JLabel kc3 = new JLabel("                                                      ");
		JLabel kc4 = new JLabel("                                                      ");
		pnWestcon.add(kc1);
		pnWestcon.add(kc2);
		pnWestcon.add(chucnangkhac);
		thoat.setMargin(new Insets(10, 20, 10, 20));
		chucnangkhac.setMargin(new Insets(10, 20, 10, 20));
		chucnangkhac.setBackground(Color.RED);
		thoat.setBackground(Color.RED);
		pnWestcon.add(kc3);
		pnWestcon.add(kc4);

		pnWestcon.add(thoat);

		pnWest.add(pnWestcon);

		pnBorder.add(pnWest, BorderLayout.WEST);

		// phần bên phải
//		JPanel pnEast = new JPanel();
//
//		pnEast.setBackground(Color.BLUE);
//		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần giữa
		JPanel pnCenter = new JPanel();
		//pnCenter.setBackground(Color.YELLOW);
		//pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(400, 200));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.X_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 300));
		JPanel pnMaKH = new JPanel();
		JLabel lblMaKH = new JLabel("MÃ KHÁCH HÀNG:");
		lblMaKH.setForeground(Color.blue);
		pnMaKH.setOpaque(false);
		// lblMaKH.setPreferredSize(new Dimension(80, 10));
		txtMa = new JTextField(15);
		txtMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaKH.add(lblMaKH);
		pnMaKH.add(txtMa);

		// pnCentercon.add(pnMaKH);

		// tên KH
		JPanel pnTen = new JPanel();
		JLabel lblTen = new JLabel("TÊN KHÁCH HÀNG:");
		lblTen.setForeground(Color.blue);
		// lblMaKH.setPreferredSize(new Dimension(80, 10));
		txtTen = new JTextField(15);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		// pnCentercon.add(pnTen);

		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setOpaque(false);
		JLabel lbldiachi = new JLabel("       ĐỊA CHỈ NHÀ:");
		lbldiachi.setPreferredSize(lblTen.getPreferredSize());
		lbldiachi.setForeground(Color.blue);
		txtDiaChi = new JTextField(15);
		txtDiaChi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnDiaChi.add(lbldiachi);
		pnDiaChi.add(txtDiaChi);

		
		// chon quận
		JPanel pnquan = new JPanel();
		pnquan.setPreferredSize(new Dimension(100, 30));
		JLabel lblquan = new JLabel("CHỌN QUẬN:  ");
		lblquan.setForeground(Color.BLUE);
		setquan = new JComboBox();
		setquan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
		setquan.setPreferredSize(new Dimension(120, 20));
		ArrayList<ChooseItem> quan = new ArrayList<ChooseItem>();
		quan = DatabaseDiaChi.getQuan();
		for (ChooseItem x : quan) {
			setquan.addItem(x);
		}
	

		pnquan.add(lblquan);
		pnquan.add(setquan);

		// pnCentercon.add(pnquan);

		// chọn PHƯỜNG
		JPanel pnPhuong = new JPanel();
		pnPhuong.setPreferredSize(new Dimension(100, 20));
		JLabel lblPhuong = new JLabel("CÁC PHƯỜNG:  ");
		lblPhuong.setForeground(Color.BLUE);
		setPhuong = new JComboBox();
		setPhuong.setPreferredSize(new Dimension(100, 20));
		selectPhuong();
		setPhuong.addItem("Chọn Phường");
		pnPhuong.add(lblPhuong);
		pnPhuong.add(setPhuong);
		// pnPhuong.add(setPhuong);
		// pnCentercon.add(pnPhuong);

		// chọn số đts
		JPanel pnPhone = new JPanel();
		pnPhone.setOpaque(false);
		JLabel nanePhone = new JLabel("        ĐIỆN THOẠI :");
		nanePhone.setForeground(Color.BLUE);
		nanePhone.setPreferredSize(lblTen.getPreferredSize());
		txtPhone = new JTextField(15);
		txtPhone.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnPhone.add(nanePhone);
		pnPhone.add(txtPhone);
		// pnCentercon.add(pnPhone);

		// email
		JPanel pnEmail = new JPanel();
		pnEmail.setOpaque(false);
		JLabel naneEmail = new JLabel("           EMAIL : ");
		naneEmail.setForeground(Color.BLUE);
		naneEmail.setPreferredSize(lblTen.getPreferredSize());
		txtEmail = new JTextField(15);
		txtEmail.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEmail.add(naneEmail);
		pnEmail.add(txtEmail);
		// pnCentercon.add(pnEmail);
		// số tài khoản ngân hàng
		JPanel pnSoThe = new JPanel();
		pnSoThe.setOpaque(false);
		JLabel naneSoThe = new JLabel("    SỐ THẺ ATM :");
		naneSoThe.setForeground(Color.BLUE);
		naneSoThe.setPreferredSize(lblTen.getPreferredSize());
		txtSothe = new JTextField(15);
		txtSothe.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnSoThe.add(naneSoThe);
		pnSoThe.add(txtSothe);
		// pnCentercon.add(pnSoThe);

		JPanel pnTK = new JPanel();
		
		JLabel naneTK = new JLabel("SỐ DƯ :");
		naneTK.setForeground(Color.BLUE);
		txtSTK_NH = new JTextField(15);
		txtSTK_NH.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTK.add(naneTK);
		pnTK.add(txtSTK_NH);

		JPanel pnSoDu = new JPanel();
		pnSoDu.setOpaque(false);
		JLabel naneSoDu = new JLabel("     SỐ TK NGÂN HÀNG :");
		naneSoDu.setForeground(Color.BLUE);
		naneSoDu.setPreferredSize(lblTen.getPreferredSize());
		txtSoDu = new JTextField(15);
		txtSoDu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnSoDu.add(naneSoDu);
		pnSoDu.add(txtSoDu);

		JPanel pnMaPin = new JPanel();
		pnMaPin.setOpaque(false);
		JLabel naneMaPin = new JLabel("      MÃ PIN :");
		naneMaPin.setForeground(Color.BLUE);
		naneMaPin.setPreferredSize(lblTen.getPreferredSize());
		txtMaPin = new JTextField(15);
		txtMaPin.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaPin.add(naneMaPin);
		pnMaPin.add(txtMaPin);
		//ảnh thêm sửa xóa
		ImageIcon update = new ImageIcon(
				new ImageIcon("image/add.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		add= new JButton("THÊM",update);
		
		ImageIcon update1 = new ImageIcon(
				new ImageIcon("image/edit.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		edit= new JButton("SỬA",update1);
		edit.setEnabled(false);
		ImageIcon update2 = new ImageIcon(
				new ImageIcon("image/xoa.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		delete= new JButton("XÓA",update2);
		delete.setEnabled(false);
		ImageIcon update3 = new ImageIcon(
				new ImageIcon("image/reset.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
		reset= new JButton("RESET",update3);

		JPanel pnCenterleft = new JPanel();
		pnCenterleft.setPreferredSize(new Dimension(150, 50));
		pnCenterleft.setLayout(new BoxLayout(pnCenterleft, BoxLayout.Y_AXIS));
		pnCenterleft.add(pnMaKH);
		pnCenterleft.add(pnTen);
		pnCenterleft.add(pnDiaChi);
		pnCenterleft.add(pnEmail);
		pnCenterleft.add(pnPhone);
		
		JPanel pnCenterRight = new JPanel();
		pnCenterRight.setPreferredSize(new Dimension(150, 50));
		pnCenterRight.setLayout(new BoxLayout(pnCenterRight, BoxLayout.Y_AXIS));
		pnCenterRight.add(pnquan);
		pnCenterRight.add(pnPhuong);
		pnCenterRight.add(pnSoDu);
		pnCenterRight.add(pnMaPin);
		pnCenterRight.add(pnSoThe);
		pnCenterRight.add(pnTK);
		
		pnCentercon.add(pnCenterleft);
		
		pnCentercon.add(pnCenterRight);
		

		//
		pnCenter.add(pnCentercon);
		JLabel kc22 = new JLabel("           ");
		JLabel kc23 = new JLabel("           ");
		JLabel kc24 = new JLabel("           ");
		JLabel kc25 = new JLabel("           ");
		JLabel kc26 = new JLabel("           ");
		JLabel kc27 = new JLabel("   ");
		JLabel kc28 = new JLabel("  ");
		JLabel kc29 = new JLabel("  ");
		JLabel kc30 = new JLabel("  ");
		add.setMargin(new Insets(10, 20, 10, 20));
		edit.setMargin(new Insets(10, 20, 10, 20));
		delete.setMargin(new Insets(10, 20, 10, 20));
		reset.setMargin(new Insets(10, 20, 10, 20));
		
		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
//		add.setBackground(Color.GREEN);
//		edit.setBackground(Color.BLUE);
//		delete.setBackground(Color.RED);
//		reset.setBackground(Color.CYAN);
		pnbutton.add(add);
		pnbutton.add(kc22);
		
		pnbutton.add(edit);
		pnbutton.add(kc23);
		pnbutton.add(delete);
		pnbutton.add(kc24);
		pnbutton.add(reset);
//		pnCentercon.add(pnbutton);
		pnCenter.add(pnbutton);
		//pnCenter.add(pnCentercon);

		//JPanel pnActions =new JPanel();
		dm = new DefaultTableModel();
		
		dm.addColumn("Mã");
		dm.addColumn("Tên");
		dm.addColumn("Quận");
		dm.addColumn("Phường");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Số điện thoại");
		dm.addColumn("Email");	
		dm.addColumn("Số TK Ngân Hàng");
		dm.addColumn("Số dư");
		this.getTable();
		
		
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);
		// add thông tin vào pncenter con
		pnSouth.add(sc);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		con.add(pnBorder);
	}
	public void getTable() {
		arrKH = DatabaseKhachHang.selectKhachHang();
		for(int i = 0; i<arrKH.size();i++) {
			dm.addRow(new String[] {arrKH.get(i).getMaKH(),arrKH.get(i).getTenKH(),
					DatabaseDiaChi.getNameQuan(arrKH.get(i).getQuan()),
					DatabaseDiaChi.getNamePhuong(arrKH.get(i).getPhuong()),
					arrKH.get(i).getDiaCHi(),arrKH.get(i).getSDT(),arrKH.get(i).getEmail(),arrKH.get(i).getSTk_NH(),arrKH.get(i).getSoTien()});
		}
	}
	public boolean checkInt(String nhap) {
		try {
			Integer.parseInt(nhap);
			return true;
		}catch (Exception e) {
		return false;
		}
		
	}
	public void CloseFrame(){
	    super.dispose();
	}
}

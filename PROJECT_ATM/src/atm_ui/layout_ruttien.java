package atm_ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ATM_entity.ChooseItem;
import ATM_entity.KhachHang;
import atm_model.DatabaseDiaChi;
import atm_model.DatabaseGiaoDich;
import atm_model.DatabaseKhachHang;
import atm_model.DatabasebaocaoATM;

public class layout_ruttien extends JFrame {
	
	private static final long serialVersionUID = 1L;
	//private KhachHang kh;

	private JTextField txtMaKH, txtTenKH, txtDc, txtSoThe, txtSoTK, txtSoTien, txtSoTienRut, txtMaPin;
	private JPasswordField txtKMCu, txtKMMoi, txtKMNhapLai;
	private JButton btnSoTienRut, btnLuu;
	private JComboBox cboQuan, cboPhuong, cboDuongPho, cboMayATM;
	private ArrayList<ChooseItem> arrPhuong = new ArrayList<>();
	private ArrayList<ChooseItem> arrDuongPho = new ArrayList<>();
	private ArrayList<String> arrMaATM = new ArrayList<>();
	private DatabaseGiaoDich dbGD = new DatabaseGiaoDich();
	private ArrayList<KhachHang> arrTT = new ArrayList<>();
	
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
	ActionListener selectMayATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectMaMay();

		}
	};
	ActionListener selectPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectPhuong();

		}
	};
	ActionListener selectDuongPho = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectDuongPho();

		}
	};
	ActionListener doiMaPin = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		String mkCu = txtKMCu.getText();
		String mkNhapLai = txtKMNhapLai.getText();
		String mkMoi = txtKMMoi.getText();
		String sothe = txtSoThe.getText();
		String maPin = txtMaPin.getText();
		try {
			int checkMK = Integer.parseInt(mkMoi);
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null,
					"Mật khẩu phải là số", "",JOptionPane.INFORMATION_MESSAGE);
		}
		
		if(mkCu.isEmpty()||mkNhapLai.isEmpty()||mkMoi.isEmpty()) {
			JOptionPane.showMessageDialog(null,
					"Hãy điền đầy đủ nhé", "",JOptionPane.INFORMATION_MESSAGE);
					
		}else if(!mkCu.equals(maPin)) {
			JOptionPane.showMessageDialog(null,
					"Mật khẩu cũ không đúng", "",JOptionPane.INFORMATION_MESSAGE);
		}else if(!mkNhapLai.equals(mkMoi)) {
			JOptionPane.showMessageDialog(null,
					"Mật khẩu nhập lại không đúng", "",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(mkMoi.length()!=6) {
			JOptionPane.showMessageDialog(null,
					"Mật khẩu phải là 6 số", "",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(mkCu.equals(mkMoi)) {
			JOptionPane.showMessageDialog(null,
					"Mật khẩu mới không được trùng với mật khẩu cũ", "",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			DatabaseGiaoDich.editMK(sothe,mkNhapLai);
			txtKMCu.setText("");
			txtKMMoi.setText("");
			txtKMNhapLai.setText("");
		}
		}
		
	};
	ActionListener rutTien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
		String soTien = txtSoTienRut.getText();
		if(soTien.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số tiền","",
			JOptionPane.INFORMATION_MESSAGE);
		}else {
			int xacnhan = JOptionPane.YES_NO_OPTION;
			int yesno = JOptionPane.showConfirmDialog(null, "có phải bạn muốn rút"+soTien+"VNĐ","Đông Á Bank", xacnhan);
			if(yesno==JOptionPane.YES_OPTION) {
				thucHienRutTien();
			}
		}

		}
	};
	
	public void thucHienRutTien() {
		//tạo mã giao dịch
		Random rdMaGD = new Random();
		Vector vt = new Vector<>();
		int duoiMa = 7979;
		for (int i = 0; i < 10;) {
			duoiMa = rdMaGD.nextInt(9999);
			if (!vt.contains(duoiMa)) {
				i++;
				vt.add(duoiMa);
			}
		}
		String maGDKH= Integer.toString(duoiMa);
		String maGD = "MGD"+maGDKH;
		String soThe = txtSoThe.getText();
		
		String soTien = txtSoTienRut.getText();
		int sotienrut = Integer.parseInt(soTien);
		//sô tiền trong thẻ
		String soDuTK = txtSoTien.getText();
		int tienCon = 	Integer.parseInt(soDuTK);
		
		//số tiền trong máy ATM
		String maATM = cboMayATM.getSelectedItem().toString();
		int tongtienMayATM = dbGD.tongTienATM(maATM);
		
		int dieukien = sotienrut % 50000;
		if(dieukien>0||sotienrut<50000) {
			JOptionPane.showMessageDialog(null,
			"Trong máy chỉ có mệnh giá  50,000đ,100,000đ,200,000đ,500,000đ", "",
			JOptionPane.INFORMATION_MESSAGE);
		}else if(sotienrut>3000000) {
			JOptionPane.showMessageDialog(null,
			"Số tiền rút không được quá 3 triệu","",
			JOptionPane.INFORMATION_MESSAGE);
		}else if(sotienrut>tienCon) {
			JOptionPane.showMessageDialog(null,
					"Trong thẻ không đủ tiền để rút","",
					JOptionPane.INFORMATION_MESSAGE);
		}else if (sotienrut>tongtienMayATM) {
			JOptionPane.showMessageDialog(null,
					"Tiền trong máy đã hết","",
					JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null,
					"Rút tiền thành công","",
					JOptionPane.INFORMATION_MESSAGE);
			// số tiền còn lại sau khi rút của kh
			int soTienKH = tienCon - sotienrut;
			String tienKHmoi = Integer.toString(soTienKH);
			dbGD.setTienKH(soThe,tienKHmoi);
			
			// số tiền còn lại sau khi rút của máy atm
			int tienMay = tongtienMayATM - sotienrut;
			String tienATMmoi= Integer.toString(tienMay);
			dbGD.setTienATM(maATM,tienATMmoi);
			
			//add vào table giao dịch
			dbGD.addGD(maGD,soThe,maATM,soTien);
			String soThe1=txtSoThe.getText();
			thongTinKH(soThe);
					
		}
	}
	
	public void selectPhuong() {
		try {
		arrPhuong.clear();
		int itemCount = cboPhuong.getItemCount();
		for(int i =0;i<itemCount;i++) {
			cboPhuong.removeItemAt(0);
		}
		ChooseItem itemD = (ChooseItem) cboQuan.getSelectedItem();
		int id  = itemD.getId();
		arrPhuong = DatabaseDiaChi.getPhuong(id);
		for (ChooseItem o : arrPhuong) {
			cboPhuong.addItem(o);
		}}catch (Exception ex){
				
			}
		
	}
	public void selectDuongPho() {
		try {
		arrDuongPho.clear();
		int itemCount = cboDuongPho.getItemCount();
		for(int i =0;i<itemCount;i++) {
			cboDuongPho.removeItemAt(0);
		}
			ChooseItem itemD = (ChooseItem) cboPhuong.getSelectedItem();
			int duongPho = itemD.getId();
			arrDuongPho= DatabasebaocaoATM.getDuongPho(duongPho);
			if(arrDuongPho.isEmpty()) {
				cboDuongPho.addItem("K có máy nào");
			}else {
				for(ChooseItem x : arrDuongPho) {
					cboDuongPho.addItem(x);
				}}
			}catch (Exception ex) {
				
			}
			
			
			}
	public void selectMaMay() {
		try {
			arrMaATM.clear();
			int itemCount = cboMayATM.getItemCount();
			for(int i =0;i<itemCount;i++) {
				cboMayATM.removeItemAt(0);
			}
				ChooseItem itemD = (ChooseItem) cboDuongPho.getSelectedItem();
				String duongPho = itemD.toString();
				arrMaATM= DatabasebaocaoATM.getMaMay(duongPho);
				
				if(arrMaATM.isEmpty()) {
					cboMayATM.addItem("K có máy nào");
				}else 
					
				{
					for(String x : arrMaATM) {
						cboMayATM.addItem(x);
					}}
				}catch (Exception ex) {
					
				}
				
				
				}
	public void thongTinKH(String soThe1) {
		try {
			arrTT = DatabaseGiaoDich.getKhachHang(soThe1);
			for (KhachHang x : arrTT) {
				txtMaKH.setText(x.getMaKH());
				txtTenKH.setText(x.getTenKH());
				txtDc.setText(x.getDiaCHi() + 
				"," +  DatabaseDiaChi.getNamePhuong(x.getPhuong()) + 
				"," + DatabaseDiaChi.getNameQuan(x.getQuan()));
				txtSoThe.setText(x.getSothe_ATM());
				txtSoTK.setText(x.getSTk_NH());
				txtSoTien.setText(x.getSoTien());
				txtMaPin.setText(x.getmaPin());
			}
		} catch (Exception ex) {

		}

	}
	public void addEvents() {
	
		cboQuan.addActionListener(selectPhuong);
		cboPhuong.addActionListener(selectDuongPho);
		cboDuongPho.addActionListener(selectMayATM);
//		txtSoTienRut.addActionListener(rutTien);
		btnSoTienRut.addActionListener(rutTien);
		btnLuu.addActionListener(doiMaPin);
		// tbl.addMouseListener(tblUserClick);
	}

	public layout_ruttien(String title) {
		super(title);
		addControls();
		addEvents();
		//this.kh = kh;
	}

	public void showWindow() {
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {
		Container con = getContentPane();
		txtMaPin = new JTextField();
		CardLayout clMain = new CardLayout();
		JPanel pnMain = new JPanel(clMain) {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				Dimension d = getSize();
				Image img = this.getToolkit().getImage(
						"D:\\FFSE1703.JavaCore\\Assignments\\TuanNM\\du_an_quan_li_ATM\\src\\ffse1703013\\atm\\images\\bgr1.jpg");
				g.drawImage(img, 0, 0, d.width, d.height, null);

				setOpaque(false); // lam trong suot
				super.paintComponent(g);
			}
		};
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setOpaque(false);
		pnDiaChi.setLayout(new BoxLayout(pnDiaChi, BoxLayout.Y_AXIS));

		JPanel pnTitle = new JPanel();
		pnTitle.setOpaque(false);
		pnTitle.setPreferredSize(new Dimension(800, 80));

		JLabel nameTitle = new JLabel("Bạn đang ở đâu??");
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
		nameTitle.setForeground(Color.black);
		nameTitle.setFont(font);
		pnTitle.add(nameTitle);

		JPanel pnQuan = new JPanel();
		pnQuan.setOpaque(false);
		JLabel nameQuan = new JLabel("Quận:");
		nameQuan.setPreferredSize(new Dimension(100, 20));

		cboQuan = new JComboBox<>();
		cboQuan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboQuan.setPreferredSize(new Dimension(140, 20));
		ArrayList<ChooseItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ChooseItem x : quan) {
			cboQuan.addItem(x);
		}

		pnQuan.add(nameQuan);
		pnQuan.add(cboQuan);

		JPanel pnPhuong = new JPanel();
		pnPhuong.setOpaque(false);
		JLabel namePhuong = new JLabel("Phường: ");
		namePhuong.setPreferredSize(new Dimension(100, 20));
		cboPhuong = new JComboBox<>();
		cboPhuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboPhuong.setPreferredSize(new Dimension(140, 20));
		pnPhuong.add(namePhuong);
		pnPhuong.add(cboPhuong);

		JPanel pnDuongPho = new JPanel();
		pnDuongPho.setOpaque(false);
		JLabel nameDuongPho = new JLabel("Đường phố: ");
		nameDuongPho.setPreferredSize(new Dimension(100, 20));
		cboDuongPho = new JComboBox<>();
		cboDuongPho.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboDuongPho.setPreferredSize(new Dimension(140, 20));
		pnDuongPho.add(nameDuongPho);
		pnDuongPho.add(cboDuongPho);

		JPanel pnMayATM = new JPanel();
		pnMayATM.setOpaque(false);
		JLabel nameMayATM = new JLabel("Máy ATM: ");
		nameMayATM.setPreferredSize(new Dimension(100, 20));
		cboMayATM = new JComboBox<>();
		cboMayATM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboMayATM.setPreferredSize(new Dimension(140, 20));
		pnMayATM.add(nameMayATM);
		pnMayATM.add(cboMayATM);

		JPanel pnButton = new JPanel();
		pnButton.setOpaque(false);
		pnButton.setPreferredSize(new Dimension(800, 100));
		JButton btnSubmitDC = new JButton("Submit");
		btnSubmitDC.setPreferredSize(new Dimension(70, 20));
		btnSubmitDC.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		JButton btnLogout = new JButton("Đăng xuất");
		btnLogout.setPreferredSize(new Dimension(70, 20));
		btnLogout.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnButton.add(btnSubmitDC);
		pnButton.add(btnLogout);

		pnDiaChi.add(pnTitle);
		pnDiaChi.add(pnQuan);
		pnDiaChi.add(pnPhuong);
		pnDiaChi.add(pnDuongPho);
		pnDiaChi.add(pnMayATM);
		pnDiaChi.add(pnButton);

		// tạo panel lựa chọn rút tiền
		CardLayout clRutTien = new CardLayout();
		JPanel pnRutTien = new JPanel();
		pnRutTien.setOpaque(false);
		pnRutTien.setLayout(new BoxLayout(pnRutTien, BoxLayout.X_AXIS));

		JPanel pnButtonKH = new JPanel();
		pnButtonKH.setOpaque(false);
		pnButtonKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.darkGray));
		pnButtonKH.setPreferredSize(new Dimension(200, 500));
		pnButtonKH.setLayout(new BoxLayout(pnButtonKH, BoxLayout.Y_AXIS));

		JPanel pnBtnThongTin = new JPanel();
		pnBtnThongTin.setOpaque(false);
		JButton btnBack = new JButton("Quay lại");
		btnBack.setPreferredSize(new Dimension(50, 20));
		btnBack.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		JButton btnCaNhan = new JButton("Rút tiền");
		btnCaNhan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

		btnCaNhan.setPreferredSize(new Dimension(150, 30));
		pnBtnThongTin.add(btnBack);
		pnBtnThongTin.add(btnCaNhan);
		JPanel pnBtnRutTien = new JPanel();
		pnBtnRutTien.setOpaque(false);
		JButton btnRutTien = new JButton("Thông tin cá nhân");
		btnRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		btnRutTien.setPreferredSize(new Dimension(150, 30));
		pnBtnRutTien.add(btnRutTien);
		JPanel pnDemo3 = new JPanel();
		pnDemo3.setOpaque(false);
		pnDemo3.setPreferredSize(new Dimension(200, 200));

		pnButtonKH.add(pnBtnThongTin);
		pnButtonKH.add(pnBtnRutTien);
		pnButtonKH.add(pnDemo3);

		JPanel pndata = new JPanel(clRutTien);
		pndata.setOpaque(false);
		pndata.setBackground(Color.BLUE);
		JPanel pnThongTin = new JPanel();
		pnThongTin.setOpaque(false);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		JLabel nameThongTin = new JLabel("Thông tin khách hàng");
		Font font6 = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		nameThongTin.setFont(font6);

		JPanel pnMaKH = new JPanel();
		pnMaKH.setOpaque(false);
		JLabel nameMaKH = new JLabel("Mã khách hàng: ");
		nameMaKH.setPreferredSize(new Dimension(110, 20));
		txtMaKH = new JTextField(23);
		txtMaKH.setEditable(false);
		txtMaKH.setOpaque(false);
		txtMaKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		pnMaKH.add(nameMaKH);
		pnMaKH.add(txtMaKH);

		JPanel pnTenKH = new JPanel();
		pnTenKH.setOpaque(false);
		JLabel nameTenKH = new JLabel("Tên khách hàng: ");
		nameTenKH.setPreferredSize(new Dimension(110, 20));
		txtTenKH = new JTextField(23);
		txtTenKH.setEditable(false);
		txtTenKH.setOpaque(false);
		txtTenKH.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		pnTenKH.add(nameTenKH);
		pnTenKH.add(txtTenKH);

		JPanel pnDc = new JPanel();
		pnDc.setOpaque(false);
		JLabel nameDc = new JLabel("Địa chỉ: ");
		nameDc.setPreferredSize(new Dimension(110, 20));
		txtDc = new JTextField(23);
		txtDc.setEditable(false);
		txtDc.setOpaque(false);
		txtDc.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		pnDc.add(nameDc);
		pnDc.add(txtDc);

		JPanel pnSoThe = new JPanel();
		pnSoThe.setOpaque(false);
		JLabel nameSoThe = new JLabel("Số thẻ: ");
		nameSoThe.setPreferredSize(new Dimension(110, 20));
		txtSoThe = new JTextField(23);
		txtSoThe.setEditable(false);
		txtSoThe.setOpaque(false);
		txtSoThe.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		pnSoThe.add(nameSoThe);
		pnSoThe.add(txtSoThe);

		JPanel pnSoTK = new JPanel();
		pnSoTK.setOpaque(false);
		JLabel nameSoTK = new JLabel("Số tài khoản: ");
		nameSoTK.setPreferredSize(new Dimension(110, 20));
		txtSoTK = new JTextField(23);
		txtSoTK.setEditable(false);
		txtSoTK.setOpaque(false);
		txtSoTK.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		pnSoTK.add(nameSoTK);
		pnSoTK.add(txtSoTK);

		JPanel pnSoTien = new JPanel();
		pnSoTien.setOpaque(false);
		JLabel nameSoTien = new JLabel("Số tiền trong TK: ");
		nameSoTien.setPreferredSize(new Dimension(110, 20));
		txtSoTien = new JTextField(23);
		txtSoTien.setEditable(false);
		txtSoTien.setOpaque(false);
		txtSoTien.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.WHITE));
		pnSoTien.add(nameSoTien);
		pnSoTien.add(txtSoTien);

		CardLayout clDoiMa = new CardLayout();
		JPanel pnDoiMaPin = new JPanel(clDoiMa);
		pnDoiMaPin.setOpaque(false);
		pnDoiMaPin.setPreferredSize(new Dimension(500, 200));
		pnDoiMaPin.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
		// panel ấn button doi ma
		JPanel pnBntDoiMa = new JPanel();
		pnBntDoiMa.setOpaque(false);
		JButton btnDoiMa = new JButton("Đổi mã pin");
		btnDoiMa.setPreferredSize(new Dimension(80, 20));
		btnDoiMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnBntDoiMa.add(btnDoiMa);

		JPanel pnDataDoiMa = new JPanel();
		pnDataDoiMa.setOpaque(false);
		pnDataDoiMa.setLayout(new BoxLayout(pnDataDoiMa, BoxLayout.Y_AXIS));

		JPanel pnMKTitle = new JPanel();
		pnMKTitle.setOpaque(false);

		JPanel pnTitlesMK = new JPanel();
		pnTitlesMK.setOpaque(false);
		pnTitlesMK.setPreferredSize(new Dimension(350, 25));
		JLabel nameTitleMK = new JLabel("Đỗi mã pin");
		nameTitleMK.setFont(font6);
		pnTitlesMK.add(nameTitleMK);

		JPanel pnBtnDong = new JPanel();
		pnBtnDong.setOpaque(false);
		JButton btnDong = new JButton("Đóng");
		btnDong.setPreferredSize(new Dimension(50, 20));
		btnDong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnBtnDong.add(btnDong);

		pnMKTitle.add(pnTitlesMK);
		pnMKTitle.add(pnBtnDong);

		JPanel pnMKCu = new JPanel();
		pnMKCu.setOpaque(false);
		JLabel nameMKCu = new JLabel("Mã pin cũ:");
		nameMKCu.setPreferredSize(new Dimension(100, 20));
		txtKMCu = new JPasswordField(10);
		txtKMCu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMKCu.add(nameMKCu);
		pnMKCu.add(txtKMCu);

		JPanel pnMKMoi = new JPanel();
		pnMKMoi.setOpaque(false);
		JLabel nameMKMoi = new JLabel("Mã pin mới:");
		nameMKMoi.setPreferredSize(new Dimension(100, 20));
		txtKMMoi = new JPasswordField(10);
		txtKMMoi.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMKMoi.add(nameMKMoi);
		pnMKMoi.add(txtKMMoi);

		JPanel pnMKNhapLai = new JPanel();
		pnMKNhapLai.setOpaque(false);
		JLabel nameMKNhapLai = new JLabel("Nhập lại mã pin:");
		nameMKNhapLai.setPreferredSize(new Dimension(100, 20));
		txtKMNhapLai = new JPasswordField(10);
		txtKMNhapLai.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMKNhapLai.add(nameMKNhapLai);
		pnMKNhapLai.add(txtKMNhapLai);

		JPanel pnBtnLuu = new JPanel();
		pnBtnLuu.setOpaque(false);
		btnLuu = new JButton("Lưu thay đổi");
		btnLuu.setPreferredSize(new Dimension(100, 20));
		btnLuu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnBtnLuu.add(btnLuu);

		pnDataDoiMa.add(pnMKTitle);
		pnDataDoiMa.add(pnMKCu);
		pnDataDoiMa.add(pnMKMoi);
		pnDataDoiMa.add(pnMKNhapLai);
		pnDataDoiMa.add(pnBtnLuu);

		pnDoiMaPin.add(pnBntDoiMa, "1");
		pnDoiMaPin.add(pnDataDoiMa, "2");
		clDoiMa.show(pnDoiMaPin, "1");
		btnCaNhan.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.black));
		btnRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		// bắt sự kiện nhấn button doi mat khẩu
		btnDoiMa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clDoiMa.show(pnDoiMaPin, "2");
			}
		});
		btnDong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clDoiMa.show(pnDoiMaPin, "1");
			}
		});

		pnThongTin.add(nameThongTin);
		pnThongTin.add(pnMaKH);
		pnThongTin.add(pnTenKH);
		pnThongTin.add(pnDc);
		pnThongTin.add(pnSoThe);
		pnThongTin.add(pnSoTK);
		pnThongTin.add(pnSoTien);
		pnThongTin.add(pnDoiMaPin);

		// panel nhập số tiền
		JPanel pnSoTienRut = new JPanel();
		pnSoTienRut.setOpaque(false);
		pnSoTienRut.setLayout(new BoxLayout(pnSoTienRut, BoxLayout.Y_AXIS));
		JPanel pnDemo = new JPanel();
		pnDemo.setOpaque(false);
		JPanel pnTxt = new JPanel();
		pnTxt.setOpaque(false);
		JLabel nameSoTienRut = new JLabel("Số tiền rút :");
		txtSoTienRut = new JTextField(20);
		txtSoTienRut.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnTxt.add(nameSoTienRut);
		pnTxt.add(txtSoTienRut);

		txtSoTienRut.setPreferredSize(new Dimension(110, 20));
		btnSoTienRut = new JButton("Submit");
		btnSoTienRut.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		btnSoTienRut.setPreferredSize(new Dimension(120, 30));
		JPanel pnBtn = new JPanel();
		pnBtn.setOpaque(false);
		pnBtn.add(btnSoTienRut);

		JPanel pnDuLieu = new JPanel();
		pnDuLieu.setOpaque(false);
		pnDuLieu.setLayout(new BoxLayout(pnDuLieu, BoxLayout.Y_AXIS));
		pnDuLieu.setPreferredSize(new Dimension(500, 100));
		pnDuLieu.add(pnTxt);
		pnDuLieu.add(pnBtn);

		JPanel pnDemo2 = new JPanel();
		pnDemo2.setOpaque(false);
		pnDemo2.setPreferredSize(new Dimension(500, 200));
		pnDemo.setPreferredSize(new Dimension(500, 200));

		pnSoTienRut.add(pnDemo2);
		pnSoTienRut.add(pnDuLieu);
		pnSoTienRut.add(pnDemo);

		pndata.add(pnThongTin, "1");
		pndata.add(pnSoTienRut, "2");
		clRutTien.show(pndata, "2");

		btnCaNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clRutTien.show(pndata, "2");
				btnCaNhan.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.black));
				btnRutTien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

			}
		});
		btnRutTien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clRutTien.show(pndata, "1");
				btnCaNhan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				btnRutTien.setBorder(BorderFactory.createMatteBorder(4, 1, 1, 1, Color.black));
			}
		});

		pnRutTien.add(pnButtonKH);
		pnRutTien.add(pndata);
		pnMain.add(pnDiaChi, "1");
		pnMain.add(pnRutTien, "2");
		clMain.show(pnMain, "1");

		con.add(pnMain);
		btnSubmitDC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maMay = cboMayATM.getSelectedItem().toString();
				if (maMay.equals("Không có máy nào")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa chọn Máy ATM");
				} else {

					clMain.show(pnMain, "2");
				}
			}
		});
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				clMain.show(pnMain, "1");
			}
		});
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?", "Logout", dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					//LayoutLogin lg = new LayoutLogin("TP BANK");
					//lg.showWindow();
					dispose();
				}
			}
		});
		selectPhuong();
		selectDuongPho();
		selectMaMay();

	}
	public void CloseFrame() {
		super.dispose();
	}

}

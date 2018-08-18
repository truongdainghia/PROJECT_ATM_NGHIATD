package atm_ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import ATM_entity.ATM;
import ATM_entity.ChooseItem;
import ATM_entity.KhachHang;
import atm_model.DatabaseATM;
import atm_model.DatabaseDiaChi;
import atm_model.DatabaseKhachHang;

@SuppressWarnings({ "unused", "serial" })
public class ATM_ManaGer extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton add = new JButton("THÊM");
	JButton edit = new JButton("SỬA");
	JButton delete = new JButton("XÓA");
	JButton reset = new JButton("RESET");
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txtMa,  txtPhuong  , txtSoDu,txtviTri;
	JComboBox<ChooseItem> setPhuong, setquan;
	DefaultTableModel dm ;
	JTable tbl;
	private  ArrayList<ChooseItem> arrPhuong = new ArrayList<>();
//	private ArrayList<ChooseItem> arrPhuong1 = new ArrayList<>();
	private ArrayList<ATM> arrATM = new ArrayList<ATM>();
	private DatabaseATM connectATM = new DatabaseATM();
	
	
	ActionListener chucnangkhaccl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Admin_Manager login1 = new Admin_Manager("HỆ THỐNG ADMIN");
			login1.showWindow();
			CloseFrame();
			arrATM.clear();
			
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
			// TODO Auto-generated method stub
			int ktTonTaiMaATM = 0;
			int ktNhapTien =0;
			int ktSoTien = 0;
			String maATM = txtMa.getText();
			ChooseItem check_district = (ChooseItem) setquan.getSelectedItem();
			int id_quan = check_district.getId();
			
			ChooseItem check_ward = (ChooseItem) setPhuong.getSelectedItem();
			int id_phuong = check_ward.getId();
			String vitri = txtviTri.getText();
			String tongtien = txtSoDu.getText();
			
			arrATM = DatabaseATM.selectATM();
			for(int i=0;i<arrATM.size();i++) {
				if(maATM.equals(arrATM.get(i).getMa_atm())) {
					ktTonTaiMaATM = 1;
				}
			}
			try {
				
				ktSoTien = Integer.parseInt(tongtien);
			}catch (Exception ex){
				ktNhapTien = 1;
			}
			if(maATM.isEmpty()||vitri.isEmpty()||tongtien.isEmpty()) {
				String msg = "Vui lòng nhập đầy đủ thông tin";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
			}else if(ktTonTaiMaATM>0) {
				String msg = "Mã ATM đã tồn tại";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ktNhapTien>0) {
				String msg = "Tiền nhập vào phải là số";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ktSoTien>900000000) {
				String msg = "Tiền nhập vào không vượt quá 900 triệu";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ktSoTien<10000000) {
				String msg = "Tiền nhập vào không được ít hơn 10 triệu";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
			DatabaseATM.add(new ATM(maATM,id_quan,id_phuong,vitri,tongtien));
			arrATM.clear();
			getTable();
			edit.setEnabled(false);
			delete.setEnabled(false);
			}
		}
	};
	ActionListener editClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int ktNhapTien =0;
			int ktSoTien = 0;
			String maATM = txtMa.getText();
			ChooseItem check_district = (ChooseItem) setquan.getSelectedItem();
			int id_quan = check_district.getId();
			
			ChooseItem check_ward = (ChooseItem) setPhuong.getSelectedItem();
			int id_phuong = check_ward.getId();
			String vitri = txtviTri.getText();
			String tongtien = txtSoDu.getText();
			
			arrATM = DatabaseATM.selectATM();
			
			try {
				
				ktSoTien = Integer.parseInt(tongtien);
			}catch (Exception ex){
				ktNhapTien = 1;
			}
			if(maATM.isEmpty()||vitri.isEmpty()||tongtien.isEmpty()) {
				String msg = "Vui lòng nhập đầy đủ thông tin";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Thiếu", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ktNhapTien>0) {
				String msg = "Tiền nhập vào phải là số,Hoặc không quá 900 triệu";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ktSoTien>900000000) {
				String msg = "Tiền nhập vào không vượt quá 900 triệu";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else if(ktSoTien<10000000) {
				String msg = "Tiền nhập vào không được ít hơn 10 triệu";
				JOptionPane.showMessageDialog(null, msg, "Lỗi Nhập Sai", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				String msg = " Sửa thành công!!";
				JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
			DatabaseATM.edit(new ATM(maATM,id_quan,id_phuong,vitri,tongtien));
			arrATM.clear();
			getTable();
			txtMa.setText("");
			txtviTri.setText("");
			txtSoDu.setText("");
			txtMa.setEditable(true);
			add.setEnabled(true);
			edit.setEnabled(false);
			delete.setEnabled(false);
			}
		}
	};
	ActionListener deleteClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id_atm = txtMa.getText();
			if(id_atm.isEmpty()) {
				String msg = " Bạn chưa chọn mã ATM nhé!!";
				JOptionPane.showMessageDialog(null, msg, "Lỗi nhập", JOptionPane.INFORMATION_MESSAGE);
			}
			else {
				int xoa1 = JOptionPane.YES_NO_OPTION;
				int xoa2 = JOptionPane.showConfirmDialog(null,"Bạn thật sự muốn xóa không", "Message",xoa1);
				if(xoa2==JOptionPane.YES_OPTION) {
					DatabaseATM.deleteATM(id_atm);
					String msg = " Xóa thành công!!";
					JOptionPane.showMessageDialog(null, msg, "HIHI", JOptionPane.INFORMATION_MESSAGE);
					arrATM.clear();
					getTable();
				}
				
			}
		}
	};
	ActionListener resetClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			txtMa.setText("");
			txtviTri.setText("");
			txtSoDu.setText("");
			txtMa.setEditable(true);
			add.setEnabled(true);
			edit.setEnabled(false);
			delete.setEnabled(false);
		}
	};
	public void selectPhuong() {
		arrPhuong.clear();
		int itemCount = setPhuong.getItemCount();
		for(int i =0;i<itemCount;i++) {
			setPhuong.removeItemAt(0);
		}
		ChooseItem itemD = (ChooseItem) setquan.getSelectedItem();
		int id  = itemD.getId();
		arrPhuong = DatabaseDiaChi.getPhuong(id);
		for (ChooseItem x : arrPhuong) {
			setPhuong.addItem(x);
		}
	}
	ActionListener chonPhuong = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			selectPhuong();
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
	
	ListSelectionListener  ChooseRow = new ListSelectionListener(){

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			int i =tbl.getSelectedRow();
			if(i>=0 && !e.getValueIsAdjusting()) {
				String ma = tbl.getValueAt(i, 0).toString();
				
				setText(ma);
				add.setEnabled(false);
				for (int j=0;j< arrATM.size();j++) {
					if(ma.equals(arrATM.get(i).getMa_atm())) {
						int stt = i;
					}
				}
			}
		}
		
	
	};
	@SuppressWarnings("static-access")
	private void setText(String i) {
		arrATM = connectATM.selectATM();
		for (ATM kh : arrATM) {
			if(i.equals(kh.getMa_atm())) {
				txtMa.setText(kh.getMa_atm());
				txtviTri.setText(kh.getVitri());
				txtSoDu.setText(kh.getTongTien());

				
				//các trường không được sửa 
				
				txtMa.setEditable(false);
			
//				txtSoDu.setEditable(false);
				add.setFocusable(false);
				edit.setEnabled(true);
				delete.setEnabled(true);
	}
		}
	}
	public void addEvents() {
		// btnchange_pass.addActionListener(changePassClick);
		chucnangkhac.addActionListener(chucnangkhaccl);
		thoat.addActionListener(thoatcl);
		add.addActionListener(addClick);
		edit.addActionListener(editClick);
		delete.addActionListener(deleteClick);
		reset.addActionListener(resetClick);
		tbl.getSelectionModel().addListSelectionListener(ChooseRow);
		setquan.addActionListener(chonPhuong);

		// tbl.addMouseListener(tblUserClick);
	}

	public ATM_ManaGer(String title) {
		super(title);
		addControls();
		addEvents();
		edit.setEnabled(false);
		delete.setEnabled(false);
	}

	public void showWindow() {
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addControls() {

		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnNorth=new JPanel();
		pnNorth.setBackground(Color.blue);
		JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		right.setForeground(Color.white);
		pnNorth.add(right);
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
		pnCenter.setPreferredSize(new Dimension(200, 200));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.Y_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 300));
		JPanel pnMaKH = new JPanel();
		JLabel lblMaKH = new JLabel("MÃ MÁY ATM:");
		lblMaKH.setForeground(Color.blue);
		pnMaKH.setOpaque(false);
		// lblMaKH.setPreferredSize(new Dimension(80, 10));
		txtMa = new JTextField(25);
		txtMa.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnMaKH.add(lblMaKH);
		pnMaKH.add(txtMa);

		pnCentercon.add(pnMaKH);
		
		JPanel pnquan = new JPanel();
		pnquan.setPreferredSize(new Dimension(100, 20));
		JLabel lblquan = new JLabel("CHỌN QUẬN:  ");
		lblquan.setForeground(Color.BLUE);
		setquan = new JComboBox();
		setquan.setPreferredSize(new Dimension(100, 20));
		ArrayList<ChooseItem> quan = new ArrayList<ChooseItem>();
		quan = DatabaseDiaChi.getQuan();
		for (ChooseItem x : quan) {
			setquan.addItem(x);
		}

		// setquan.addItem("HẢI CHÂU");

		pnquan.add(lblquan);
		pnquan.add(setquan);

		 pnCentercon.add(pnquan);
		 
		 JPanel pnPhuong = new JPanel();
			pnPhuong.setPreferredSize(new Dimension(100, 20));
			JLabel lblPhuong = new JLabel("CÁC PHƯỜNG:  ");
			lblPhuong.setForeground(Color.BLUE);
			setPhuong = new JComboBox();
			setPhuong.setPreferredSize(new Dimension(100, 20));
			selectPhuong();
			pnPhuong.add(lblPhuong);
			pnPhuong.add(setPhuong);
			 
			 pnCentercon.add(pnPhuong);
			 
			 // VỊ TRÍ
			 JPanel pnViTri = new JPanel();
				JLabel lblvitri = new JLabel("VỊ TRÍ ATM:");
				lblvitri.setForeground(Color.blue);
				pnMaKH.setOpaque(false);
				// lblMaKH.setPreferredSize(new Dimension(80, 10));
				txtviTri = new JTextField(25);
				txtviTri.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				pnViTri.add(lblvitri);
				pnViTri.add(txtviTri);

				pnCentercon.add(pnViTri);
				
				JPanel pnTongTien = new JPanel();
				JLabel lbltongtien = new JLabel("TỔNG TIỀN:");
				lbltongtien.setForeground(Color.blue);
				pnTongTien.setOpaque(false);
				// lblMaKH.setPreferredSize(new Dimension(80, 10));
				txtSoDu = new JTextField(25);
				txtSoDu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
				pnTongTien.add(lbltongtien);
				pnTongTien.add(txtSoDu);

				pnCentercon.add(pnTongTien);
				

		JPanel pnCenterRight = new JPanel();
		pnCenterRight.setPreferredSize(new Dimension(150, 50));
		pnCenterRight.setLayout(new BoxLayout(pnCenterRight, BoxLayout.Y_AXIS));

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
		
		//ảnh thêm sửa xóa
				ImageIcon update = new ImageIcon(
						new ImageIcon("image/add.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
				add= new JButton("THÊM",update);
				
				ImageIcon update1 = new ImageIcon(
						new ImageIcon("image/edit.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
				edit= new JButton("SỬA",update1);
				
				ImageIcon update2 = new ImageIcon(
						new ImageIcon("image/xoa.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
				delete= new JButton("XÓA",update2);
				
				ImageIcon update3 = new ImageIcon(
						new ImageIcon("image/reset.png").getImage().getScaledInstance(20, 25, Image.SCALE_SMOOTH));
				reset= new JButton("RESET",update3);

		
		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
		//pnbutton.setPreferredSize(new Dimension(300, 400));
		Font fontsize11=new Font("Arial", Font.BOLD,15);
		add.setFont(fontsize11);
		edit.setFont(fontsize11);
		delete.setFont(fontsize11);
		reset.setFont(fontsize11);
		add.setBackground(Color.CYAN);
		edit.setBackground(Color.CYAN);
		delete.setBackground(Color.CYAN);
		reset.setBackground(Color.CYAN);
		pnbutton.add(add);
		pnbutton.add(kc22);
		
		pnbutton.add(edit);
		pnbutton.add(kc23);
		pnbutton.add(delete);
		pnbutton.add(kc24);
		pnbutton.add(reset);
		pnCentercon.add(pnbutton);

		//JPanel pnActions =new JPanel();
		dm = new DefaultTableModel();
		
		dm.addColumn("Mã máy");
		dm.addColumn("Quận");	
		dm.addColumn("Phường");
		dm.addColumn("Vị Trí");
		dm.addColumn("Tổng tiền");
		ArrayList<ATM> atmList = DatabaseATM.selectATM();
		atmList.clear();
		this.getTable();
		
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);
		// add thông tin vào pncenter con
		pnSouth.add(sc);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		con.add(pnBorder);
	}
	public void getTable() {
		ArrayList<ATM> atmList = DatabaseATM.selectATM();
		dm.setRowCount(0);
		for(int i = 0; i<atmList.size();i++) {
			
			dm.addRow(new String[] {atmList.get(i).getMa_atm(),
					DatabaseATM.getNameQuan(atmList.get(i).getQuan()),
					DatabaseATM.getNamePhuong(atmList.get(i).getPhuong()),
					atmList.get(i).getVitri(),""+ atmList.get(i).getTongTien()
					});
			//alt sip R biến + số ra biến ""+ atmList.get(i).getTongTien()
		}
	}

	public void CloseFrame(){
	    super.dispose();
	}
	}

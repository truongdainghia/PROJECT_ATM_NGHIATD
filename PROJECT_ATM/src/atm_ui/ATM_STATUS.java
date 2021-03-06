
package atm_ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import ATM_entity.ATM;
import ATM_entity.ChooseItem;
import ATM_entity.Transaction;
import atm_model.DatabaseATM;
import atm_model.DatabaseDiaChi;
import atm_model.DatabaseReport_KH;
import atm_model.DatabasebaocaoATM;

@SuppressWarnings({ "unused", "serial" })
public class ATM_STATUS extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton show = new JButton("HIỂN THỊ");
	JButton nhaplai = new JButton("RESET");
	JButton all = new JButton("XEM TẤT CẢ");;
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txttrenPhai, txttrenphai3, txtmay, txtday;
	@SuppressWarnings("rawtypes")
	JComboBox cboPhuong, cboQuan, cboDuongPho, cboMayATM;
	DefaultTableModel dm;
	JTable tbl;
	ArrayList<ATM> arrRePort = new ArrayList<ATM>();
	private ArrayList<ChooseItem> arrPhuong = new ArrayList<>();
	private ArrayList<ChooseItem> arrDuongPho = new ArrayList<>();
	private ArrayList<String> arrMaATM = new ArrayList<>();

	ActionListener chucnangkhaccl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Report login = new Report("GIAO DIỆN CHÍNH CỦA QUẢN LÝ THỐNG KÊ");
			login.showWindow();
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
	ActionListener showcl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener resetClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener allcl = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

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
	ActionListener selectListATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			danhSachATM();
		}
	};

	@SuppressWarnings("unchecked")
	public void selectPhuong() {
		try {
			arrPhuong.clear();
			int itemCount = cboPhuong.getItemCount();
			for (int i = 0; i < itemCount; i++) {
				cboPhuong.removeItemAt(0);
			}
			ChooseItem itemD = (ChooseItem) cboQuan.getSelectedItem();
			int id = itemD.getId();
			arrPhuong = DatabaseDiaChi.getPhuong(id);
			for (ChooseItem o : arrPhuong) {
				cboPhuong.addItem(o);
			}
		} catch (Exception ex) {

		}

	}

	@SuppressWarnings("unchecked")
	public void selectDuongPho() {
		try {
			arrDuongPho.clear();
			int itemCount = cboDuongPho.getItemCount();
			for (int i = 0; i < itemCount; i++) {
				cboDuongPho.removeItemAt(0);
			}
			ChooseItem itemD = (ChooseItem) cboPhuong.getSelectedItem();
			int duongPho = itemD.getId();
			arrDuongPho = DatabasebaocaoATM.getDuongPho(duongPho);
			if (arrDuongPho.isEmpty()) {
				cboDuongPho.addItem("K có máy nào");
			} else {
				for (ChooseItem x : arrDuongPho) {
					cboDuongPho.addItem(x);
				}
			}
		} catch (Exception ex) {

		}

	}

	@SuppressWarnings("unchecked")
	public void selectMaMay() {
		try {
			arrMaATM.clear();
			int itemCount = cboMayATM.getItemCount();
			for (int i = 0; i < itemCount; i++) {
				cboMayATM.removeItemAt(0);
			}
			// ChooseItem itemD = (ChooseItem) cboDuongPho.getSelectedItem();
			// String duongPho = itemD.toString();
			String duongPho = cboDuongPho.getSelectedItem().toString();
			if(duongPho.equals("K có máy nào")) {
				cboMayATM.addItem("Không có máy nào");
			}else {
				String ten = cboDuongPho.getSelectedItem().toString();
				arrMaATM = DatabasebaocaoATM.getMaMay(duongPho);
				if(arrMaATM.isEmpty()) {
					cboMayATM.addItem("Không có máy nào");
				}
				else {
					cboMayATM.addItem("Tất cả");
					for (String x : arrMaATM) {
						cboMayATM.addItem(x);
					}
				}
			}
		
		} catch (Exception ex) {

		}

	}

	public void danhSachATM() {
		try {

			ChooseItem check_ward = (ChooseItem) cboPhuong.getSelectedItem();
			int id_phuong = check_ward.getId();
			String code_atm = cboMayATM.getSelectedItem().toString();
			String viTri = cboDuongPho.getSelectedItem().toString();
		
			if (viTri.equals("K có máy nào") && code_atm.equals("Empty")) {

				dm.setRowCount(0);
			}
				
			else {
				arrRePort.clear();
				dm.setRowCount(0);
				arrRePort = DatabasebaocaoATM.selectATM(code_atm, viTri, id_phuong);
				if(code_atm.equals("Tất cả")) {
					for (ATM x : arrRePort) {
						DecimalFormat df = new DecimalFormat("###,###,###");
						String soTien = df.format(Integer.parseInt(x.getTongTien())) + " VNĐ";

						String[] row = {x.getMa_atm(),DatabaseDiaChi.getNameQuan(x.getQuan())+","
								+DatabaseDiaChi.getNamePhuong(x.getPhuong())+","+x.getVitri(),soTien };
						dm.addRow(row);
					}
				}
				else {
					for (ATM x : arrRePort)
					if(code_atm.equals(x.getMa_atm())) {
						DecimalFormat df = new DecimalFormat("###,###,###");
						String soTien = df.format(Integer.parseInt(x.getTongTien())) + " VNĐ";

						String[] row = {x.getMa_atm(),DatabaseDiaChi.getNameQuan(x.getQuan())+","
								+DatabaseDiaChi.getNamePhuong(x.getPhuong())+","+x.getVitri(),soTien };
						dm.addRow(row);
					}
				}
			}
				
					
				

		
		} catch (Exception ex) {
		}
	}

	public void addEvents() {
		// btnchange_pass.addActionListener(changePassClick);
		chucnangkhac.addActionListener(chucnangkhaccl);
		thoat.addActionListener(thoatcl);
		cboQuan.addActionListener(selectPhuong);
		cboPhuong.addActionListener(selectDuongPho);
		cboDuongPho.addActionListener(selectMayATM);
		cboMayATM.addActionListener(selectListATM);
		show.addActionListener(showcl);
		nhaplai.addActionListener(resetClick);
		all.addActionListener(allcl);
		tbl.addMouseListener(tblUserClick);

		// tbl.addMouseListener(tblUserClick);
	}

	public ATM_STATUS(String title) {
		super(title);
		addControls();
		addEvents();
		danhSachATM();
	}

	public void showWindow() {
		this.setSize(900, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addControls() {

		Container con = getContentPane();
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		JPanel pnNorth = new JPanel();
		pnNorth.setBackground(Color.blue);
		// JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		// right.setForeground(Color.white);
		// pnNorth.add(right);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.blue);
		JLabel duoi = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		duoi.setForeground(Color.white);
		pnSouth.add(duoi);
		pnSouth.setPreferredSize(new Dimension(20, 30));
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phân footer
		// JPanel pnSouth = new JPanel();
		// //pnSouth.setBackground(Color.BLUE);
		// pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
		// pnSouth.setPreferredSize(new Dimension(200, 300));
		//
		// pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần trái màn hình
		JPanel pnWest = new JPanel();
		// pnWest.setPreferredSize(new Dimension(200, 50));
		pnWest.setBackground(Color.RED);
		// west con
		JPanel pnWestcon = new JPanel();
		// pnWestcon.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		pnWestcon.setPreferredSize(new Dimension(200, 600));
		pnWestcon.setBackground(Color.PINK);
		JLabel kc1 = new JLabel("                                                      ");
		JLabel kc2 = new JLabel("                                                      ");
		JLabel kc3 = new JLabel("                                                      ");
		JLabel kc4 = new JLabel("                                                      ");
		pnWestcon.add(kc1);
		pnWestcon.add(kc2);
		pnWestcon.add(chucnangkhac);
		thoat.setMargin(new Insets(10, 20, 10, 20));
		chucnangkhac.setMargin(new Insets(10, 20, 10, 20));
		chucnangkhac.setBackground(Color.GREEN);
		chucnangkhac.setForeground(Color.blue);
		thoat.setBackground(Color.GREEN);
		thoat.setForeground(Color.blue);
		pnWestcon.add(kc3);
		pnWestcon.add(kc4);

		pnWestcon.add(thoat);

		pnWest.add(pnWestcon);

		pnBorder.add(pnWest, BorderLayout.WEST);

		// phần bên phải
		// JPanel pnEast = new JPanel();
		//
		// pnEast.setBackground(Color.BLUE);
		// pnBorder.add(pnEast, BorderLayout.EAST);

		// phần giữa
		JPanel pnCenter = new JPanel();
		// pnCenter.setBackground(Color.YELLOW);
		// pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(200, 100));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.Y_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 270));

		JPanel pntren = new JPanel();
		pntren.setLayout(new BoxLayout(pntren, BoxLayout.X_AXIS));
		pntren.setPreferredSize(new Dimension(100, 30));
		JPanel pntrenTrai = new JPanel();
		pntrenTrai.setPreferredSize(new Dimension(100, 30));
		pntren.add(pntrenTrai);
		// JLabel lblTrenTrai = new JLabel("Chọn Thông tin");
		// pntren.add(lblTrenTrai);
		// phần trên phải
		JPanel pntrenPhai = new JPanel();
		pntrenPhai.setLayout(new BoxLayout(pntrenPhai, BoxLayout.Y_AXIS));
		JPanel pntrenPhai1 = new JPanel();
		// pntrenPhai1.setPreferredSize(new Dimension(100, 50));
		JLabel lblPhuong = new JLabel("CHỌN PHƯỜNG:  ");
		lblPhuong.setForeground(Color.BLUE);
		cboPhuong = new JComboBox();
		selectPhuong();
		cboPhuong.setPreferredSize(new Dimension(100, 20));
		cboPhuong.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));

		pntrenPhai1.add(lblPhuong);
		pntrenPhai1.add(cboPhuong);

		// trên phải vị trí thứ 2
		JPanel pntrenPhai2 = new JPanel();
		// pntrenPhai2.setPreferredSize(new Dimension(130, 20));
		JLabel lblquan = new JLabel("CHỌN QUẬN:        ");
		lblquan.setForeground(Color.BLUE);
		cboQuan = new JComboBox<String>();
		cboQuan.setPreferredSize(new Dimension(100, 20));
		cboQuan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		ArrayList<ChooseItem> quan = new ArrayList<>();
		quan = DatabaseDiaChi.getQuan();
		for (ChooseItem x : quan) {
			cboQuan.addItem(x);
		}

		pntrenPhai2.add(lblquan);
		pntrenPhai2.add(cboQuan);
		pntrenPhai.add(pntrenPhai2);
		pntrenPhai.add(pntrenPhai1);

		JPanel pntrenPhai3 = new JPanel();
		JLabel nameDuongPho = new JLabel("    Đường phố: ");
		nameDuongPho.setForeground(Color.BLUE);
		nameDuongPho.setPreferredSize(new Dimension(100, 20));
		cboDuongPho = new JComboBox<>();
		cboDuongPho.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboDuongPho.setPreferredSize(new Dimension(100, 20));
		pntrenPhai3.add(nameDuongPho);

		pntrenPhai3.add(cboDuongPho);
		pntrenPhai.add(pntrenPhai3);

		JPanel pnTrenGiua = new JPanel();
		pnTrenGiua.setPreferredSize(new Dimension(100, 20));
		JLabel lbltrengiua = new JLabel("CHỌN THÔNG TIN:");
		lbltrengiua.setForeground(Color.black);
		JPanel pnTrenGiua1 = new JPanel();
		JLabel lbltrengiua1 = new JLabel("                                         ");
		pnTrenGiua1.add(lbltrengiua1);
		pnTrenGiua.add(pnTrenGiua1);

		pnTrenGiua.add(lbltrengiua);
		pntren.add(pnTrenGiua);

		pntren.add(pntrenPhai);
		pnCentercon.add(pntren);
		//
		// JPanel pngiua = new JPanel();
		// JLabel lblgiua = new JLabel(" ");
		// pngiua.add(lblgiua);
		// pntren.add(pngiua);

		// center dưới
		JPanel pnduoi = new JPanel();
		pnduoi.setLayout(new BoxLayout(pnduoi, BoxLayout.X_AXIS));
		JPanel pnduoitrai = new JPanel();
		JLabel lblmay = new JLabel("Chọn máy ATM");
		pnduoitrai.add(lblmay);

		cboMayATM = new JComboBox<>();
		cboMayATM.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboMayATM.setPreferredSize(new Dimension(140, 20));
		pnduoitrai.add(cboMayATM);
		pnduoi.add(pnduoitrai);

		JPanel pnduoiphai = new JPanel();
		pnduoiphai.add(all);
		pnduoi.add(pnduoiphai);
		pnCentercon.add(pnduoi);


		// VỊ TRÍ
		// add button
		JPanel Actions = new JPanel();
		Actions.setPreferredSize(new Dimension(200, 30));
		JLabel kca1 = new JLabel("      ");
		show.setForeground(Color.blue);
		show.setBackground(Color.GREEN);
		nhaplai.setForeground(Color.blue);
		nhaplai.setBackground(Color.GREEN);
		Actions.add(show);
		Actions.add(kca1);
		Actions.add(nhaplai);
		pnCentercon.add(Actions);
		//pnCentercon.add(pnday);
		selectPhuong();
		selectDuongPho();
		selectMaMay();
		// danhSachATM();

		pnCenter.add(pnCentercon);

		dm = new DefaultTableModel();

		dm.addColumn("Mã máy");
		dm.addColumn("Vị trí");
		dm.addColumn("Số tiền còn");

		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		sc.setPreferredSize(new Dimension(650, 600));
		sc.setForeground(Color.BLUE);
		// add thông tin vào pncenter con
		pnCenter.add(sc);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		con.add(pnBorder);
	}

	public void CloseFrame() {
		super.dispose();
	}
}

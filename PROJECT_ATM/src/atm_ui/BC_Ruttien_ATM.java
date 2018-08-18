
package atm_ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ATM_entity.ChooseItem;
import ATM_entity.GiaoDich;
import atm_model.DatabaseDiaChi;
import atm_model.DatabasebaocaoATM;

@SuppressWarnings({ "unused", "serial" })
public class BC_Ruttien_ATM extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");

	JButton all = new JButton("XEM TẤT CẢ");;
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txttrenPhai, txttrenphai3, txtmay, txtday, txtdiachi, txtphai2, txtthang, txtchitiet1, txtchitiet2;
	@SuppressWarnings("rawtypes")
	JComboBox cboPhuong, cboQuan, cboDuongPho, cboMayATM;
	DefaultTableModel dm;
	JTable tbl;
	@SuppressWarnings("rawtypes")
	JComboBox cboThang, cboNam;
	ArrayList<GiaoDich> arrRePort = new ArrayList<GiaoDich>();

	JButton btnShowThang, btnHuyThang, btnShowNam, btnHuyNam;
	private JDateChooser dateStart, dateEnd;
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
	ActionListener selectKHTheoNam = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				selectKHTheoNam();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	};
	public void selectKHTheoNam() throws ParseException {
		
		String maATM = cboMayATM.getSelectedItem().toString();
		String tgian = "yyyy-MM-dd";
		java.util.Date start =  dateStart.getDate();
		java.util.Date end =  dateEnd.getDate();
		SimpleDateFormat dateformat = new SimpleDateFormat(tgian);
		String begin = dateformat.format(start);
		String theEnd = dateformat.format(end);
		int demNgay = DatabasebaocaoATM.tinhKhoangTG(begin, theEnd);
		arrRePort.clear();
		dm.setRowCount(0);
		arrRePort = DatabasebaocaoATM.selectKHTheoThoiGian(maATM,begin,theEnd);
//		if (arrRePort.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong thời gian này!!");
//			}
//		else {
//		if(begin.isEmpty()) {
//				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu!!");
//				}
//			else if(theEnd.isEmpty()){
//				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày kết thúc!!");
//				}
//			else if(demNgay<0){
//				JOptionPane.showMessageDialog(null, "Số ngày bắt đầu phải lớn hơn ngày kết thúc!!");
//				}
//			else if(demNgay>90){
//				JOptionPane.showMessageDialog(null, "Khoảng thời gian không được vượt quá 90 ngày!!");
//				}
//			
//			else {
			for (GiaoDich h : arrRePort) {

				DecimalFormat df = new DecimalFormat("###,###,###");
				String soTien = df.format(Integer.parseInt((h.getSoTien()))) + " VNĐ";

				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ", new Locale("vi", "VN"));
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = "";
				try {
					time = sdf.format(sdf2.parse(h.getThoiGian()));
				} catch (Exception ex) {
					ex.printStackTrace();

				}
				dm.addRow(new String[] { h.getMaGD(), h.getSoThe(), time, soTien });
			}
			
		}
		
	
	ActionListener selectKHTheoThang = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			selectKHTheoThang();
			
	};

	public void selectKHTheoThang() {
		String maATM = cboMayATM.getSelectedItem().toString();
		String month = cboThang.getSelectedItem().toString();
		String year = cboNam.getSelectedItem().toString();
		String date = year + "-" + month;

		arrRePort.clear();
		try {
			arrRePort = DatabasebaocaoATM.selectATMTheoThang(maATM, date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		dm.setRowCount(0);
		if (arrRePort.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong thời gian này!!");
		} else {
			for (GiaoDich h : arrRePort) {

				DecimalFormat df = new DecimalFormat("###,###,###");
				String soTien = df.format(Integer.parseInt((h.getSoTien()))) + " VNĐ";

				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ", new Locale("vi", "VN"));
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time = "";
				try {
					time = sdf.format(sdf2.parse(h.getThoiGian()));
				} catch (Exception ex) {
					ex.printStackTrace();

				}
				dm.addRow(new String[] { h.getMaGD(), h.getSoThe(), time, soTien });
			}
		}
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
			if (duongPho.equals("K có máy nào")) {
				cboMayATM.addItem("Không có máy nào");
			} else {
				String ten = cboDuongPho.getSelectedItem().toString();
				arrMaATM = DatabasebaocaoATM.getMaMay(duongPho);
				if (arrMaATM.isEmpty()) {
					cboMayATM.addItem("Không có máy nào");
				} else {

					for (String x : arrMaATM) {
						cboMayATM.addItem(x);
					}
				}
			}

		} catch (Exception ex) {

		}

	}

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

	ActionListener selectListATM = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			danhSachATM();
		}
	};

	public void danhSachATM() {
		try {

			ChooseItem check_ward = (ChooseItem) cboPhuong.getSelectedItem();
			int id_phuong = check_ward.getId();
			String code_atm = cboMayATM.getSelectedItem().toString();
			String viTri = cboDuongPho.getSelectedItem().toString();

			if (viTri.equals("K có máy nào") && code_atm.equals("Empty")) {
				arrRePort.clear();
				dm.setRowCount(0);
			} else {
				arrRePort.clear();
				dm.setRowCount(0);
				arrRePort = DatabasebaocaoATM.selectRutTienATM(code_atm);
				for (GiaoDich x : arrRePort) {
					DecimalFormat df = new DecimalFormat("###,###,###");
					String soTien = df.format(Integer.parseInt((x.getSoTien()))) + " VNĐ";

					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ", new Locale("vi", "VN"));
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String time = "";
					try {
						time = sdf.format(sdf2.parse(x.getThoiGian()));
					} catch (Exception ex) {
						ex.printStackTrace();

					}
					dm.addRow(new String[] { x.getMaGD(), x.getSoThe(), time, soTien });
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
		btnShowThang.addActionListener(selectKHTheoThang);
		 btnShowNam.addActionListener(selectKHTheoNam);
		all.addActionListener(allcl);
		tbl.addMouseListener(tblUserClick);

		// tbl.addMouseListener(tblUserClick);
	}

	public BC_Ruttien_ATM(String title) {
		super(title);
		addControls();
		addEvents();
		danhSachATM();
	}

	public void showWindow() {
		this.setSize(1000, 700);
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
		pnCenter.setPreferredSize(new Dimension(200, 500));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.Y_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 380));

		// pn center tren
		JPanel pntren = new JPanel();
		pntren.setLayout(new BoxLayout(pntren, BoxLayout.X_AXIS));
		pntren.setPreferredSize(new Dimension(100, 30));
//		JPanel pntrenTrai = new JPanel();
//		pntrenTrai.setPreferredSize(new Dimension(100, 30));
//		pntren.add(pntrenTrai);

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
		JLabel nameDuongPho = new JLabel("    VỊ TRÍ: ");
		nameDuongPho.setForeground(Color.BLUE);
		nameDuongPho.setPreferredSize(new Dimension(100, 20));
		cboDuongPho = new JComboBox<>();
		cboDuongPho.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		cboDuongPho.setPreferredSize(new Dimension(100, 20));
		pntrenPhai3.add(nameDuongPho);

		pntrenPhai3.add(cboDuongPho);
		pntrenPhai.add(pntrenPhai3);

//		JPanel pnTrenGiua = new JPanel();
//		pnTrenGiua.setPreferredSize(new Dimension(100, 20));
//		JLabel lbltrengiua = new JLabel("CHỌN THÔNG TIN:");
//		lbltrengiua.setForeground(Color.black);
//		JPanel pnTrenGiua1 = new JPanel();
//		JLabel lbltrengiua1 = new JLabel("                                         ");
//		pnTrenGiua1.add(lbltrengiua1);
//		pnTrenGiua.add(pnTrenGiua1);

		//pnTrenGiua.add(lbltrengiua);
		//pntren.add(pnTrenGiua);

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

		// làm cardlayout để chon hiển thị theo thời gian
		JPanel pnTime = new JPanel();
		Border bd1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder tblBorder = BorderFactory.createTitledBorder(bd1, "Chọn Thời Gian", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		pnTime.setBorder(tblBorder);

		// chọn thời gian để hiển thị
		JPanel pnRadio = new JPanel();
		pnRadio.setLayout(new BoxLayout(pnRadio, BoxLayout.Y_AXIS));
		JRadioButton rd1 = new JRadioButton("Theo tháng");
		rd1.setPreferredSize(new Dimension(200, 20));
		rd1.setBounds(20, 20, 20, 20);
		rd1.setSelected(true);
		JRadioButton rd2 = new JRadioButton("Khoảng Thời Gian");
		rd2.setPreferredSize(new Dimension(200, 20));
		rd2.setBounds(20, 20, 20, 20);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rd1);
		bg.add(rd2);
		pnRadio.add(rd1);
		pnRadio.add(rd2);

		// panel ngày tháng
		CardLayout clTime = new CardLayout();
		JPanel pnNhap = new JPanel(clTime);
		String[] thang = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" };
		String[] nam = new String[] { "2016", "2017", "2018", "2019" };
		JPanel pnNamThang = new JPanel();
		JLabel lblthang = new JLabel("Tháng");
		cboThang = new JComboBox<>(thang);
		cboThang.setPreferredSize(new Dimension(60, 20));

		JLabel lblNam = new JLabel("Năm");
		cboNam = new JComboBox<>(nam);
		cboNam.setPreferredSize(new Dimension(60, 20));

		btnShowThang = new JButton("Hiển Thị");
		// btnShowThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
		// Color.black));
		btnHuyThang = new JButton("ReSet");
		// btnHuyThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
		// Color.black));
		pnNamThang.add(lblthang);
		pnNamThang.add(cboThang);
		pnNamThang.add(lblNam);
		pnNamThang.add(cboNam);
		pnNamThang.add(btnShowThang);
		pnNamThang.add(btnHuyThang);

		// pn khoảng thời gian
		JLabel timeStart = new JLabel("Từ ngày: ");
		dateStart = new JDateChooser();
		dateStart.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dateStart.setDateFormatString("dd-MM-yyyy");
		JTextFieldDateEditor started = (JTextFieldDateEditor) dateStart.getDateEditor();
		started.setEditable(false);
		dateStart.setPreferredSize(new Dimension(100, 20));

		// ngày kết thúc
		JLabel timeEnd = new JLabel("Đến ngày: ");
		dateEnd = new JDateChooser();
		dateEnd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		dateEnd.setDateFormatString("dd-MM-yyyy");
		JTextFieldDateEditor end = (JTextFieldDateEditor) dateStart.getDateEditor();
		end.setEditable(false);
		dateEnd.setPreferredSize(new Dimension(100, 20));
		btnShowNam = new JButton("Hiển Thị");
		// btnShowThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
		// Color.black));
		btnHuyNam = new JButton("ReSet");
		// btnHuyThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,
		// Color.black));
		JPanel pnKhoangThoiGian = new JPanel();
		pnKhoangThoiGian.add(timeStart);
		pnKhoangThoiGian.add(dateStart);
		pnKhoangThoiGian.add(timeEnd);
		pnKhoangThoiGian.add(dateEnd);
		pnKhoangThoiGian.add(btnShowNam);
		pnKhoangThoiGian.add(btnHuyNam);

		pnNhap.add(pnNamThang, "1");
		pnNhap.add(pnKhoangThoiGian, "2");
		clTime.show(pnNhap, "1");

		rd1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clTime.show(pnNhap, "1");
			}
		});

		rd2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				clTime.show(pnNhap, "2");
			}
		});

		pnTime.add(pnRadio);
		pnTime.add(pnNhap);
		pnCentercon.add(pnTime);

		// VỊ TRÍ
		// add button
		JPanel Actions = new JPanel();
		Actions.setPreferredSize(new Dimension(200, 30));
		JLabel kca1 = new JLabel("      ");
		Actions.add(kca1);

		pnCentercon.add(Actions);
		selectPhuong();
		selectDuongPho();
		selectMaMay();

		pnCenter.add(pnCentercon);

		dm = new DefaultTableModel();

		dm.addColumn("Mã Giao Dịch");
		dm.addColumn("Số thẻ");
		dm.addColumn("Thời Gian");
		dm.addColumn("Số tiền");

		tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl);
		sc.setPreferredSize(new Dimension(770, 600));
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

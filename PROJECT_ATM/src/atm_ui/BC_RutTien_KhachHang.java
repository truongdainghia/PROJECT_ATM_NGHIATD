

package atm_ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Date;


import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import ATM_entity.GiaoDich;
import ATM_entity.KhachHang;
import ATM_entity.Transaction;
import atm_model.DatabaseDiaChi;
import atm_model.DatabaseKhachHang;
import atm_model.DatabaseReport_KH;


import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BC_RutTien_KhachHang extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton show = new JButton("XEM THÊM");
	JButton nhaplai = new JButton("HOME");
;
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txtTen, txtnhapMA,txtTime;
	JComboBox cboThang, cboNam;
	DefaultTableModel dm ;
	JTable tbl;
	JButton btnShowThang,btnHuyThang,btnShowNam,btnHuyNam;
	private JDateChooser dateStart, dateEnd;
	ArrayList<Transaction> arrTK = new ArrayList<Transaction>();

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
	
	ActionListener selectKH = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			selectKH();
		}
	};
	ActionListener selectKHTheoThang = new ActionListener() {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			selectKHTheoThang();
		}
	};
	ActionListener selectKHTheoNam = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			selectKHTheoNam();
		}
	};
	public void selectKHTheoNam() {
			ArrayList<GiaoDich> arrBC =new ArrayList<>();
			try {
			String tgian = "yyyy-MM-dd";
			Date start = dateStart.getDate();
			Date end = dateEnd.getDate();
			SimpleDateFormat dateformat = new SimpleDateFormat(tgian);
			String begin = dateformat.format(start) ;
			String theEnd = dateformat.format(end) ;
			String maKH = txtnhapMA.getText();
			int demngay = DatabaseReport_KH.tinhKhoangTG(begin,theEnd);
			
		if(maKH.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng!!");
		}else {
				if(begin.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày bắt đầu!!");
				}
			else if(theEnd.isEmpty()){
				JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày kết thúc!!");
				}
			else if(demngay<0){
				JOptionPane.showMessageDialog(null, "Số ngày bắt đầu phải lớn hơn ngày kết thúc!!");
				}
			else if(demngay>90){
				JOptionPane.showMessageDialog(null, "Khoảng thời gian không được vượt quá 90 ngày!!");
				}
			else {
				
				arrBC.clear();
				arrBC = DatabaseReport_KH.selectKHTheoKhoangTG(maKH,begin,theEnd);
				if(arrBC.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có giao dịch nào trong thời gian này!!");
				}
				else {
					for(GiaoDich k : arrBC) {
						DecimalFormat df = new DecimalFormat("###,###,###");
						
						String soTien = df.format(Integer.parseInt((k.getSoTien()))) + " VNĐ";
						
						SimpleDateFormat sdf =new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",new Locale("vi", "VN"));
						SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
						
						String time = "";
						try {
							time = sdf.format(sdf2.parse(k.getThoiGian()));
						}catch (Exception   ex) {
							ex.printStackTrace();
							
						}
						dm.addRow(new String[] {k.getMaGD(), k.getMaATM(), time,soTien});
					}
				}
			}
			}
			}
					
			
	catch(Exception ex) {
		
	}
			
	}
	
	public void selectKHTheoThang() {
		ArrayList<GiaoDich> arrBC =new ArrayList<>();
		String thang = cboThang.getSelectedItem().toString();
		String nam = cboNam.getSelectedItem().toString();
		String thangnam = nam + "-" + thang;
		String maKH = txtnhapMA.getText();
		if(maKH.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã khách hàng!!");
		}else
			arrBC.clear();
			dm.setRowCount(0);
			
			arrBC= DatabaseReport_KH.selectKHTheoThang(maKH,thangnam);
			if(arrBC.isEmpty()){
				JOptionPane.showMessageDialog(null, "Khách hàng chưa có giao dịch nào!!");
			}else{
				for(GiaoDich m : arrBC) {
					DecimalFormat df = new DecimalFormat("###,###,###");
					
					String soTien = df.format(Integer.parseInt((m.getSoTien()))) + " VNĐ";
					
					SimpleDateFormat sdf =new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",new Locale("vi", "VN"));
					SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
					
					String time = "";
					try {
						time = sdf.format(sdf2.parse(m.getThoiGian()));
					}catch (Exception   ex) {
						ex.printStackTrace();
						
					}
					dm.addRow(new String[] {m.getMaGD(), m.getMaATM(), time,soTien});
							
				}
			}
		
			
		}
	
	
	public void selectKH() {
		ArrayList<GiaoDich> arrKH1 =new ArrayList<>();
		int checkMaKH = 0;
		String maKH = txtnhapMA.getText();
		ArrayList<KhachHang> arrKH = new ArrayList<KhachHang>();
		arrKH = DatabaseKhachHang.selectKhachHang();
		for(KhachHang x : arrKH) {
			if(maKH.equals(x.getMaKH())) {
				checkMaKH = 1;
			}
		}
			
		arrKH1.clear();
			dm.setRowCount(0);
			arrKH1 = DatabaseReport_KH.selectKHTheoMa(maKH);
			if(checkMaKH ==0) {
				JOptionPane.showMessageDialog(null, "Mã khách Hàng Không tồn tại!!");
				}
			else if(arrKH1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Khách Hàng chưa có giao dịch nào!!");
			}else  {
				for (GiaoDich o : arrKH1) {
					DecimalFormat df = new DecimalFormat("###,###,###");
						
					String soTien = df.format(Integer.parseInt((o.getSoTien()))) + " VNĐ";
					
					SimpleDateFormat sdf =new SimpleDateFormat("HH:mm a ,EEEEE ,dd/MM/yyyy ",new Locale("vi", "VN"));
					SimpleDateFormat sdf2 =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
					
					String time = "";
					try {
						time = sdf.format(sdf2.parse(o.getThoiGian()));
					}catch (Exception   ex) {
						ex.printStackTrace();
						
					}
					dm.addRow(new String[] {o.getMaGD(), o.getMaATM(), time,soTien});
				}		
				}
				}	
	
	public void addEvents() {
		chucnangkhac.addActionListener(chucnangkhaccl);
		thoat.addActionListener(thoatcl);
		txtnhapMA.addActionListener(selectKH);
		btnShowThang.addActionListener(selectKHTheoThang);
		btnShowNam.addActionListener(selectKHTheoNam);
		show.addActionListener(showcl);
		nhaplai.addActionListener(resetClick);
	}
	public BC_RutTien_KhachHang(String title) {
		super(title);
		addControls();
		addEvents();
	}

	public void showWindow() {
		this.setSize(900, 600);
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

		pnBorder.add(pnNorth,BorderLayout.NORTH);
		JPanel pnSouth=new JPanel();
		pnSouth.setBackground(Color.blue);
		JLabel duoi = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		duoi.setForeground(Color.white);
		pnSouth.add(duoi);
		pnSouth.setPreferredSize(new Dimension(20, 30));
		pnBorder.add(pnSouth,BorderLayout.SOUTH);

		// phần trái màn hình
		JPanel pnWest = new JPanel();
		//pnWest.setPreferredSize(new Dimension(200, 50));
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

		// phần giữa
		JPanel pnCenter = new JPanel();
		//pnCenter.setBackground(Color.YELLOW);
		//pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCenter.setPreferredSize(new Dimension(200, 100));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.Y_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 300));
		
		JPanel pntren = new JPanel();
		pntren.setPreferredSize(new Dimension(100, 20));
		pnCentercon.add(pntren);
	
		JPanel pnborderMa = new JPanel();
		Border bd2 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder tblBorder1 = BorderFactory.createTitledBorder(bd2, "Chọn Khách Hàng", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
		pnborderMa.setBorder(tblBorder1);
			JPanel pnMaKH = new JPanel();
			JLabel lblMa = new JLabel("Nhập Mã KH:");
			txtnhapMA = new JTextField(20);
			txtnhapMA.setForeground(Color.BLUE);
			pnMaKH.add(lblMa);
			pnMaKH.add(txtnhapMA);
			pnborderMa.add(pnMaKH);
			pnCentercon.add(pnborderMa);
			
			JPanel pnTime = new JPanel();
			Border bd1 = BorderFactory.createLineBorder(Color.blue);
			TitledBorder tblBorder = BorderFactory.createTitledBorder(bd1, "Chọn Thời Gian", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION);
			pnTime.setBorder(tblBorder);
			
			//chọn thời gian để hiển thị
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
			
			//panel ngày tháng
			CardLayout clTime = new CardLayout();
			JPanel pnNhap = new JPanel(clTime);
			String[] thang = new String [] {"01","02","03","04","05","06","07","08","09","10","11","12"}; 
			String[] nam = new String [] {"2016","2017","2018","2019"}; 
			JPanel pnNamThang = new JPanel();
			JLabel lblthang = new JLabel("Tháng");
			cboThang = new JComboBox<>(thang);
			cboThang.setPreferredSize(new Dimension(60, 20));
			
			JLabel lblNam = new JLabel("Năm");
			cboNam = new JComboBox<>(nam);
			cboNam.setPreferredSize(new Dimension(60, 20));
			
			btnShowThang = new JButton("Hiển Thị");
			//btnShowThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
			btnHuyThang = new JButton("ReSet");
			//btnHuyThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
			pnNamThang.add(lblthang);
			pnNamThang.add(cboThang);
			pnNamThang.add(lblNam);
			pnNamThang.add(cboNam);
			pnNamThang.add(btnShowThang);
			pnNamThang.add(btnHuyThang);
			
			//pn khoảng thời gian
			JLabel timeStart = new JLabel("Từ ngày: ");
			dateStart  = new JDateChooser();
			dateStart.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			dateStart.setDateFormatString("dd-MM-yyyy");
			JTextFieldDateEditor started =  (JTextFieldDateEditor) dateStart.getDateEditor();
			started.setEditable(false);
			dateStart.setPreferredSize(new Dimension(100, 20));
			
			//ngày kết thúc
			JLabel timeEnd = new JLabel("Đến ngày: ");
			dateEnd  = new JDateChooser();
			dateEnd.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
			dateEnd.setDateFormatString("dd-MM-yyyy");
			JTextFieldDateEditor end =  (JTextFieldDateEditor) dateStart.getDateEditor();
			end.setEditable(false);
			dateEnd.setPreferredSize(new Dimension(100, 20));
			btnShowNam = new JButton("Hiển Thị");
			//btnShowThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
			btnHuyNam = new JButton("ReSet");
			//btnHuyThang.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));
			 JPanel pnKhoangThoiGian = new JPanel();
			 pnKhoangThoiGian.add(timeStart);
			 pnKhoangThoiGian.add(dateStart);
			 pnKhoangThoiGian.add(timeEnd);
			 pnKhoangThoiGian.add(dateEnd);
			 pnKhoangThoiGian.add(btnShowNam);
			 pnKhoangThoiGian.add(btnHuyNam);
			 
			
			 pnNhap.add(pnNamThang,"1");
			 pnNhap.add(pnKhoangThoiGian,"2");
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
			JPanel pnCenterRight = new JPanel();
			pnCenterRight.setPreferredSize(new Dimension(150, 50));
			pnCenterRight.setLayout(new BoxLayout(pnCenterRight, BoxLayout.Y_AXIS));

			pnCenter.add(pnCentercon);

		dm = new DefaultTableModel();
		
		dm.addColumn("Mã Giao dịch");
		dm.addColumn("Mã máy");
		dm.addColumn("Thời GIan");
		dm.addColumn("Tổng tiền");
		
		tbl = new JTable(dm);		
		JScrollPane sc = new JScrollPane(tbl);
		sc.setPreferredSize(new Dimension(650, 600));
		sc.setForeground(Color.BLUE);
		// add thông tin vào pncenter con
		pnCenter.add(sc);
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		con.add(pnBorder);
	}
	public void CloseFrame(){
	    super.dispose();
	}
}

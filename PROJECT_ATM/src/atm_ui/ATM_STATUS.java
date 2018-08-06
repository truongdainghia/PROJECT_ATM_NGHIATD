	
	
	
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
	
	public class ATM_STATUS extends JFrame {
	
		JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
		JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
		JButton show = new JButton("HIỂN THỊ");
		JButton nhaplai = new JButton("RESET");
		JButton all = new JButton("XEM TẤT CẢ");
	;
		JLabel kc1, kc2, kc3, kc4, kc5;
		JTextField txttrenPhai,txttrenphai3,txtmay,txtday;
		JComboBox setPhuong, setquan;
		DefaultTableModel dm ;
		JTable tbl;
		ActionListener chucnangkhaccl = new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
	
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
		
		
	
		public void addEvents() {
			// btnchange_pass.addActionListener(changePassClick);
			chucnangkhac.addActionListener(chucnangkhaccl);
			thoat.addActionListener(thoatcl);
			
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
	//		JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
	//		right.setForeground(Color.white);
	//		pnNorth.add(right);
			pnBorder.add(pnNorth,BorderLayout.NORTH);
			JPanel pnSouth=new JPanel();
			pnSouth.setBackground(Color.blue);
			JLabel duoi = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
			duoi.setForeground(Color.white);
			pnSouth.add(duoi);
			pnSouth.setPreferredSize(new Dimension(20, 30));
			pnBorder.add(pnSouth,BorderLayout.SOUTH);
			
	
			// phân footer
	//		JPanel pnSouth = new JPanel();
	//		//pnSouth.setBackground(Color.BLUE);
	//		pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));
	//		pnSouth.setPreferredSize(new Dimension(200, 300));
	//		
	//		pnBorder.add(pnSouth, BorderLayout.SOUTH);
	
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
	
			// phần bên phải
	//		JPanel pnEast = new JPanel();
	//
	//		pnEast.setBackground(Color.BLUE);
	//		pnBorder.add(pnEast, BorderLayout.EAST);
	
			// phần giữa
			JPanel pnCenter = new JPanel();
			//pnCenter.setBackground(Color.YELLOW);
			//pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
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
	//		JLabel lblTrenTrai = new JLabel("Chọn Thông tin");
	//		pntren.add(lblTrenTrai);
			// phần trên phải
			JPanel pntrenPhai = new JPanel();
			pntrenPhai.setLayout(new BoxLayout(pntrenPhai, BoxLayout.Y_AXIS));
			JPanel pntrenPhai1 = new JPanel();
	//		pntrenPhai1.setPreferredSize(new Dimension(100, 50));
			JLabel lblPhuong = new JLabel("CHỌN PHƯỜNG:  ");
			lblPhuong.setForeground(Color.BLUE);
			setPhuong = new JComboBox<String>();
			setPhuong.setPreferredSize(new Dimension(130, 30));
	
			setPhuong.addItem("Hòa An");
			setPhuong.addItem("Hòa Phát");
			setPhuong.addItem("Hòa Thọ Đông");
			setPhuong.addItem("Hòa Xuân");
			setPhuong.addItem("Hòa Cường Bắc");
			setPhuong.addItem("Hòa Cường Nam");
			setPhuong.addItem("Hòa Bắc");
			setPhuong.addItem("Hòa Châu");
			setPhuong.addItem("Hòa Khương");
			// setPhuong.addItem("Hòa Khương");
			// setPhuong.addItem("Hòa Khương");
			pntrenPhai1.add(lblPhuong);
			pntrenPhai1.add(setPhuong);
			pntrenPhai1.add(setPhuong);
			pntrenPhai.add(pntrenPhai1);
			
			// trên phải vị trí thứ 2
			JPanel pntrenPhai2 = new JPanel();
			//pntrenPhai2.setPreferredSize(new Dimension(130, 20));
			JLabel lblquan = new JLabel("CHỌN QUẬN:  ");
			lblquan.setForeground(Color.BLUE);
			setquan = new JComboBox<String>();
			setquan.setPreferredSize(new Dimension(130, 20));
	
			setquan.addItem("HOÀNG SA");
			setquan.addItem("CẨM LỆ");
			setquan.addItem("HÒA VANG");
			setquan.addItem("THANH KHÊ");
			setquan.addItem("SƠN TRÀ");
			setquan.addItem("NGŨ HÀNH SƠN");
			setquan.addItem("LIÊN CHIỂU");
			setquan.addItem("HẢI CHÂU");
			// setquan.addItem("HẢI CHÂU");
	
			pntrenPhai2.add(lblquan);
			pntrenPhai2.add(setquan);
			pntrenPhai.add(pntrenPhai2);
			
			JPanel pntrenPhai3 = new JPanel();
			JLabel lbltrenphai3 = new JLabel("Nhập Địa chỉ:");
			txttrenphai3 = new JTextField(15);
			lbltrenphai3.setForeground(Color.BLUE);
			pntrenPhai3.add(lbltrenphai3);
			pntrenPhai3.add(txttrenphai3);
			pntrenPhai.add(pntrenPhai3);
			
			JPanel pnTrenGiua = new JPanel();
			pnTrenGiua.setPreferredSize(new Dimension(100, 20));
			JLabel lbltrengiua = new JLabel("CHỌN THÔNG TIN:");
			JPanel pnTrenGiua1 = new JPanel();
			JLabel lbltrengiua1 = new JLabel("                                         ");
			pnTrenGiua1.add(lbltrengiua1);
			pnTrenGiua.add(pnTrenGiua1);
			
			pnTrenGiua.add(lbltrengiua);
			pntren.add(pnTrenGiua);
			
			pntren.add(pntrenPhai);
			pnCentercon.add(pntren);
	//		
	//		JPanel pngiua = new JPanel();
	//		JLabel lblgiua = new JLabel("                                                              ");
	//		pngiua.add(lblgiua);
	//		pntren.add(pngiua);
			
			// center dưới
			JPanel pnduoi = new JPanel();
			pnduoi.setLayout(new BoxLayout(pnduoi, BoxLayout.X_AXIS));
			JPanel pnduoitrai = new JPanel();
			JLabel lblmay = new JLabel("Chọn máy ATM");
			pnduoitrai.add(lblmay);
			txtmay =new JTextField(15);
			pnduoitrai.add(txtmay);
			pnduoi.add(pnduoitrai);
			
			JPanel pnduoiphai = new JPanel();
			pnduoiphai.add(all);
			pnduoi.add(pnduoiphai);
			pnCentercon.add(pnduoi);
		
			JPanel pnday = new JPanel();
			JLabel lblday = new JLabel("Tổng số tiền tất cả các máy là:");
			txtday = new JTextField(15);
			pnday.add(lblday);
			pnday.add(txtday);
			
			
				
				 // VỊ TRÍ
				 //add button
				 JPanel Actions = new JPanel();
				 Actions.setPreferredSize(new Dimension(200, 30));
				 JLabel kca1 =new JLabel("      ");
				 show.setForeground(Color.blue);
				 show.setBackground(Color.GREEN);
				 nhaplai.setForeground(Color.blue);
				 nhaplai.setBackground(Color.GREEN);
				 Actions.add(show);
				 Actions.add(kca1);
				 Actions.add(nhaplai);
				 pnCentercon.add(Actions);
				 pnCentercon.add(pnday);
	
	
			pnCenter.add(pnCentercon);
		
			dm = new DefaultTableModel();
			
			dm.addColumn("Tình trạng");
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
		public void CloseFrame(){
		    super.dispose();
		}
	}
	

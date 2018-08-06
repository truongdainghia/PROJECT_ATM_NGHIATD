



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

public class BC_Ruttien_ATM extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton show = new JButton("HIỂN THỊ");
	JButton nhaplai = new JButton("RESET");
	JButton all = new JButton("XEM TẤT CẢ");
;
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txttrenPhai,txttrenphai3,txtmay,txtday,txtdiachi,txtphai2,txtthang,txtchitiet1,txtchitiet2;
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

	public BC_Ruttien_ATM(String title) {
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
		pnCenter.setPreferredSize(new Dimension(200, 400));
		// center con
		JPanel pnCentercon = new JPanel();
		pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.Y_AXIS));
		pnCentercon.setPreferredSize(new Dimension(600, 280));
		
		//pn center tren
		JPanel pncenterTren = new JPanel();
		pncenterTren.setLayout(new BoxLayout(pncenterTren, BoxLayout.X_AXIS));
		pncenterTren.setPreferredSize(new Dimension(200, 150));
		
		JPanel pncenterTrenTrai = new JPanel();
		pncenterTrenTrai.setLayout(new BoxLayout(pncenterTrenTrai, BoxLayout.Y_AXIS));
		JPanel pncenterTrenTrai1 = new JPanel();
		JLabel lbltrentrai1 = new JLabel("                              ");
		pncenterTrenTrai1.add(lbltrentrai1);
		pncenterTrenTrai.add(pncenterTrenTrai1);
		
		JPanel pncenterTrenTrai2 = new JPanel();
		JLabel lbltrentrai2 = new JLabel(" CHỌN THÔNG TIN:");
		pncenterTrenTrai2.add(lbltrentrai2);
		pncenterTrenTrai.add(pncenterTrenTrai2);
		
		JPanel pntrenGiua = new JPanel();
		pntrenGiua.setLayout(new BoxLayout(pntrenGiua, BoxLayout.Y_AXIS));
		JPanel pntrengiua1 = new JPanel();
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

		pntrengiua1.add(lblquan);
		pntrengiua1.add(setquan);
		pntrenGiua.add(pntrengiua1);
		
		JPanel pntrengiua2 = new JPanel();
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
		pntrengiua2.add(lblPhuong);
		pntrengiua2.add(setPhuong);
		pntrenGiua.add(pntrengiua2);
		
		JPanel pntrengiua3 = new JPanel();
		JLabel lbldiachi = new JLabel("Nhập địa chỉ");
		txtdiachi = new JTextField(15);
		lbldiachi.setForeground(Color.BLUE);
		pntrengiua3.add(lbldiachi);
		pntrengiua3.add(txtdiachi);
		pntrenGiua.add(pntrengiua3);
		
		JPanel pncentertrenphai = new JPanel();
		pncentertrenphai.setLayout(new BoxLayout(pncentertrenphai, BoxLayout.Y_AXIS));
		JPanel pncentertrenphai1= new JPanel();
		JLabel lblphai1= new JLabel("                                     ");
		pncentertrenphai.add(pncentertrenphai1);
		
		JPanel pncentertrenphai2= new JPanel();
		JLabel lblphai2 = new JLabel("CHỌN MÁY ATM");
		txtphai2=  new JTextField(8);
		pncentertrenphai2.add(lblphai2);
		pncentertrenphai2.add(txtphai2);
		pncentertrenphai.add(pncentertrenphai2);
		
		pncenterTren.add(pncenterTrenTrai);
		pncenterTren.add(pntrenGiua);
		pncenterTren.add(pncentertrenphai);
		
		// pn dưới
		JPanel pngiua = new JPanel();
		JLabel lblthang = new JLabel("CHỌN THỜI GIAN");
		txtthang = new JTextField(8);
		pngiua.add(lblthang);
		pngiua.add(txtthang);
		
		JPanel day = new JPanel();
		day.setLayout(new BoxLayout(day, BoxLayout.X_AXIS));
		JPanel day1 = new JPanel();
		JLabel lblday1 = new JLabel("CHI TIẾT");
		txtchitiet1 = new JTextField(15);
		day1.add(lblday1);
		day1.add(txtchitiet1);
		day.add(day1);
		
		JPanel day2 = new JPanel();
		JLabel lblday2 = new JLabel("ĐẾN");
		
		day2.add(lblday2);
		
		day.add(day2);
		
		
		
		JPanel day3 = new JPanel();
		
		txtchitiet2 = new JTextField(15);
		
		day3.add(txtchitiet2);
		day.add(day3);
		
		
		pnCentercon.add(pncenterTren);
		pnCentercon.add(pngiua);
		pnCentercon.add(day);
		
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



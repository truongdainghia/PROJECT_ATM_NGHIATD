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

public class Transaction extends JFrame {

	JButton chucnangkhac = new JButton("CHỨC NĂNG KHÁC");
	JButton thoat = new JButton("HỦY BỎ GIAO DỊCH");
	JButton show = new JButton("HIỂN THỊ");
	JButton nhaplai = new JButton("RESET");
;
	JLabel kc1, kc2, kc3, kc4, kc5;
	JTextField txtMa, txtTen, txtPhuong, txtDiaChi, txtSDT, txtEmail, txtSothe, txtSTK_NH, txtPhone, txtSoDu, txtMaPin;
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
		tbl.addMouseListener(tblUserClick);

		// tbl.addMouseListener(tblUserClick);
	}

	public Transaction(String title) {
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
		JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		right.setForeground(Color.white);
		pnNorth.add(right);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		

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
		pnCentercon.setPreferredSize(new Dimension(600, 200));
	
		
		
		JPanel pntren = new JPanel();
		pntren.setPreferredSize(new Dimension(100, 100));
		pnCentercon.add(pntren);
		
		 JPanel pnPhuong = new JPanel();
			pnPhuong.setPreferredSize(new Dimension(100, 50));
			JLabel lblPhuong = new JLabel("CHỌN MÁY ATM:  ");
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
			pnPhuong.add(lblPhuong);
			pnPhuong.add(setPhuong);
			 pnPhuong.add(setPhuong);
			 pnCentercon.add(pnPhuong);
			 
			 // VỊ TRÍ
			 //add button
			 JPanel Actions = new JPanel();
			 Actions.setPreferredSize(new Dimension(200, 50));
			 JLabel kca1 =new JLabel("      ");
			 show.setForeground(Color.blue);
			 show.setBackground(Color.GREEN);
			 nhaplai.setForeground(Color.blue);
			 nhaplai.setBackground(Color.GREEN);
			 Actions.add(show);
			 Actions.add(kca1);
			 Actions.add(nhaplai);
			 pnCentercon.add(Actions);

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
		
		
		

		//JPanel pnActions =new JPanel();
		dm = new DefaultTableModel();
		
		dm.addColumn("Mã máy");
		
		dm.addColumn("Mã Giao dịch");	
		dm.addColumn("Số thẻ");
		dm.addColumn("Thời gian");
		dm.addColumn("Số tiền");
		
		
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

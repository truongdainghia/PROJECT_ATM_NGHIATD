package atm_ui;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Report extends JFrame {
	JButton tien1 = new JButton("BÁO CÁO KHÁCH HÀNG");
	JButton tien2 = new JButton("BÁO CÁO RÚT TIỀN KHÁCH HÀNG");
	JButton tien3 = new JButton("CHỨC NĂNG KHÁC");

	JButton tien4 = new JButton("BÁO CÁO TÌNH TRẠNG ATM");
	JButton tien5 = new JButton("BÁO CÁO RÚT TIỀN CÁC MÁY");
	JButton sokhac = new JButton("THOÁT");
	
	JTextField txtnhap ,txtnhaptien;
	private Border raisedBevel = BorderFactory.createRaisedBevelBorder();
	private Border raisedEtched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
	ActionListener tien1Click = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};

	ActionListener tien2Click = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener tien3Click = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener gdKhacClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener tien4Click = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener tien5Click = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener sokhacClick = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}
	};
	ActionListener cancelClick = new ActionListener() {

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
		tien1.addActionListener(tien1Click);
		tien2.addActionListener(tien2Click);
		tien3.addActionListener(tien3Click);
	
		tien4.addActionListener(tien4Click);
		tien5.addActionListener(tien5Click);
		sokhac.addActionListener(sokhacClick);
		
	}

	public Report(String title) {
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

		JPanel pnNorth = new JPanel();
		pnNorth.setPreferredSize(new Dimension(200, 70));
		// pnNorth.setBackground(Color.RED);
		pnBorder.add(pnNorth, BorderLayout.NORTH);
	

		// phân footer
		JPanel pnSouth = new JPanel();
		pnSouth.setBackground(Color.BLUE);
		JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		right.setForeground(Color.red);
		pnSouth.add(right);
		pnBorder.add(pnSouth, BorderLayout.SOUTH);

		// phần trài màn hình
		JPanel pnWest = new JPanel();
		pnWest.setBackground(Color.BLUE);
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		// pnWest.setPreferredSize(new Dimension(200, 50));

		JPanel pnWest0 = new JPanel();
		tien1.setPreferredSize(new Dimension(200, 60));
		// btnchange_pass.setMargin(new Insets(5, 5, 5, 5));
		pnWest0.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		pnWest0.setBounds(10, 10, 10, 10);
		pnWest0.add(tien1);
		tien1.setForeground(Color.blue);
		tien2.setForeground(Color.blue);
		tien3.setForeground(Color.blue);
		tien4.setForeground(Color.blue);
		tien5.setForeground(Color.blue);
		
		sokhac.setForeground(Color.blue);
	
		tien1.setBackground(Color.GREEN);
		tien2.setBackground(Color.GREEN);
		tien3.setBackground(Color.GREEN);
		tien4.setBackground(Color.GREEN);
		tien5.setBackground(Color.GREEN);
		sokhac.setBackground(Color.GREEN);
	
		
		pnWest.add(pnWest0);

		JPanel pnWest1 = new JPanel();

		tien2.setPreferredSize(new Dimension(200, 60));
		pnWest1.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		// pnWest1.setMargin(new Insets(2, 2, 2, 2));
		pnWest1.setBounds(10, 10, 10, 10);
		pnWest1.add(tien2);
		pnWest.add(pnWest1);

		JPanel pnWest2 = new JPanel();
		tien3.setPreferredSize(new Dimension(200, 60));
		// different.setMargin(new Insets(5, 5, 5, 5));
		pnWest2.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		pnWest2.add(tien3);
		pnWest.add(pnWest2);

		JPanel pnWest3 = new JPanel();
	
		// cancel.setMargin(new Insets(5, 5, 5, 5));
		pnWest3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		pnWest.add(pnWest3);

		pnBorder.add(pnWest, BorderLayout.WEST);

		// pnWest.add(btn_info);
		// pnWest.add(different);
		// pnWest.add(cancel);

		// phần bên phải màn hình
		JPanel pnEast = new JPanel();
		pnEast.setBackground(Color.BLUE);
		// pnEast.setBackground(Color.BLUE);
		pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));
		JPanel pnEast1 = new JPanel();
		tien4.setPreferredSize(new Dimension(200, 60));
		// btnchange_pass.setMargin(new Insets(5, 5, 5, 5));
		pnEast1.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
		// sodu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEast1.setBounds(10, 10, 10, 10);
		pnEast1.add(tien4);
		pnEast.add(pnEast1);

		JPanel pnEast2 = new JPanel();

		tien5.setPreferredSize(new Dimension(200, 60));
		pnEast2.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
		// ruttien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		// pnWest1.setMargin(new Insets(2, 2, 2, 2));
		pnEast2.setBounds(10, 10, 10, 10);
		pnEast2.add(tien5);
		pnEast.add(pnEast2);

		JPanel pnEast3 = new JPanel();
		sokhac.setPreferredSize(new Dimension(200, 60));
		// different.setMargin(new Insets(5, 5, 5, 5));
		pnEast3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
		// naptien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEast3.add(sokhac);
		pnEast.add(pnEast3);

		JPanel pnEast4 = new JPanel();
		
		// cancel.setMargin(new Insets(5, 5, 5, 5));
		pnEast4.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 5));
		// chuyenkhoan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1,
		// Color.black));
		
		pnEast.add(pnEast4);
		//
		pnBorder.add(pnEast, BorderLayout.EAST);

		// phần trung tâm màn hình
		JPanel pnCenter = new JPanel();
		//pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		// pnCenter.setPreferredSize(new Dimension(200, 400));
		// pnCenter.setBackground(Color.YELLOW);
		Border border1 = BorderFactory.createLineBorder(Color.BLUE);
		//TitledBorder ttbd = BorderFactory.createTitledBorder(border1, "RÚT TIỀN");
		//pnCenter.setBorder(ttbd);

		// center con
		JPanel pnCentercon = new JPanel();
		// pnCentercon.setLayout(new BoxLayout(pnCentercon, BoxLayout.Y_AXIS));
		pnCentercon.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		pnCentercon.setPreferredSize(new Dimension(400, 200));
		//pnCentercon.setBackground(Color.CYAN);
		JPanel ruttien1 = new JPanel();
		JLabel lblruttien1 = new JLabel("XIN CHÀO ADMIN");
		Font fontsize11=new Font("Arial", Font.BOLD,15);
		lblruttien1.setFont(fontsize11);
		ruttien1.add(lblruttien1);

		
		
		
		
	
		
		JPanel nhaptien = new JPanel();
		
		txtnhaptien = new JTextField(20);
		nhaptien.add(txtnhaptien);
		

		

		
		
		
		
	    pnCentercon.add(ruttien1);
		pnCenter.add(pnCentercon);
		
		pnBorder.add(pnCenter, BorderLayout.CENTER);

		con.add(pnBorder);
	}
	public void CloseFrame(){
	    super.dispose();
	}
}

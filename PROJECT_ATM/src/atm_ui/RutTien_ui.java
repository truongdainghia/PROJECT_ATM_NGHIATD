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
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
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
import javax.swing.table.DefaultTableModel;
public class RutTien_ui extends JFrame {
	JButton btnchange_pass = new JButton("ĐỔI MẬT KHẨU"); 
	JButton btn_info = new JButton("TRA CỨU THÔNG TIN"); 
	JButton different = new JButton("GIAO DỊCH KHÁC");
	JButton cancel = new JButton("HỦY BỎ GIAO DỊCH");
	JButton sodu = new JButton("SỐ DƯ");
	JButton ruttien = new JButton("RÚT TIỀN");
	JButton naptien = new JButton("NẠP TIỀN");
	JButton chuyenkhoan = new JButton("CHUYỂN KHOẢN");
	
ActionListener changePassClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			 
			
	
		}
	};
	
	ActionListener infoClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
	ActionListener differentClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
	ActionListener cancelClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dangnhapkh_ui login = new dangnhapkh_ui("HỆ THỐNG ĐĂNG NHẬP KHÁCH HÀNG");
				login.showWindow();
				CloseFrame();
		}
	};
	ActionListener soduClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
	ActionListener ruttienClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
ActionListener naptienClick = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
		}
	};
ActionListener chuyenkhoanClick = new ActionListener() {
		
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
	public void addEvents()
	{
		//btnchange_pass.addActionListener(changePassClick);
		btn_info.addActionListener(infoClick);
		different.addActionListener(differentClick);
		cancel.addActionListener(cancelClick);
		sodu.addActionListener(soduClick);
		ruttien.addActionListener(ruttienClick);
		naptien.addActionListener(naptienClick);
		chuyenkhoan.addActionListener(chuyenkhoanClick);
		
		//tbl.addMouseListener(tblUserClick);
	}
	
	public RutTien_ui(String title) {
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
		
		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		//pnNorth.setBackground(Color.RED);
		
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		
		
		JPanel pnSouth=new JPanel();
		pnSouth.setBackground(Color.BLUE);
		JLabel right = new JLabel("@ 2003 - 2007 ĐÔNG Á,Bank, All right reserved");
		right.setForeground(Color.red);
		pnSouth.add(right);
		pnBorder.add(pnSouth,BorderLayout.SOUTH);
		
		JPanel pnWest=new JPanel();
		pnWest.setBackground(Color.BLUE);
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		//pnWest.setPreferredSize(new Dimension(200, 50));
		
		JPanel pnWest0=new JPanel();
		btnchange_pass.setPreferredSize(new Dimension(200, 50));
		//btnchange_pass.setMargin(new Insets(5, 5, 5, 5));
		pnWest0.setBorder(BorderFactory.createEmptyBorder(40, 10, 10, 10));
		pnWest0.setBounds(10, 10,10,10);
		pnWest0.add(btnchange_pass);
		pnWest.add(pnWest0);
		
		JPanel pnWest1=new JPanel();
		
		btn_info.setPreferredSize(new Dimension(200, 50));
		pnWest1.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		//pnWest1.setMargin(new Insets(2, 2, 2, 2));
		pnWest1.setBounds(10, 10,10,10);
		pnWest1.add(btn_info);
		pnWest.add(pnWest1);
		
		JPanel pnWest2=new JPanel();
		different.setPreferredSize(new Dimension(200, 50));
		//different.setMargin(new Insets(5, 5, 5, 5));
		pnWest2.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		pnWest2.add(different);
		pnWest.add(pnWest2);
		
		JPanel pnWest3=new JPanel();
		cancel.setPreferredSize(new Dimension(200, 50));
		//cancel.setMargin(new Insets(5, 5, 5, 5));
		pnWest3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		pnWest3.add(cancel);
		pnWest.add(pnWest3);
		
		
		
		
		
		pnBorder.add(pnWest,BorderLayout.WEST);
		
		
	
		
//		pnWest.add(btn_info);
//		pnWest.add(different);
//		pnWest.add(cancel);
		
		JPanel pnEast=new JPanel();
		//pnEast.setBackground(Color.BLUE);
		pnEast.setLayout(new BoxLayout(pnEast, BoxLayout.Y_AXIS));
		JPanel pnEast1=new JPanel();
		sodu.setPreferredSize(new Dimension(200, 50));
		//btnchange_pass.setMargin(new Insets(5, 5, 5, 5));
		pnEast1.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));
//		sodu.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEast1.setBounds(10, 10,10,10);
		pnEast1.add(sodu);
		pnEast.add(pnEast1);
		
		JPanel pnEast2=new JPanel();
		
		ruttien.setPreferredSize(new Dimension(200, 50));
		pnEast2.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		//ruttien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		//pnWest1.setMargin(new Insets(2, 2, 2, 2));
		pnEast2.setBounds(10, 10,10,10);
		pnEast2.add(ruttien);
		pnEast.add(pnEast2);
		
		JPanel pnEast3=new JPanel();
		naptien.setPreferredSize(new Dimension(200, 50));
		//different.setMargin(new Insets(5, 5, 5, 5));
		pnEast3.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		//naptien.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEast3.add(naptien);
		pnEast.add(pnEast3);
		
		JPanel pnEast4=new JPanel();
		chuyenkhoan.setPreferredSize(new Dimension(200, 50));
		//cancel.setMargin(new Insets(5, 5, 5, 5));
		pnEast4.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		//chuyenkhoan.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black));
		pnEast4.add(chuyenkhoan);
		pnEast.add(pnEast4);
//		pnEast.add(sodu);
//		pnEast.add(ruttien);
//		pnEast.add(naptien);
//		pnEast.add(chuyenkhoan);
		pnBorder.add(pnEast,BorderLayout.EAST);
		
		JPanel pnCenter=new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		//pnCenter.setBackground(Color.YELLOW);
		JPanel pnhello = new JPanel();
		pnhello.setLayout(new BoxLayout(pnhello, BoxLayout.Y_AXIS));
		pnhello.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		JLabel hello = new JLabel("XIN CHÀO QUÝ VỊ ");
		JLabel hello1 = new JLabel("VUI LÒNG CHỌN LOẠI GIAO DỊCH");
		
		pnhello.add(hello);
		pnhello.add(hello1);
		
//		JPanel pnhello1 = new JPanel();
		
		pnCenter.add(pnhello);
//		pnCenter.add(pnhello1);
		
		
		
		pnBorder.add(pnCenter,BorderLayout.CENTER);
		pnBorder.setForeground(Color.BLUE);
		con.add(pnBorder);

	}
	public void CloseFrame(){
	    super.dispose();
	}
	
}

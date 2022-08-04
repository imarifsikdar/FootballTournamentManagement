package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame {
	
	private Container c;
	private ImageIcon logo,icon;
	private JLabel logoLbl, lbl1, lbl2, lbl3, lbl4, lbl5, lbl6,lbl7;
	private JButton btnLogAd, btnLogUser, btnReg;
	private Font fnt1,fnt2,fnt3,fnt4;
	private Cursor cursor;
	
	Home(){
		initComponents();
	}
	
	private void initComponents() {
		
		this.setDefaultCloseOperation(3);
		this.setTitle("Football Tournament Management");
		this.setBounds(300,50,375,600);
		this.setLayout(null);
		this.setResizable(false);
		
		icon = new ImageIcon(getClass().getResource("logoBlack.png"));
		this.setIconImage(icon.getImage());
		
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.BLACK);
		
		fnt1 = new Font("Montserrat",Font.BOLD,20);
		fnt2 = new Font("Montserrat",Font.PLAIN,13);
		fnt3 = new Font("Montserrat",Font.BOLD,16);
		fnt4 = new Font("Montserrat",Font.PLAIN,11);
		
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoLbl = new JLabel(logo);
		logoLbl.setBounds(140,0,92,50);
		c.add(logoLbl);
		
		lbl1 = new JLabel("WELCOME!");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBounds(128,98,118,24);
		lbl1.setFont(fnt1);
		c.add(lbl1);
		
		lbl2 = new JLabel("FTM Makes it easier to manage the");
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(63,141,249,17);
		lbl2.setFont(fnt2);
		c.add(lbl2);
		
		lbl6 = new JLabel("Football tournament!");
		lbl6.setForeground(Color.WHITE);
		lbl6.setBounds(111,159,152,17);
		lbl6.setFont(fnt2);
		c.add(lbl6);
		
		lbl3 = new JLabel("Login as an Administrator");
		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(95,213,184,17);
		lbl3.setFont(fnt2);
		c.add(lbl3);
		
		btnLogAd = new JButton("Login");
		btnLogAd.setBounds(104,239,166,31);
		btnLogAd.setFocusPainted(false);
		btnLogAd.setCursor(cursor);
		btnLogAd.setFont(fnt3);
		btnLogAd.setBackground(Color.WHITE);
		c.add(btnLogAd);
		
		lbl4 = new JLabel("Login as an User");
		lbl4.setForeground(Color.WHITE);
		lbl4.setBounds(128,313,118,17);
		lbl4.setFont(fnt2);
		c.add(lbl4);
		
		btnLogUser = new JButton("Login");
		btnLogUser.setBounds(104,339,166,31);
		btnLogUser.setFocusPainted(false);
		btnLogUser.setCursor(cursor);
		btnLogUser.setFont(fnt3);
		btnLogUser.setBackground(Color.WHITE);
		c.add(btnLogUser);
		
		lbl5 = new JLabel("New to FTM! Register Here.");
		lbl5.setForeground(Color.WHITE);
		lbl5.setBounds(91,413,193,17);
		lbl5.setFont(fnt2);
		c.add(lbl5);
		
		btnReg = new JButton("Sign Up");
		btnReg.setBounds(104,439,166,31);
		btnReg.setFocusPainted(false);
		btnReg.setCursor(cursor);
		btnReg.setFont(fnt3);
		btnReg.setBackground(Color.WHITE);
		c.add(btnReg);
		
		
		lbl7 = new JLabel("© 2022 Mohammed Arif Mazeed Sikdar. All Rights Reserved.");
		lbl7.setForeground(Color.WHITE);
		lbl7.setBounds(9,540,355,15);
		lbl7.setFont(fnt4);
		c.add(lbl7);
		
		btnLogAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogIn newFrame = new AdminLogIn();
				dispose();
				newFrame.setVisible(true);
			}
		});
		
		btnLogUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogIn newFrame = new UserLogIn();
				dispose();
				newFrame.setVisible(true);
			}
		});
		
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserReg newFrame = new UserReg();
				dispose();
				newFrame.setVisible(true);
			}
		});
		
	}

	public static void main(String[] args) {
		
		Home f = new Home();
		f.setVisible(true);

	}

}

package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppHome extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	private JButton btnTour;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	
	AppHome(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Welcome to FTM");
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
		
		cursor = new Cursor(Cursor.HAND_CURSOR);
		
		logo = new ImageIcon(getClass().getResource("logo.png"));
		logoLbl = new JLabel(logo);
		logoLbl.setBounds(140,0,92,50);
		c.add(logoLbl);
		
		lbl1 = new JLabel("TOURNAMENT");
		lbl1.setBounds(13,78,105,17);
		lbl1.setFont(fnt2);
		lbl1.setForeground(Color.GRAY);
		lbl1.setCursor(cursor);
		c.add(lbl1);
		
		lbl2 = new JLabel("TEAM REGISTRATION");
		lbl2.setBounds(133,78,152,17);
		lbl2.setFont(fnt2);
		lbl2.setForeground(Color.GRAY);
		lbl2.setCursor(cursor);
		c.add(lbl2);
		
		lbl7 = new JLabel("TEAMS");
		lbl7.setBounds(300,78,51,17);
		lbl7.setFont(fnt2);
		lbl7.setForeground(Color.GRAY);
		lbl7.setCursor(cursor);
		c.add(lbl7);
		
		lbl3 = new JLabel("Welcome To Football");
		lbl3.setBounds(73,216,225,24);
		lbl3.setFont(fnt1);
		lbl3.setForeground(Color.WHITE);
		c.add(lbl3);
		
		lbl4 = new JLabel("Tournament Management!");
		lbl4.setBounds(42,240,286,24);
		lbl4.setFont(fnt1);
		lbl4.setForeground(Color.WHITE);
		c.add(lbl4);
		
		lbl5 = new JLabel("Want to Participate in a Football Tournament?");
		lbl5.setBounds(15,312,330,17);
		lbl5.setFont(fnt2);
		lbl5.setForeground(Color.WHITE);
		c.add(lbl5);
		
		lbl6 = new JLabel("See Running Tournaments.");
		lbl6.setBounds(85,333,200,17);
		lbl6.setFont(fnt2);
		lbl6.setForeground(Color.WHITE);
		c.add(lbl6);
		
		btnTour = new JButton("Tournament");
		btnTour.setBounds(97,390,166,31);
		btnTour.setFocusPainted(false);
		btnTour.setCursor(cursor);
		btnTour.setFont(fnt3);
		btnTour.setBackground(Color.WHITE);
		c.add(btnTour);
		
		btnTour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tournament newFrame = new Tournament();
				dispose();
				newFrame.setVisible(true);
			}
		});
		
		lbl1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				Tournament newFrame1 = new Tournament();
				dispose();
				newFrame1.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		lbl2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				TeamReg newFrame2 = new TeamReg();
				dispose();
				newFrame2.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
		lbl7.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				TeamList newFrame3 = new TeamList();
				dispose();
				newFrame3.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		});
		
	}

	public static void main(String[] args) {
		AppHome f = new AppHome();
		f.setVisible(true);

	}

}

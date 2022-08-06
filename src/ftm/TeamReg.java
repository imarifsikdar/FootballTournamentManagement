package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Map;


import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TeamReg extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10,lbl11,lbl12,lbl13,lbl14,lbl15,lbl16;
	private JTextField tfTName,tfP1,tfP2,tfP3,tfP4,tfP5,tfP6,tfP7,tfP8,tfP9,tfP10,tfP11;
	private JButton btnReg;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	
	TeamReg(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Team Registration");
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
		
		lbl1 = new JLabel("HOME");
		lbl1.setBounds(13,78,105,17);
		lbl1.setFont(fnt2);
		lbl1.setForeground(Color.GRAY);
		lbl1.setCursor(cursor);
		c.add(lbl1);
		
		lbl2 = new JLabel("TOURNAMENT");
		lbl2.setBounds(133,78,152,17);
		lbl2.setFont(fnt2);
		lbl2.setForeground(Color.GRAY);
		lbl2.setCursor(cursor);
		c.add(lbl2);
		
		lbl3 = new JLabel("TEAMS");
		lbl3.setBounds(300,78,51,17);
		lbl3.setFont(fnt2);
		lbl3.setForeground(Color.GRAY);
		lbl3.setCursor(cursor);
		c.add(lbl3);

		lbl4 = new JLabel("Team Registration");
		lbl4.setForeground(Color.WHITE);
		lbl4.setBounds(87,112,195,24);
		lbl4.setFont(fnt1);
		c.add(lbl4);
		
		lbl5 = new JLabel("Team Name: ");
		lbl5.setForeground(Color.WHITE);
		lbl5.setBounds(34,156,90,17);
		lbl5.setFont(fnt2);
		c.add(lbl5);
		
		tfTName = new JTextField();
		tfTName.setBounds(129,156,200,17);
		tfTName.setForeground(Color.WHITE);
		tfTName.setFont(fnt2);
		tfTName.setBackground(Color.BLACK);
		tfTName.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfTName);
		
		lbl6 = new JLabel("Player 1: ");
		lbl6.setForeground(Color.WHITE);
		lbl6.setBounds(34,185,60,17);
		lbl6.setFont(fnt2);
		c.add(lbl6);
		
		tfP1 = new JTextField();
		tfP1.setBounds(99,185,230,17);
		tfP1.setForeground(Color.WHITE);
		tfP1.setFont(fnt2);
		tfP1.setBackground(Color.BLACK);
		tfP1.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP1);
		
		lbl7 = new JLabel("Player 2: ");
		lbl7.setForeground(Color.WHITE);
		lbl7.setBounds(34,214,64,17);
		lbl7.setFont(fnt2);
		c.add(lbl7);
		
		tfP2 = new JTextField();
		tfP2.setBounds(99,214,230,17);
		tfP2.setForeground(Color.WHITE);
		tfP2.setFont(fnt2);
		tfP2.setBackground(Color.BLACK);
		tfP2.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP2);
		
		lbl8 = new JLabel("Player 3: ");
		lbl8.setForeground(Color.WHITE);
		lbl8.setBounds(34,243,64,17);
		lbl8.setFont(fnt2);
		c.add(lbl8);
		
		tfP3 = new JTextField();
		tfP3.setBounds(99,243,230,17);
		tfP3.setForeground(Color.WHITE);
		tfP3.setFont(fnt2);
		tfP3.setBackground(Color.BLACK);
		tfP3.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP3);
		
		lbl9 = new JLabel("Player 4: ");
		lbl9.setForeground(Color.WHITE);
		lbl9.setBounds(34,272,64,17);
		lbl9.setFont(fnt2);
		c.add(lbl9);
		
		tfP4 = new JTextField();
		tfP4.setBounds(99,272,230,17);
		tfP4.setForeground(Color.WHITE);
		tfP4.setFont(fnt2);
		tfP4.setBackground(Color.BLACK);
		tfP4.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP4);
		
		lbl10 = new JLabel("Player 5: ");
		lbl10.setForeground(Color.WHITE);
		lbl10.setBounds(34,301,64,17);
		lbl10.setFont(fnt2);
		c.add(lbl10);
		
		tfP5 = new JTextField();
		tfP5.setBounds(99,301,230,17);
		tfP5.setForeground(Color.WHITE);
		tfP5.setFont(fnt2);
		tfP5.setBackground(Color.BLACK);
		tfP5.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP5);
		
		lbl11 = new JLabel("Player 6: ");
		lbl11.setForeground(Color.WHITE);
		lbl11.setBounds(34,330,64,17);
		lbl11.setFont(fnt2);
		c.add(lbl11);
		
		tfP6 = new JTextField();
		tfP6.setBounds(99,330,230,17);
		tfP6.setForeground(Color.WHITE);
		tfP6.setFont(fnt2);
		tfP6.setBackground(Color.BLACK);
		tfP6.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP6);
		
		lbl12 = new JLabel("Player 7: ");
		lbl12.setForeground(Color.WHITE);
		lbl12.setBounds(34,359,64,17);
		lbl12.setFont(fnt2);
		c.add(lbl12);
		
		tfP7 = new JTextField();
		tfP7.setBounds(99,359,230,17);
		tfP7.setForeground(Color.WHITE);
		tfP7.setFont(fnt2);
		tfP7.setBackground(Color.BLACK);
		tfP7.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP7);
		
		lbl13 = new JLabel("Player 8: ");
		lbl13.setForeground(Color.WHITE);
		lbl13.setBounds(34,382,64,17);
		lbl13.setFont(fnt2);
		c.add(lbl13);
		
		tfP8 = new JTextField();
		tfP8.setBounds(99,382,230,17);
		tfP8.setForeground(Color.WHITE);
		tfP8.setFont(fnt2);
		tfP8.setBackground(Color.BLACK);
		tfP8.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP8);
		
		lbl14 = new JLabel("Player 9: ");
		lbl14.setForeground(Color.WHITE);
		lbl14.setBounds(34,407,64,17);
		lbl14.setFont(fnt2);
		c.add(lbl14);
		
		tfP9 = new JTextField();
		tfP9.setBounds(99,407,230,17);
		tfP9.setForeground(Color.WHITE);
		tfP9.setFont(fnt2);
		tfP9.setBackground(Color.BLACK);
		tfP9.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP9);
		
		lbl15 = new JLabel("Player 10: ");
		lbl15.setForeground(Color.WHITE);
		lbl15.setBounds(34,436,70,17);
		lbl15.setFont(fnt2);
		c.add(lbl15);
		
		tfP10 = new JTextField();
		tfP10.setBounds(105,436,224,17);
		tfP10.setForeground(Color.WHITE);
		tfP10.setFont(fnt2);
		tfP10.setBackground(Color.BLACK);
		tfP10.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP10);
		
		lbl16 = new JLabel("Player 11: ");
		lbl16.setForeground(Color.WHITE);
		lbl16.setBounds(34,465,70,17);
		lbl16.setFont(fnt2);
		c.add(lbl16);
		
		tfP11 = new JTextField();
		tfP11.setBounds(105,465,224,17);
		tfP11.setForeground(Color.WHITE);
		tfP11.setFont(fnt2);
		tfP11.setBackground(Color.BLACK);
		tfP11.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfP11);
		
		btnReg = new JButton("Sign Up");
		btnReg.setBounds(104,505,166,31);
		btnReg.setFocusPainted(false);
		btnReg.setCursor(cursor);
		btnReg.setFont(fnt3);
		btnReg.setBackground(Color.WHITE);
		c.add(btnReg);
		
		
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfTName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your Team Name!");
				}
				
				else if(tfP1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 1 Name!");
				}
				
				else if(tfP2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 2 Name!");
				}
				else if(tfP3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 3 Name!");
				}
				else if(tfP4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 4 Name!");
				}
				
				else if(tfP5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 5 Name!");
				}
				else if(tfP6.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 6 Name!");
				}
				else if(tfP7.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 7 Name!");
				}
				else if(tfP8.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 8 Name!");
				}
				else if(tfP9.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 9 Name!");
				}
				
				else if(tfP10.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 10 Name!");
				}
				else if(tfP11.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Player 11 Name!");
				}
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftm","root", "");
						
						String query = "INSERT INTO `teaminfo`(`TeamName`, `P1`, `P2`, `P3`, `P4`, `P5`, `P6`, `P7`, `P8`, `P9`, `P10`, `P11`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
						
						PreparedStatement ps = cn.prepareStatement(query);
						ps.setString(1 , tfTName.getText());
                        ps.setString(2, tfP1.getText());
                        ps.setString(3, tfP2.getText());
                        ps.setString(4, tfP3.getText());
                        ps.setString(5, tfP4.getText());
                        ps.setString(6, tfP5.getText());
                        ps.setString(7, tfP6.getText());
                        ps.setString(8, tfP7.getText());
                        ps.setString(9, tfP8.getText());
                        ps.setString(10, tfP9.getText());
                        ps.setString(11, tfP10.getText());
                        ps.setString(12, tfP11.getText());
                        
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "You have Successfully Registered your Team");
                        ps.close();
                        cn.close();
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		lbl1.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				AppHome newFrame1 = new AppHome();
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
		
		lbl3.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				TeamList newFrame1 = new TeamList();
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
	}

	public static void main(String[] args) {
		TeamReg f = new TeamReg();
		f.setVisible(true);

	}

}

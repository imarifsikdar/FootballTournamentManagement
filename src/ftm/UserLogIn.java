package ftm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent; 
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UserLogIn extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	private JTextField tf;
	private JPasswordField pf;
	private JButton btnUserLog;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	
	UserLogIn(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Login");
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
		
		lbl1 = new JLabel("Login Account");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBounds(110,159,160,24);
		lbl1.setFont(fnt1);
		c.add(lbl1);
		
		lbl2 = new JLabel("Username: ");
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(34,239,80,17);
		lbl2.setFont(fnt2);
		c.add(lbl2);
		
		tf = new JTextField();
		tf.setBounds(120,239,221,17);
		tf.setForeground(Color.WHITE);
		tf.setFont(fnt2);
		tf.setBackground(Color.BLACK);
		tf.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tf);
		
		lbl3 = new JLabel("Password: ");
		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(34,299,75,17);
		lbl3.setFont(fnt2);
		c.add(lbl3);
		
		pf = new JPasswordField();
		pf.setBounds(120,299,221,17);
		pf.setForeground(Color.WHITE);
		pf.setFont(fnt2);
		pf.setBackground(Color.BLACK);
		pf.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(pf);
		
		btnUserLog = new JButton("Login");
		btnUserLog.setBounds(104,366,166,31);
		btnUserLog.setFocusPainted(false);
		btnUserLog.setCursor(cursor);
		btnUserLog.setFont(fnt3);
		btnUserLog.setBackground(Color.WHITE);
		c.add(btnUserLog);
		
		lbl4 = new JLabel("Forgot Password?");
		lbl4.setBounds(127,428,128,17);
		lbl4.setForeground(Color.WHITE);
		lbl4.setFont(fnt2);
		lbl4.setCursor(cursor);
		Font lbl4Fnt = lbl4.getFont();
		Map attributes = lbl4Fnt.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbl4.setFont(lbl4Fnt.deriveFont(attributes));
		c.add(lbl4);
		
		lbl5 = new JLabel("Didn't Sign Up?");
		lbl5.setBounds(80,466,110,17);
		lbl5.setForeground(Color.WHITE);
		lbl5.setFont(fnt2);
		c.add(lbl5);
		
		lbl6 = new JLabel("Register Here");
		lbl6.setBounds(190,466,128,17);
		lbl6.setForeground(Color.WHITE);
		lbl6.setFont(fnt2);
		lbl6.setCursor(cursor);
		Font lbl6Fnt = lbl6.getFont();
		Map attributes1 = lbl6Fnt.getAttributes();
		attributes1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbl6.setFont(lbl6Fnt.deriveFont(attributes1));
		c.add(lbl6);
		
		
		btnUserLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your email!");
				}
				else if(pf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your password!");
				}
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftm","root", "");
						
						String userName = tf.getText();
						String pass = pf.getText();
						
						Statement stn = cn.createStatement();
						
						String sql = "select * from userinfo where UserName='"+userName+"'and Password='"+pass+"'";
						
						ResultSet rs = stn.executeQuery(sql);
						if(rs.next()) {
							AppHome newFrame = new AppHome();
							dispose();
							newFrame.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "Wrong email or password!");
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		lbl4.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				ForgotPass newFrame1 = new ForgotPass();
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
		
		lbl6.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				ForgotPass newFrame1 = new ForgotPass();
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
		UserLogIn f = new UserLogIn();
		f.setVisible(true);

	}

}

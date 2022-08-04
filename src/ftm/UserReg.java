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

public class UserReg extends JFrame {
	
	private Container c;
	private JLabel logoLbl,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
	private JTextField tfUName,tfEmail,tfName;
	private JPasswordField pf;
	private JButton btnSignUP;
	private ImageIcon logo, icon;
	private Font fnt1,fnt2,fnt3;
	private Cursor cursor;
	
	UserReg(){
		initComponents();
	}
	
	private void initComponents() {
		this.setDefaultCloseOperation(3);
		this.setTitle("Registration");
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

		lbl1 = new JLabel("Sign Up");
		lbl1.setForeground(Color.WHITE);
		lbl1.setBounds(143,131,85,24);
		lbl1.setFont(fnt1);
		c.add(lbl1);
		
		lbl2 = new JLabel("Full Name: ");
		lbl2.setForeground(Color.WHITE);
		lbl2.setBounds(34,207,80,17);
		lbl2.setFont(fnt2);
		c.add(lbl2);
		
		tfName = new JTextField();
		tfName.setBounds(120,207,221,17);
		tfName.setForeground(Color.WHITE);
		tfName.setFont(fnt2);
		tfName.setBackground(Color.BLACK);
		tfName.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfName);
		
		lbl3 = new JLabel("Email: ");
		lbl3.setForeground(Color.WHITE);
		lbl3.setBounds(34,249,75,17);
		lbl3.setFont(fnt2);
		c.add(lbl3);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(120,249,221,17);
		tfEmail.setForeground(Color.WHITE);
		tfEmail.setFont(fnt2);
		tfEmail.setBackground(Color.BLACK);
		tfEmail.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfEmail);
		
		lbl4 = new JLabel("Username: ");
		lbl4.setForeground(Color.WHITE);
		lbl4.setBounds(34,291,80,17);
		lbl4.setFont(fnt2);
		c.add(lbl4);
		
		tfUName = new JTextField();
		tfUName.setBounds(120,291,221,17);
		tfUName.setForeground(Color.WHITE);
		tfUName.setFont(fnt2);
		tfUName.setBackground(Color.BLACK);
		tfUName.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(tfUName);
		
		lbl5 = new JLabel("Password: ");
		lbl5.setForeground(Color.WHITE);
		lbl5.setBounds(34,333,75,17);
		lbl5.setFont(fnt2);
		c.add(lbl5);
		
		pf = new JPasswordField();
		pf.setBounds(120,333,221,17);
		pf.setForeground(Color.WHITE);
		pf.setFont(fnt2);
		pf.setBackground(Color.BLACK);
		pf.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.WHITE));
		c.add(pf);
		
		btnSignUP = new JButton("Sign Up");
		btnSignUP.setBounds(104,402,166,31);
		btnSignUP.setFocusPainted(false);
		btnSignUP.setCursor(cursor);
		btnSignUP.setFont(fnt3);
		btnSignUP.setBackground(Color.WHITE);
		c.add(btnSignUP);
		
		lbl6 = new JLabel("Alredy Signed Up?");
		lbl6.setBounds(83,467,140,17);
		lbl6.setForeground(Color.WHITE);
		lbl6.setFont(fnt2);
		c.add(lbl6);
		
		lbl7 = new JLabel("Login Here");
		lbl7.setBounds(212,467,128,17);
		lbl7.setForeground(Color.WHITE);
		lbl7.setFont(fnt2);
		lbl7.setCursor(cursor);
		Font lbl7Fnt = lbl7.getFont();
		Map attributes = lbl7Fnt.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		lbl7.setFont(lbl7Fnt.deriveFont(attributes));
		c.add(lbl7);
		
		btnSignUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String validation = EmailValidation.validateEmail(tfEmail.getText());
				
				if(tfName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your Name!");
				}
				
				else if(tfEmail.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your Email!");
				}
				
				else if(tfUName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your Username!");
				}
				else if(pf.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "You have not entered your Password!");
				}
				else if(validation.equals("invalid")) {
					JOptionPane.showMessageDialog(null, "Enter your email in correct format!");
				}
				else {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ftm","root", "");
						
						String query = "INSERT INTO `userinfo`(`Name`, `Email`, `Username`, `Password`) VALUES (?,?,?,?)";
						
						PreparedStatement ps = cn.prepareStatement(query);
						ps.setString(1 , tfName.getText());
                        ps.setString(2, tfEmail.getText());
                        ps.setString(3, tfUName.getText());
                        ps.setString(4, pf.getText());
                        
                        ps.executeUpdate();
                        UserLogIn newFrame = new UserLogIn();
                        dispose();
                        newFrame.setVisible(true);
                        ps.close();
                        cn.close();
						
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		lbl7.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				UserLogIn newFrame1 = new UserLogIn();
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
		UserReg f = new UserReg();
		f.setVisible(true);

	}

}
